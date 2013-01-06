package org.tothought.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DATA_LOAD_LOG_ENTRY")
public class DataLoadLogEntry {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DATA_LOAD_LOG_ENTRY_ID")
	private Integer dataLoadLogEntryId;
	
	@Column(name="LOAD_NAME")
	private String loadName;
	
	@Column(name="RECORDS_ADDED")
	private Integer recordsAdded;
	
	@Column(name="DATA_CURRENT_DT")
	private Date dataCurrentDt;
	
	@Column(name="RUN_DT")
	private Date runDt;

	
	public DataLoadLogEntry() {

	}

	public DataLoadLogEntry(String loadName, Integer recordsAdded, Date dataCurrentDt) {
		this.loadName = loadName;
		this.recordsAdded = recordsAdded;
		this.dataCurrentDt = dataCurrentDt;
		this.runDt = new Date();
	}

	public Integer getDataLoadLogEntryId() {
		return dataLoadLogEntryId;
	}

	public void setDataLoadLogEntryId(Integer dataLoadLogEntryId) {
		this.dataLoadLogEntryId = dataLoadLogEntryId;
	}

	public String getLoadName() {
		return loadName;
	}

	public void setLoadName(String loadName) {
		this.loadName = loadName;
	}

	public Integer getRecordsAdded() {
		return recordsAdded;
	}

	public void setRecordsAdded(Integer recordsAdded) {
		this.recordsAdded = recordsAdded;
	}

	public Date getDataCurrentDt() {
		return dataCurrentDt;
	}

	public void setDataCurrentDt(Date dataCurrentDt) {
		this.dataCurrentDt = dataCurrentDt;
	}

	public Date getRunDt() {
		return runDt;
	}

	public void setRunDt(Date runDt) {
		this.runDt = runDt;
	}

}
