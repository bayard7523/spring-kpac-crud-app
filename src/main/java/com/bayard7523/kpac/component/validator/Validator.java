package com.bayard7523.kpac.component.validator;

import com.bayard7523.kpac.component.exception.ValidationException;
import com.bayard7523.kpac.model.validation.ValidationResult;

public interface Validator<T> {

	void validate(T validateMe) throws ValidationException;
}
