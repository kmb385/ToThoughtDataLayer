package org.tothought.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.views.PostView;

@Transactional(readOnly = true)
public interface PostViewRepository extends JpaRepository<PostView, Integer> {

	/**
	 * Return an ArrayList of PostView objects that correspond with the tagId parameter
	 * provided. 
	 * 
	 * Note that query must include select pv, if "from PostView" is used objects
	 * will not be properly typed and casting must occur.
	 * 
	 * @param tagId
	 * @return
	 */
	@Query("select pv from PostView pv join pv.tags tgs where tgs.tagId = :tagId")
	public Page<PostView> findByTag(@Param("tagId") Integer tagId, Pageable pageable);
}
