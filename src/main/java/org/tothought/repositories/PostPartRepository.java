package org.tothought.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.entities.PostPart;

@Repository
@Transactional
public interface PostPartRepository extends JpaRepository<PostPart, Integer> {
	
	@Query("select pp from PostPart pp where pp.body like '%' || :body || '%'")
	public List<PostPart> findByBody(@Param("body")String body);
}
