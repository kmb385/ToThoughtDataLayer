package org.tothought.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tothought.entities.Image;
import org.tothought.repositories.utils.TestUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class ImageRepositoryTest {
	
	@Autowired
	ImageRepository repository;
	
	File file = new File("./src/test/resources/images/java.png");
	
	@Test
	public void findOneTest(){
		Image image = repository.findOne(1);
		assertNotNull(image);
		assertEquals("Java.png", image.getName());
	}
	
	@Test
	public void testInsert() throws IOException {
		Image image = TestUtil.createImage();	
		repository.save(image);
		
		Image dbImage = repository.findOne(image.getImageId());
		assertNotNull(dbImage);
		assertEquals(file.getName(), dbImage.getName());
		assertNotNull(dbImage.getFile());
	}

	@Test
	public void updateTest() throws IOException{
	
		Image image = repository.findOne(1);
		image.setFile(FileUtils.readFileToByteArray(file));
		image.setName("test.png");
		
		repository.save(image);
		
		Image dbImage = repository.findOne(1);
		assertNotNull(dbImage);
		assertEquals("test.png", dbImage.getName());
		assertNotNull(dbImage.getFile());
	}
	
	@Test
	public void deleteTest(){
		Image image = repository.findOne(2);
		repository.delete(image);
		
		Image dbImage = repository.findOne(2);
		assertNull(dbImage);
	}

}
