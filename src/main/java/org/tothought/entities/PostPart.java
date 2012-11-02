package org.tothought.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="POST_PART")
public class PostPart {

	@Id
	@Column(name="POST_PART_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer postPartId;
	
	@Column(name="BODY")
	String body;
	
	
	public Integer getPostPartId() {
		return postPartId;
	}
	public void setPostPartId(Integer postPartId) {
		this.postPartId = postPartId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	
	
}
