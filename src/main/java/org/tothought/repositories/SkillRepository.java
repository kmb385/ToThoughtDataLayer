package org.tothought.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.entities.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
