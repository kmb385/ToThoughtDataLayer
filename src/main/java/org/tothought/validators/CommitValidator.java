package org.tothought.validators;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.tothought.entities.Commit;

public class CommitValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Commit.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "commitTitle.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "htmlUrl", "htmlUrl.empty");
	}

}
