package org.tothought.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.entities.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class TagRepositoryTest {

	@Autowired
	private TagRepository repository;

	@Test
	public void findOneTest() {
		Tag tag = repository.findOne(1);
		assertNotNull(tag);
		assertEquals("Spring", tag.getName());
	}
	
	@Test
	public void findByNameTest(){
		List<Tag> tags = repository.findByName("spring");
		
		assertNotNull(tags);
		assertTrue(tags.size() ==2);
		
	}

	@Test
	public void insertTagTest() {
		String name = "Hibernate";
		Tag tag = new Tag();
		tag.setName(name);

		repository.save(tag);

		Tag dbTag = repository.findOne(tag.getTagId());
		assertNotNull(dbTag);
		assertEquals(name, dbTag.getName());
	}

	@Test
	public void updateTagTest() {
		String name = "J2EE";

		Tag tag = repository.findOne(2);
		tag.setName(name);

		Tag dbTag = repository.findOne(tag.getTagId());
		assertNotNull(dbTag);
		assertEquals(name, dbTag.getName());
	}

	@Test
	public void deleteTagTest() {
		Tag tag = repository.findOne(3);
		repository.delete(tag);

		Tag dbTag = repository.findOne(tag.getTagId());
		assertNull(dbTag);

	}
}
