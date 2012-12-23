package org.tothought.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.tothought.entities.Comment;

public class CommentValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Comment.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "author.empty");
		ValidationUtils.rejectIfEmpty(errors, "body", "body.empty");

	}

}
