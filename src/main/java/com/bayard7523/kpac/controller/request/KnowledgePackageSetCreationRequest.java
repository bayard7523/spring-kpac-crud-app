package com.bayard7523.kpac.controller.request;

import java.util.List;

public class KnowledgePackageSetCreationRequest {
	private String title;
	private List<Integer> knowledgePackages;

	public KnowledgePackageSetCreationRequest() {
	}

	public KnowledgePackageSetCreationRequest(String title, List<Integer> knowledgePackages) {
		this.title = title;
		this.knowledgePackages = knowledgePackages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Integer> getKnowledgePackages() {
		return knowledgePackages;
	}

	public void setKnowledgePackages(List<Integer> knowledgePackages) {
		this.knowledgePackages = knowledgePackages;
	}
}
