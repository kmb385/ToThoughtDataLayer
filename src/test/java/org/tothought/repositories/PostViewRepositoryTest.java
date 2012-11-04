package org.tothought.repositories;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger logger = LoggerFactory.getLogger(PostViewRepository.class);
	
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
	
	@Test
	public void findByTagIdTest(){
		Page<PostView> page = repository.findByTag(1, new PageRequest(0,2));
		List<PostView> postViews = page.getContent();
		
		assertNotNull(postViews);
		logger.info("Page Size is " + postViews.size());
		assertTrue(postViews.size() == 2);

		PostView postView = postViews.get(0);
		assertTrue(postView.getTags().get(0).getTagId() == 1);
	}
	
}
