package org.tothought.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.entities.PostView;

@Transactional(readOnly = true)
public interface PostViewRepository extends JpaRepository<PostView, Integer> {

}
