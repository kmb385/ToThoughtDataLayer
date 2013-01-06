package org.tothought.repositories;

import org.springframework.data.repository.Repository;
import org.tothought.views.RecentDataLoadLogEntry;

public interface RecentDataLoadLogEntryRepository extends Repository<RecentDataLoadLogEntry, Integer> {

	public RecentDataLoadLogEntry findByLoadName(String loadName);
}
