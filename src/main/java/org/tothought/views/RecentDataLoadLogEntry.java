package org.tothought.views;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_DATA_LOAD_LOG_ENTRY")
public class RecentDataLoadLogEntry {
	
	@Id
	@Column(name="DATA_LOAD_LOG_ENTRY_ID")
	private Integer dataLoadLogEntryId;
	
	@Column(name="LOAD_NAME")
	private String loadName;
	
	@Column(name="DATA_CURRENT_DT")
	private Date dataCurrentDt;
	
	@Column(name="RUN_DT")
	private Date runDt;

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
