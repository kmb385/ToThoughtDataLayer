package org.tothought.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tothought.entities.StackOverflowAnswer;

public interface StackOverflowAnswerRepository extends JpaRepository<StackOverflowAnswer, Integer>{
	
	@Query("select a from StackOverflowAnswer a join a.tags t where t.name = :tagName order by a.createdDt desc")
	public List<StackOverflowAnswer> findByTag(@Param("tagName") String tagName);
	
	@Query("select a from StackOverflowAnswer a join a.tags t where t.name = :tagName order by a.createdDt desc")
	public Page<StackOverflowAnswer> pageByTag(@Param("tagName") String tagName, Pageable pageable);

}
