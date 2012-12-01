package org.tothought.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.entities.Experience;
import org.tothought.entities.ExperienceDetail;
import org.tothought.entities.Tag;
import org.tothought.repositories.utils.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class ExperienceRepositoryTest {
	
	@Autowired
	ExperienceRepository repository;
	
	
	@Test
	public void findOneTest(){
		Experience experience = repository.findOne(1);
		assertNotNull(experience);
		assertEquals("NAVSUP BSC", experience.getOrganization());
	}
	
	@Test
	public void testInsert() throws IOException {
		Experience experience = TestUtil.createExperience();

		repository.save(experience);
		
		Experience dbExperience = repository.findOne(experience.getExperienceId());
		assertNotNull(dbExperience);
		assertEquals(experience.getDescription(), dbExperience.getDescription());
		assertEquals(experience.getPosition(), dbExperience.getPosition());
	}
	
	@Test
	public void testInsertAdvanced() throws IOException {
		Tag tag = TestUtil.createTag();
		ExperienceDetail experienceDetail = TestUtil.createExperienceDetail();
		
		Experience experience = TestUtil.createExperience();;
		experience.getExperienceDetails().add(experienceDetail);
		experience.getTags().add(tag);
		
		repository.save(experience);
		
		Experience dbExperience = repository.findOne(experience.getExperienceId());
		assertNotNull(dbExperience);
		assertEquals(experience.getDescription(), dbExperience.getDescription());
		assertEquals(experience.getPosition(), dbExperience.getPosition());
		assertTrue(dbExperience.getTags().size()>0);
		assertTrue(dbExperience.getExperienceDetails().size() > 0);
		assertEquals(tag.getName(), experience.getTags().get(0).getName());
		assertEquals(experienceDetail.getDescription(), experience.getExperienceDetails().get(0).getDescription());
	}

	@Test
	public void updateTest() throws IOException{
		Tag tag = TestUtil.createTag();
		ExperienceDetail detail = TestUtil.createExperienceDetail();
		
		Experience experience = repository.findOne(1);
		int tagSize = experience.getTags().size();
		int detailsSize = experience.getExperienceDetails().size();
		
		experience.getTags().add(tag);
		experience.getExperienceDetails().get(0).setDescription("Test");
		experience.getExperienceDetails().add(detail);
		experience.setDescription("Test");
		
		repository.saveAndFlush(experience);
		
		Experience dbExperience = repository.findOne(experience.getExperienceId());
		assertNotNull(dbExperience);
		assertEquals(experience.getDescription(), dbExperience.getDescription());
		assertEquals(experience.getPosition(), dbExperience.getPosition());
		assertTrue(dbExperience.getTags().size() == tagSize + 1);
		assertTrue(dbExperience.getExperienceDetails().size() == detailsSize + 1);
	}
	
	@Test
	public void deleteTest(){
		Experience experience = repository.findOne(2);
		repository.delete(experience);
		
		assertNull(repository.findOne(2));
	}

}
