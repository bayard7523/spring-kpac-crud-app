package com.bayard7523.kpac.exception;

public class KnowledgePackageSetAlreadyExistsException extends RuntimeException {

	public KnowledgePackageSetAlreadyExistsException(String title) {
		super("Knowledge package set with such title already exists, title: " + title);
	}
}
