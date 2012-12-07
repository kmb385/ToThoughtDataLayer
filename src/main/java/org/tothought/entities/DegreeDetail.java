package org.tothought.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DEGREE_DETAIL")
public class DegreeDetail {

	@Id
	@Column(name = "DEGREE_DETAIL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer degreeDetailId;

	@Column(name = "DESCRIPTION", columnDefinition="longtext")
	private String description;

	@ManyToOne()
	@JoinColumn(name="DEGREE_ID")
	private Degree degree;
	
	public Integer getDegreeDetailId() {
		return degreeDetailId;
	}

	public void setDegreeDetailId(Integer degreeDetailId) {
		this.degreeDetailId = degreeDetailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}
}
