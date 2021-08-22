package com.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.client.entity.Client;
import com.client.repo.ClientRepository;

@Component
public class SignupValidator  implements Validator{

	@Autowired
	ClientRepository  clientRepository;
	@Override
	public boolean supports(Class<?> clazz) {
		 return Client.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Client client=(Client)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.error");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.error");
		
		if(clientRepository.findByEmail(client.getEmail()) !=null) {
			errors.rejectValue("email", "duplicate.email");
		}
		
	}

}
