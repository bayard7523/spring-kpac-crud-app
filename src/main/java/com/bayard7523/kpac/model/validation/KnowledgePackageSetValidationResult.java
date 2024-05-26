package com.bayard7523.kpac.model.validation;

import com.bayard7523.kpac.controller.request.KnowledgePackageSetCreationRequest;

import static com.bayard7523.kpac.component.validator.impl.KnowledgePackageSetValidator.TITLE_MAX_LENGTH;

public class KnowledgePackageSetValidationResult implements ValidationResult {
	private boolean emptyTitle;
	private boolean titleTooLong;

	public KnowledgePackageSetValidationResult(KnowledgePackageSetCreationRequest creationRequest) {
		validateTitle(creationRequest);
	}

	private void validateTitle(KnowledgePackageSetCreationRequest creationRequest) {
		final String title = creationRequest.getTitle();

		if (title == null || title.isEmpty()) {
			emptyTitle = true;
		}

		if (title != null && title.length() > TITLE_MAX_LENGTH) {
			titleTooLong = true;
		}
	}

	public boolean isEmptyTitle() {
		return emptyTitle;
	}

	public boolean isTitleTooLong() {
		return titleTooLong;
	}

	@Override
	public boolean isValid() {
		return !emptyTitle && !titleTooLong;
	}
}
