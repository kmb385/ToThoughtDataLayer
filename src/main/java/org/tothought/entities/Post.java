package org.tothought.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="POST")
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="POST_ID")
	Integer postId;
	
	@Column(name="TITLE")
	String title;
	
	@Column(name="AUTHOR")
	String author;
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="POST_PART_ID")
	PostPart postPart;
	
	@Column(name="POSTED_DT")
	Date postedDt;
	
	@ManyToMany(cascade={CascadeType.ALL}, targetEntity=Tag.class)
	@JoinTable(name="POST_TAG", joinColumns={@JoinColumn(name="POST_ID", referencedColumnName="POST_ID")},
	inverseJoinColumns={@JoinColumn(name="TAG_ID", referencedColumnName="TAG_ID")})
	public List<Tag> tags = new ArrayList<Tag>();

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public PostPart getPostPart() {
		return postPart;
	}

	public void setPostPart(PostPart postPart) {
		this.postPart = postPart;
	}

	public Date getPostedDt() {
		return postedDt;
	}

	public void setPostedDt(Date postedDt) {
		this.postedDt = postedDt;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((postId == null) ? 0 : postId.hashCode());
		result = prime * result
				+ ((postPart == null) ? 0 : postPart.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		Post other = (Post) obj;
		if (postId == null) {
			if (other.postId != null)
				return false;
		} else if (!postId.equals(other.postId))
			return false;
		if (postPart == null) {
			if (other.postPart != null)
				return false;
		} else if (!postPart.equals(other.postPart))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}	
}
