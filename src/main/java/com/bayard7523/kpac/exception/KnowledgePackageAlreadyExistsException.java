package com.bayard7523.kpac.exception;

public class KnowledgePackageAlreadyExistsException extends RuntimeException {

	public KnowledgePackageAlreadyExistsException(String title) {
		super("Knowledge package with such title already exists, title: " + title);
	}
}
