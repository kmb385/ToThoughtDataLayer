package org.tothought.validators;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.tothought.entities.Degree;

import com.mysql.jdbc.StringUtils;

public class DegreeValidator implements Validator {
	
	private Pattern GPA_REGEX = Pattern.compile("^\\d{1}\\.\\d{1,2}$");
	
	public boolean supports(Class<?> clazz) {
		return Degree.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Degree degree = (Degree) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "institution", "institution.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "startDate.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "program", "program.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emphasis", "program.empty");
		
		if(degree.getEndDate() == null && degree.getIsPresent() == false){
			errors.rejectValue("endDate", "endDate.unspecified");
			errors.rejectValue("isPresent", "isPresent.unspecified");
		}
		
		if(!StringUtils.isNullOrEmpty(degree.getGpa()) && !GPA_REGEX.matcher(degree.getGpa()).matches()){
			errors.rejectValue("gpa", "gpa.invalid");
		}
		
		

		

	}

}
