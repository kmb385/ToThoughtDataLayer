package org.tothought.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SKILL_CATEGORY")
public class SkillCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SKILL_CATEGORY_ID")
	private Integer skillCategoryId;
	
	@Column(name="NAME")
	private String name;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="skillCategory", fetch=FetchType.LAZY)
	public List<Skill> skills = new ArrayList<Skill>();
	
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

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skillCategoryId == null) ? 0 : skillCategoryId.hashCode());
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
		SkillCategory other = (SkillCategory) obj;
		if (skillCategoryId == null) {
			if (other.skillCategoryId != null)
				return false;
		} else if (!skillCategoryId.equals(other.skillCategoryId))
			return false;
		return true;
	}
	
}
