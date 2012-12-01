package org.tothought.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.entities.Degree;

public interface DegreeRepository extends JpaRepository<Degree, Integer> {

}
