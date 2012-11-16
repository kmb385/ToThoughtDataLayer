package org.tothought.repositories.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.tothought.entities.Image;
import org.tothought.entities.Skill;
import org.tothought.entities.SkillCategory;

public class TestUtil {

	public static Image createImage(){
		File file = new File("./src/test/resources/images/java.png");
		Image image = new Image();
		
		try {
			image.setFile(FileUtils.readFileToByteArray(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		image.setName(file.getName());
		image.setType(file.getName().substring(file.getName().lastIndexOf(".")));
		return image;
	}
	
	public static SkillCategory createSkillCategory(){
		SkillCategory skillCategory = new SkillCategory();
		skillCategory.setName("Software");
		return skillCategory;
	}
	
	public static Skill createSkill(){
		Skill skill = new Skill();
		skill.setName("Spring");
		skill.setDescription("A Java framework based on dependency injection");
		skill.setProvider("VMWare");
		skill.setRating(4);
		skill.setUrl("http://www.springsource.org");
		return skill;
	}
}
