package org.tothought.repositories;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.entities.TagView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class TagViewRepositoryTest {

	@Autowired
	TagViewRepository repository;
	
	@Test
	public void findAllTest() {
		Sort sort = new Sort(Direction.ASC, "name");
		List<TagView> tagViews = repository.findAll(sort);
		
		assertNotNull(tagViews);
		assertEquals(2, tagViews.size());
	}

}
