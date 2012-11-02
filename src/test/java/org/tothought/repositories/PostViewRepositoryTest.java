package org.tothought.repositories;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.entities.PostView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class PostViewRepositoryTest {

	@Autowired
	PostViewRepository repository;

	@Test
	public void findAllTest() {
		List<PostView> posts = repository.findAll();
		
		assertNotNull(posts);
		assertTrue(posts.size() > 0);
	}
	
	@Test
	public void findAllPageableTest(){
		Page<PostView> page = repository.findAll(new PageRequest(1,2));
		List<PostView> posts = page.getContent();

		assertNotNull(posts);
		assertTrue(posts.size() == 2);
		assertTrue(posts.get(0).getTags().size() > 0);
		assertTrue(page.getSize() == 2);
	}
	
	@Test
	public void findOneTest(){
		PostView post = repository.findOne(1);
		
		assertNotNull(post);
	}
	
}
