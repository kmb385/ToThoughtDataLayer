package org.tothought.repositories;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tothought.entities.Comment;
import org.tothought.repositories.utils.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/spring/test-context.xml"})
public class CommentRepositoryTest {

	@Autowired
	private CommentRepository repository;

	@Autowired 
	PostRepository postRepository;
	
	@Test
	public void findOneTest(){
		Comment comment= repository.findOne(1);
		assertNotNull(comment);
		assertEquals("John Doe", comment.getAuthor());
	}
	
	@Test
	public void insertTest() {
		Comment comment = TestUtil.createComment();
		comment.setPost(postRepository.findOne(1));
		repository.save(comment);
		
		Comment dbComment = repository.findOne(comment.getCommentId());
		assertNotNull(dbComment);
		assertEquals("This post wasn't so great", dbComment.getBody());
	}
	
	@Test
	public void updateTest(){
		String author = "Jane Doe";
		Comment comment = repository.findOne(1);
		
		comment.setAuthor(author);
		repository.save(comment);
		
		Comment dbComment = repository.findOne(comment.getCommentId());
		assertNotNull(dbComment);
		assertEquals(author, dbComment.getAuthor());
	}
	
	@Test
	public void deleteTest(){
		Comment comment = repository.findOne(2);
		repository.delete(comment);
		
		assertNull(repository.findOne(2));
	}

}
