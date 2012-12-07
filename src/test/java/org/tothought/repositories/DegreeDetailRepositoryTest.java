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
import org.tothought.entities.Degree;
import org.tothought.entities.DegreeDetail;
import org.tothought.repositories.utils.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/spring/test-context.xml"})
@Transactional
public class DegreeDetailRepositoryTest {

	@Autowired
	private DegreeDetailRepository repository;

	@Test
	public void findOneTest() {
		DegreeDetail detail = repository.findOne(1);
		assertNotNull(detail);
		assertEquals("Dean's List 5 Semesters", detail.getDescription());
	}
	
	@Test
	public void insertTagTest() {
		DegreeDetail detail = TestUtil.createDegreeDetail();
		
		repository.save(detail);

		DegreeDetail dbDetail = repository.findOne(detail.getDegreeDetailId());
		assertNotNull(dbDetail);
		assertEquals("this is a test", dbDetail.getDescription());
	}

	@Test
	public void updateTagTest() {
		String description = "Phi Lambda Pi honor society";
		
		DegreeDetail detail = repository.findOne(1);
		detail.setDescription(description);

		DegreeDetail dbDetail = repository.findOne(detail.getDegreeDetailId());
		assertNotNull(dbDetail);
		assertEquals(description, dbDetail.getDescription());
	}

	@Test
	public void deleteTagTest() {
		DegreeDetail detail = repository.findOne(2);
		repository.delete(detail);

		DegreeDetail dbDetail = repository.findOne(detail.getDegreeDetailId());
		assertNull(dbDetail);
	}
}
