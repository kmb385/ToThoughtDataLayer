package org.tothought.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.tothought.entities.interfaces.SkillDetail;
import org.tothought.jackson.DateSerializer;

@Entity
@Table(name = "COMMIT")
public class Commit implements SkillDetail{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMMIT_ID")
	private Integer commitId;

	@Column(name = "TITLE")
	private String title;

	@Column(name="MESSAGE", columnDefinition="longtext")
	private String message;
	
	@Column(name = "API_URL")
	private String apiUrl;

	@Column(name = "HTML_URL")
	private String htmlUrl;

	@Column(name = "SHA")
	private String sha;

	@Column(name="COMMIT_DT")
	private Date commitDt;
	
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, targetEntity = Tag.class)
	@JoinTable(name = "COMMIT_TAG", joinColumns = { @JoinColumn(name = "COMMIT_ID", referencedColumnName = "COMMIT_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "TAG_ID", referencedColumnName = "TAG_ID") })
	private List<Tag> tags = new ArrayList<Tag>();

	@Transient
	private Pattern TITLE_REGEX = Pattern.compile("^(?:\\d+\\.\\s|\\s*)([^\\[]+)");

	@Transient
	private static final String GITHUB_DOMAIN = "http://www.github.com/";

	@Transient
	private static final String GITHUB_API_DOMAIN = "https://api.github.com/";

	public Commit() {

	}

	public Commit(RepositoryCommit commit, String token) {
		this.message = token;
		this.title = this.cleanseTitle(token);
		this.apiUrl = commit.getUrl();
		this.htmlUrl = this.cleanseUrl(this.apiUrl);
		this.sha = commit.getSha();
		this.commitDt = commit.getCommit().getCommitter().getDate();
	}

	public Integer getCommitId() {
		return commitId;
	}

	public void setCommitId(Integer commitId) {
		this.commitId = commitId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String url) {
		this.apiUrl = url;
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public String getSha() {
		return sha;
	}

	public void setSha(String sha) {
		this.sha = sha;
	}
	
	public Date getCommitDt() {
		return commitDt;
	}

	public void setCommitDt(Date commitDt) {
		this.commitDt = commitDt;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	private String cleanseTitle(String title) {
		Matcher m = TITLE_REGEX.matcher(title);
		if (m.find()) {
			return m.group(1).trim();
		}

		return title;
	}

	private String cleanseUrl(String apiUrl) {
		return apiUrl.replace(GITHUB_API_DOMAIN, GITHUB_DOMAIN).replace("repos/", "").replace("git/", "")
				.replace("commits", "commit");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commitId == null) ? 0 : commitId.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((sha == null) ? 0 : sha.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commit other = (Commit) obj;
		if (commitId == null) {
			if (other.commitId != null)
				return false;
		} else if (!commitId.equals(other.commitId))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (sha == null) {
			if (other.sha != null)
				return false;
		} else if (!sha.equals(other.sha))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public Integer getId() {
		return this.commitId;
	}

	public String getUrl() {
		return this.htmlUrl;
	}
	
	@JsonSerialize(using=DateSerializer.class)
	public Date getCreatedDt() {
		return this.getCommitDt();
	}
	
}
