package org.tothought.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.entities.Commit;

public interface CommitRepository extends JpaRepository<Commit, Integer> {

	public Commit findBySha(String sha);
}
