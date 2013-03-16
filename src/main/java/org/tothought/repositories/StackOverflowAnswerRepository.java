package org.tothought.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.entities.StackOverflowAnswer;

public interface StackOverflowAnswerRepository extends JpaRepository<StackOverflowAnswer, Integer>{

}
