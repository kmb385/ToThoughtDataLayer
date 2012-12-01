package org.tothought.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EXPERIENCE_DETAIL")
public class ExperienceDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EXPERIENCE_DETAIL_ID")
	private Integer experienceDetailId;
	
	@Column(name="DESCRIPTION", columnDefinition="longtext")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="EXPERIENCE_ID")
	private Experience experience;

	public Integer getExperienceDetailId() {
		return experienceDetailId;
	}

	public void setExperienceDetailId(Integer experienceDetailId) {
		this.experienceDetailId = experienceDetailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((experienceDetailId == null) ? 0 : experienceDetailId.hashCode());
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
		ExperienceDetail other = (ExperienceDetail) obj;
		if (experienceDetailId == null) {
			if (other.experienceDetailId != null)
				return false;
		} else if (!experienceDetailId.equals(other.experienceDetailId))
			return false;
		return true;
	}
	
}
