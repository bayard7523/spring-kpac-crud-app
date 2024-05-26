package com.bayard7523.kpac.model;

import java.util.List;
import java.util.Objects;

public class KnowledgePackageSet {

	private Integer id;

	private String title;

	private List<KnowledgePackage> knowledgePackages;

	public KnowledgePackageSet() {
	}

	public KnowledgePackageSet(Integer id, String title, List<KnowledgePackage> knowledgePackages) {
		this.id = id;
		this.title = title;
		this.knowledgePackages = knowledgePackages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<KnowledgePackage> getKnowledgePackages() {
		return knowledgePackages;
	}

	public void setKnowledgePackages(List<KnowledgePackage> knowledgePackages) {
		this.knowledgePackages = knowledgePackages;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KnowledgePackageSet that)) return false;

		return Objects.equals(id, that.id)
				&& Objects.equals(title, that.title)
				&& Objects.equals(knowledgePackages, that.knowledgePackages);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, knowledgePackages);
	}

	@Override
	public String toString() {
		return "KnowledgePackageSet{" +
				"id=" + id +
				", title='" + title + '\'' +
				", knowledgePackages=" + knowledgePackages +
				'}';
	}
}
