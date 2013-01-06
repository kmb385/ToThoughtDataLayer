package org.tothought.views;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="V_TAG")
public class TagView {

	@Id
	@Column(name="TAG_ID")
	public Integer tagId;
	
	@Column(name="COUNT", columnDefinition="bigint")
	public Integer count;
	
	@Column(name="NAME")
	public String name;
	
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
