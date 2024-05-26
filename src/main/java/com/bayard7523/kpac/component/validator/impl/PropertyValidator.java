package com.bayard7523.kpac.component.validator.impl;

import com.bayard7523.kpac.component.validator.Validator;
import com.bayard7523.kpac.component.exception.ValidationException;
import com.bayard7523.kpac.model.validation.ValidationResult;
import org.springframework.stereotype.Component;

import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class PropertyValidator implements Validator<Properties> {

	final static String[] REQUIRED_PROPERTIES = new String[]{
			"database.url",
			"database.username",
			"database.password",
			"database.driver",
	};

	@Override
	public void validate(Properties validateMe) throws ValidationException {
		final String missingProperties = Stream.of(REQUIRED_PROPERTIES)
				.filter(propertyName -> validateMe.getProperty(propertyName) == null)
				.collect(Collectors.joining(","));

		if (missingProperties.isEmpty()) return;

		throw new ValidationException("Missing required properties: " + missingProperties, null);
	}
}
