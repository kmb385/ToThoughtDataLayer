package org.tothought.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.entities.StackOverflowAnswer;
import org.tothought.entities.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/spring/test-context.xml"})
@Transactional
public class StackOverflowAnswerRepositoryTest {

	@Autowired
	StackOverflowAnswerRepository repository;
	
	@Test
	public void findOneTest(){
		String title = "Configuring Spring";
		StackOverflowAnswer answer = repository.findOne(1);
		
		assertNotNull(answer);
		assertEquals(title, answer.getTitle());
	}
	
	@Test
	public void updateTest(){
		String title = "Running Junit Tests";
		StackOverflowAnswer answer = repository.findOne(1);
		
		answer.setTitle(title);
		
		repository.save(answer);
		
		StackOverflowAnswer dbAnswer = repository.findOne(answer.getAnswerId());
		assertNotNull(dbAnswer);
		assertEquals(title, dbAnswer.getTitle());
	}
	
	@Test
	public void insertTest() {
		final String title = "Configuring Hibernate";
		final String url = "http://www.google.com";
		Tag tag = new Tag();
		
		StackOverflowAnswer answer = new StackOverflowAnswer();
		
		tag.setName("Javascript");
		
		answer.setCreatedDt(new Date());
		answer.setTitle(title);
		answer.setUrl(url);
		
		answer.getTags().add(tag);
		
		repository.save(answer);
		
		StackOverflowAnswer dbAnswer = repository.findOne(answer.getAnswerId());
		assertNotNull(dbAnswer);
		assertEquals(title, dbAnswer.getTitle());
		assertEquals(url, dbAnswer.getUrl());
	}
	
	@Test
	public void deleteTest(){
		StackOverflowAnswer answer = repository.findOne(2);
		repository.delete(answer);
		
		StackOverflowAnswer dbAnswer = repository.findOne(2);
		assertNull(dbAnswer);
	}
}
