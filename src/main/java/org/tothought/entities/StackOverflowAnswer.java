package org.tothought.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.tothought.entities.interfaces.SkillDetail;
import org.tothought.jackson.DateSerializer;
import org.tothought.jackson.LongDateDeserializer;

@Entity
@Table(name = "STACK_OVERFLOW_ANSWER")
public class StackOverflowAnswer implements SkillDetail{

	@Id
	@Column(name = "STACK_OVERFLOW_ANSWER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer answerId;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "URL")
	private String url;

	@Column(name = "CREATED_DT")
	private Date createdDt;

	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, targetEntity = Tag.class)
	@JoinTable(name = "SO_ANSWER_TAG", joinColumns = { @JoinColumn(name = "STACK_OVERFLOW_ANSWER_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "TAG_ID") })
	private List<Tag> tags = new ArrayList<Tag>();

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("link")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@JsonSerialize(using=DateSerializer.class)
	@JsonDeserialize(using=LongDateDeserializer.class)
	@JsonProperty("creation_date")
	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	@JsonProperty("tags")
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-----------  Answer ---------").append("\n");
		sb.append("Answer Id: ").append(this.answerId).append("\n");
		sb.append("Link: ").append(this.url).append("\n");
		sb.append("Title: ").append(this.title).append("\n");
		sb.append("Tags").append("\n");
		for(Tag tag: this.getTags()){
			sb.append(tag.getName()).append("\n");
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerId == null) ? 0 : answerId.hashCode());
		result = prime * result + ((createdDt == null) ? 0 : createdDt.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		StackOverflowAnswer other = (StackOverflowAnswer) obj;
		if (answerId == null) {
			if (other.answerId != null)
				return false;
		} else if (!answerId.equals(other.answerId))
			return false;
		if (createdDt == null) {
			if (other.createdDt != null)
				return false;
		} else if (!createdDt.equals(other.createdDt))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	public Integer getId() {
		return this.answerId;
	}

}
