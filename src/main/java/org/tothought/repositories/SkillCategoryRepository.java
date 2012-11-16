package org.tothought.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tothought.entities.SkillCategory;

public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Integer> {

}
