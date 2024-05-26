package com.bayard7523.kpac.exception;

public class KnowledgePackageSetNotFoundException extends RuntimeException {

	public KnowledgePackageSetNotFoundException(int id) {
		super("Knowledge package set with id: " + id + " not found");
	}
}
