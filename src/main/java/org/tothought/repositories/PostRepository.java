package org.tothought.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.entities.Post;

@Transactional
public interface PostRepository extends JpaRepository<Post, Integer> {

	@Query("select p from Post p join p.tags t where t.name = :name")
	public List<Post> findByTag(@Param("name") String name);
}
