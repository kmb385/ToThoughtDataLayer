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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEGREE")
public class Degree {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DEGREE_ID")
	private Integer degreeId;

	@Column(name="INSTITUTION")
	private String institution;
	
	@Column(name="PROGRAM")
	private String program;
	
	@Column(name="EMPHASIS")
	private String emphasis;
	
	@Column(name="DEGREE_TYPE")
	private String degreeType;
	
	@Column(name="GPA")
	private String gpa;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="END_DATE")
	private Date endDate;
	
	@Column(name="IS_PRESENT", columnDefinition="tinyint")
	private boolean isPresent;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="DEGREE_ID")
	private List<DegreeDetail> degreeDetails = new ArrayList<DegreeDetail>();
	
	public Integer getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(Integer degreeId) {
		this.degreeId = degreeId;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getEmphasis() {
		return emphasis;
	}

	public void setEmphasis(String emphasis) {
		this.emphasis = emphasis;
	}

	public String getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(String degreeType) {
		this.degreeType = degreeType;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean getIsPresent() {
		return isPresent;
	}

	public void setIsPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	public List<DegreeDetail> getDegreeDetails() {
		return degreeDetails;
	}

	public void setDegreeDetails(List<DegreeDetail> details) {
		this.degreeDetails = details;
	}
	
}
