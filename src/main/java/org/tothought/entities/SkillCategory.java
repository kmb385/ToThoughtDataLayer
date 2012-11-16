package org.tothought.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SKILL_CATEGORY")
public class SkillCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SKILL_CATEGORY_ID")
	private Integer skillCategoryId;
	
	@Column(name="Name")
	private String name;

	public Integer getSkillCategoryId() {
		return skillCategoryId;
	}

	public void setSkillCategoryId(Integer skillCategoryId) {
		this.skillCategoryId = skillCategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
