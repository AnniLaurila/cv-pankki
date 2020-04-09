package com.example.cvpankki.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.cvpankki.domain.User;

@Component
public class UserValidator implements Validator {
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUsername().length() < 4 || user.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordHash", "NotEmpty");
		if (user.getPasswordHash().length() < 4 || user.getPasswordHash().length() > 32) {
			errors.rejectValue("passwordHash", "Size.userForm.passwordHash");
		}

		if (!user.getPasswordConfirm().equals(user.getPasswordHash())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
	}
}
