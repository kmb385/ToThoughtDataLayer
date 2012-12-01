package org.tothought.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.entities.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

}
