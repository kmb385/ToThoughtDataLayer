package org.tothought.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tothought.entities.Commit;

public interface CommitRepository extends JpaRepository<Commit, Integer> {

	public Commit findBySha(String sha);
	
	@Query("select c from Commit c join c.tags t where t.name = :tagName order by c.commitDt desc")
	public List<Commit> findByTag(@Param("tagName") String tagName);
	
	@Query("select c from Commit c join c.tags t where t.name = :tagName order by c.commitDt desc")
	public Page<Commit> pageByTag(@Param("tagName") String tagName, Pageable pageable);

}