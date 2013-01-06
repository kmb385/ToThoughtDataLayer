package org.tothought.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.entities.Commit;
import org.tothought.entities.Tag;
import org.tothought.repositories.utils.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/spring/test-context.xml"})
@Transactional
public class CommitRepositoryTest {

	@Autowired
	private CommitRepository repository;
	
	@Autowired
	TagRepository tagRepository;
	
	@Test
	public void findOneTest(){
		Commit commit= repository.findOne(1);
		assertNotNull(commit);
		assertEquals("htmlUrl1", commit.getHtmlUrl());
	}
	
	@Test
	public void insertTest() {

		Tag tag = tagRepository.findOne(1);
		Commit commit = TestUtil.createCommit();
		commit.getTags().add(tag);

		repository.save(commit);
		Commit dbCommit = repository.findOne(commit.getCommitId());
		assertNotNull(dbCommit);
		assertEquals("Saving Entities", dbCommit.getTitle());
	}
	
	@Test
	public void updateTest(){
		String title = "Title 2";
		Commit commit = repository.findOne(1);
		
		commit.setTitle(title);
		repository.save(commit);
		
		Commit dbCommit = repository.findOne(commit.getCommitId());
		assertNotNull(dbCommit);
		assertEquals(title, dbCommit.getTitle());
	}
	
	@Test
	public void deleteTest(){
		Commit commit = repository.findOne(2);
		repository.delete(commit);
		
		assertNull(repository.findOne(2));
	}

}
