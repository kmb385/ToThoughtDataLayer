package org.tothought.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.entities.DataLoadLogEntry;

public interface DataLoadLogEntryRepository extends JpaRepository<DataLoadLogEntry, Integer> {

}
