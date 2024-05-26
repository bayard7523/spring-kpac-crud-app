package com.bayard7523.kpac.component.validator.impl;

import com.bayard7523.kpac.component.exception.ValidationException;
import com.bayard7523.kpac.component.validator.Validator;
import com.bayard7523.kpac.controller.request.KnowledgePackageSetCreationRequest;
import com.bayard7523.kpac.model.KnowledgePackageSet;
import com.bayard7523.kpac.model.validation.KnowledgePackageSetValidationResult;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackageSetValidator implements Validator<KnowledgePackageSetCreationRequest> {

	public final static int TITLE_MAX_LENGTH = 250;

	@Override
	public void validate(KnowledgePackageSetCreationRequest validateMe) throws ValidationException {
		final KnowledgePackageSetValidationResult result = new KnowledgePackageSetValidationResult(validateMe);

		if (!result.isValid()) {
			throw new ValidationException(result);
		}
	}
}
