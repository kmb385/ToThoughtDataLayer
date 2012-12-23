package org.tothought.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
