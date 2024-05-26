package com.bayard7523.kpac.component.exception;

import com.bayard7523.kpac.model.validation.ValidationResult;

public class ValidationException extends RuntimeException {

	private final ValidationResult validationResult;

	public ValidationException(ValidationResult validationResult) {
		this.validationResult = validationResult;
	}

	public ValidationException(String message, ValidationResult validationResult) {
		super(message);
		this.validationResult = validationResult;
	}

	public ValidationException(String message, Throwable cause, ValidationResult validationResult) {
		super(message, cause);
		this.validationResult = validationResult;
	}

	public ValidationException(Throwable cause, ValidationResult validationResult) {
		super(cause);
		this.validationResult = validationResult;
	}

	public ValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ValidationResult validationResult) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.validationResult = validationResult;
	}

	public ValidationResult getValidationResult() {
		return validationResult;
	}
}
