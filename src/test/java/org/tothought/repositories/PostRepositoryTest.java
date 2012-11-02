package org.tothought.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.entities.Post;
import org.tothought.entities.PostPart;
import org.tothought.entities.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class PostRepositoryTest {
	
	@Autowired
	private PostRepository repository;
	
	@Autowired 
	TagRepository tagRepository;
	
	@Test
	public void findOneTest() {
		Post post = repository.findOne(1);
		assertNotNull(post);
		assertTrue(post.getTags().size()>1);
	}
	
	@Test
	public void findByTagname(){
		List<Post> posts = repository.findByTag("Spring");
		
		assertNotNull(posts);
		assertEquals(2, posts.size());
	}
	
	@Test
	public void insertPostTest(){
		String body = "This is the post part";
		Post post = new Post();
		PostPart postPart = new PostPart();
		
		post.setAuthor("Kevin");
		post.setPostedDt(new Date());
		post.setTitle("This is a new post");
		postPart.setBody(body);
		post.setPostPart(postPart);
		
		repository.save(post);
		
		Post dbPost = repository.findOne(post.getPostId());
		assertNotNull(dbPost);
		assertEquals(body, dbPost.getPostPart().getBody());
	}
	
	@Test
	public void insertPostTest2(){
		String body = "This is the post part";
		String tagName = "SQL";
		Post post = new Post();
		PostPart postPart = new PostPart();
		Tag tag = new Tag();
		
		post.setAuthor("Kevin");
		post.setPostedDt(new Date());
		post.setTitle("This is a new post");
		
		tag.setName(tagName);
		post.getTags().add(tag);
		
		postPart.setBody(body);
		post.setPostPart(postPart);
		
		repository.save(post);

		
		Post dbPost = repository.findOne(post.getPostId());
		assertNotNull(dbPost);
		assertEquals(body, dbPost.getPostPart().getBody());
		assertEquals(tagName, dbPost.getTags().get(0).getName());
		
		List<Tag> dbTags = tagRepository.findByName(tagName);
		assertNotNull(dbTags);
		assertTrue(dbTags.size() == 1);
	}
	
	@Test
	public void updatePost(){
		String title = "This is an updated post";
		
		Post post = repository.findOne(2);
		post.setTitle(title);
		repository.save(post);
		
		Post dbPost = repository.findOne(post.getPostId());
		assertNotNull(dbPost);
		assertEquals(title, dbPost.getTitle());
	}
	
	@Test
	public void deletePost(){
		Post post = repository.findOne(4);
		repository.delete(post);
		
		Post dbPost = repository.findOne(post.getPostId());
		assertNull(dbPost);
	}

}
