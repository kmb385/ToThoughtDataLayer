package org.tothought.repositories;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.entities.SkillCategory;
import org.tothought.repositories.utils.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class SkillCategoryRepositoryTest {

	@Autowired
	SkillCategoryRepository repository;
	
	@Test
	public void findOneTest() {
		SkillCategory skillCategory = repository.findOne(1);
		assertNotNull(skillCategory);
		assertEquals("Programming Skills", skillCategory.getName());
		assertNotNull(skillCategory.getSkills());
	}
	
	@Test
	public void testInsert(){
		SkillCategory skillCategory = TestUtil.createSkillCategory();
		
		repository.save(skillCategory);
		
		SkillCategory dbSkillCategory = repository.findOne(skillCategory.getSkillCategoryId());
		assertNotNull(dbSkillCategory);
		assertEquals("Software", dbSkillCategory.getName());
	}
	
	@Test
	public void testUpdate(){
		SkillCategory skillCategory = repository.findOne(2);
		skillCategory.setName("Expertise");
		repository.save(skillCategory);
		
		SkillCategory dbSkillCategory = repository.findOne(2);
		assertNotNull(dbSkillCategory);
		assertEquals("Expertise", dbSkillCategory.getName());
	}
	
	@Test
	public void testDelete(){
		SkillCategory skillCategory = repository.findOne(2);
		repository.delete(skillCategory);
		
		SkillCategory dbSkillCategory = repository.findOne(2);
		assertNull(dbSkillCategory);
	}

}
