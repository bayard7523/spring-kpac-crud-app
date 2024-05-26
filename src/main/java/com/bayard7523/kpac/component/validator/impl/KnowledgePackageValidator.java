package com.bayard7523.kpac.component.validator.impl;

import com.bayard7523.kpac.component.exception.ValidationException;
import com.bayard7523.kpac.component.validator.Validator;
import com.bayard7523.kpac.model.KnowledgePackage;
import com.bayard7523.kpac.model.validation.KnowledgePackageValidationResult;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackageValidator implements Validator<KnowledgePackage> {
	public final static int TITLE_MAX_LENGTH = 250;
	public final static int DESCRIPTION_MAX_LENGTH = 2000;

	@Override
	public void validate(KnowledgePackage validateMe) throws ValidationException {
		final KnowledgePackageValidationResult result = new KnowledgePackageValidationResult(validateMe);

		if (!result.isValid()) {
			throw new ValidationException(result);
		}
	}
}
