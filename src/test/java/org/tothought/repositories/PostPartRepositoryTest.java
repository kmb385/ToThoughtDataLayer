package org.tothought.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tothought.entities.PostPart;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PostPartRepositoryTest {

	@Autowired
	private PostPartRepository repository;

	@Test
	public void findOneTest(){
		String body = "This is the first test";
		PostPart postPart = repository.findOne(1);
		
		assertNotNull(postPart);
		assertEquals(body, postPart.getBody());
	}
	
	@Test
	public void insertTest() {
		PostPart postPart = new PostPart();
		String body = "This is a test";
		
		postPart.setBody(body);

		repository.save(postPart);

		PostPart dbPostPart = repository.findOne(postPart.getPostPartId());
		assertNotNull(dbPostPart);
		assertEquals(body,dbPostPart.getBody());
	}
	
	@Test
	public void updateTest(){
		String body = "This is the update test";

		PostPart postPart = repository.findOne(1);
		postPart.setBody(body);
		repository.save(postPart);
		
		PostPart dbPostPart = repository.findOne(1);
		assertNotNull(dbPostPart);
		assertEquals(body, dbPostPart.getBody());
	}
	
	@Test
	public void deleteTest(){
		List<PostPart> postParts = repository.findByBody("delete");
		assertNotNull(postParts);
		assertEquals(1, postParts.size());
		
		repository.delete(postParts.get(0));
		
		List<PostPart> dbPostPart = repository.findByBody("delete");
		assertEquals(0,dbPostPart.size());
		
	}

	@Test
	public void findByBodyTest() {
		List<PostPart> dbPostParts = repository.findByBody("his is my test");
		assertNotNull(dbPostParts);
		assertEquals(2, dbPostParts.size());
	}

}
