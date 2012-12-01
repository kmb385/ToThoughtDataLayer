package org.tothought.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.entities.ExperienceDetail;
import org.tothought.repositories.utils.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class ExperienceDetailRepositoryTest {
	
	@Autowired
	ExperienceDetailRepository repository;
	
	
	@Test
	public void findOneTest(){
		ExperienceDetail detail = repository.findOne(1);
		assertNotNull(detail);
		assertEquals("I wrote a bunch of clean code.", detail.getDescription());
	}
	
	@Test
	public void testInsert() throws IOException {
		ExperienceDetail detail = TestUtil.createExperienceDetail();
		repository.save(detail);
		
		ExperienceDetail dbDetail = repository.findOne(detail.getExperienceDetailId());
		assertNotNull(dbDetail);
		assertEquals("I saved a bunch of money on my car insurance", detail.getDescription());
		
	}

	@Test
	public void updateTest() throws IOException{
		ExperienceDetail detail = repository.findOne(1);
		detail.setDescription("Test");
		repository.save(detail);
		
		ExperienceDetail dbDetail = repository.findOne(detail.getExperienceDetailId());
		assertNotNull(dbDetail);
		assertEquals("Test", dbDetail.getDescription());
	}
	
	@Test
	public void deleteTest(){
		ExperienceDetail detail = repository.findOne(2);
		repository.delete(detail);
		
		assertNull(repository.findOne(2));

	}

}
