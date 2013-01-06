package org.tothought.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tothought.entities.DataLoadLogEntry;
import org.tothought.repositories.utils.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/spring/test-context.xml"})
public class DataLoadLogEntryRepositoryTest {

	@Autowired
	DataLoadLogEntryRepository repository;
	
	@Test
	public void findOneTest(){
		DataLoadLogEntry dlle = repository.findOne(1);
		assertNotNull(dlle);
		assertEquals("GITHUB",dlle.getLoadName());
	}
	
	@Test
	public void insertTest() {
		DataLoadLogEntry dlle = TestUtil.createDataLoadLogEntry();
		repository.save(dlle);
		
		DataLoadLogEntry dbDlle = repository.findOne(dlle.getDataLoadLogEntryId());
		assertNotNull(dbDlle);
		assertEquals("GITHUB", dbDlle.getLoadName());
	}
	
	@Test
	public void updateTest(){
		String name = "STACKOVERFLOW";
		
		DataLoadLogEntry dlle = repository.findOne(1);
		dlle.setLoadName(name);
		
		repository.save(dlle);
		
		DataLoadLogEntry dbDlle = repository.findOne(dlle.getDataLoadLogEntryId());
		assertNotNull(dbDlle);
		assertEquals(name, dbDlle.getLoadName());

	}
	
	@Test
	public void deleteTest(){
		DataLoadLogEntry dlle = repository.findOne(2);
		repository.delete(dlle);
		
		assertNull(repository.findOne(2));
	}

}
