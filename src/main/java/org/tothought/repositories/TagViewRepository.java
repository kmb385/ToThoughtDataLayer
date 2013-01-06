package org.tothought.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.views.TagView;


public interface TagViewRepository extends JpaRepository<TagView, Integer> {

}
