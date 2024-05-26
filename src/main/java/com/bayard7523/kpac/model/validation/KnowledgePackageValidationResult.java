package com.bayard7523.kpac.model.validation;

import com.bayard7523.kpac.component.validator.impl.KnowledgePackageValidator;
import com.bayard7523.kpac.model.KnowledgePackage;

import static com.bayard7523.kpac.component.validator.impl.KnowledgePackageValidator.DESCRIPTION_MAX_LENGTH;
import static com.bayard7523.kpac.component.validator.impl.KnowledgePackageValidator.TITLE_MAX_LENGTH;

public class KnowledgePackageValidationResult implements ValidationResult {
	private boolean emptyTitle;
	private boolean emptyDescription;
	private boolean titleTooLong;
	private boolean descriptionTooLong;

	public KnowledgePackageValidationResult(KnowledgePackage knowledgePackage) {
		validateTitle(knowledgePackage);
		validateDescription(knowledgePackage);
	}

	private void validateTitle(KnowledgePackage knowledgePackage) {
		final String title = knowledgePackage.getTitle();

		if (title == null || title.isEmpty()) {
			emptyTitle = true;
		}

		if (title != null && title.length() > TITLE_MAX_LENGTH) {
			titleTooLong = true;
		}
	}

	private void validateDescription(KnowledgePackage knowledgePackage) {
		final String description = knowledgePackage.getDescription();

		if (description == null || description.isEmpty()) {
			emptyDescription = true;
		}

		if (description != null && description.length() > DESCRIPTION_MAX_LENGTH) {
			descriptionTooLong = true;
		}
	}

	public boolean isEmptyTitle() {
		return emptyTitle;
	}

	public void setEmptyTitle(boolean emptyTitle) {
		this.emptyTitle = emptyTitle;
	}

	public boolean isEmptyDescription() {
		return emptyDescription;
	}

	public void setEmptyDescription(boolean emptyDescription) {
		this.emptyDescription = emptyDescription;
	}

	public boolean isTitleTooLong() {
		return titleTooLong;
	}

	public void setTitleTooLong(boolean titleTooLong) {
		this.titleTooLong = titleTooLong;
	}

	public boolean isDescriptionTooLong() {
		return descriptionTooLong;
	}

	public void setDescriptionTooLong(boolean descriptionTooLong) {
		this.descriptionTooLong = descriptionTooLong;
	}

	@Override
	public boolean isValid() {
		return !emptyTitle && !emptyDescription && !titleTooLong && !descriptionTooLong;
	}
}
