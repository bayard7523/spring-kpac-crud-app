package com.bayard7523.kpac.exception;

public class KnowledgePackageNotFoundException extends RuntimeException {

	public KnowledgePackageNotFoundException(int id) {
		super("Knowledge package with id: " + id + " not found");
	}
}
