package com.bayard7523.kpac.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class KnowledgePackage {

	private Integer id;

	//250 chars
	private String title;

	//2000 chars
	private String description;

	//DD-MM-YYYY
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate createdAt;

	public KnowledgePackage() {
	}

	public KnowledgePackage(Integer id, String title, String description, LocalDate createdAt) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KnowledgePackage that)) return false;

		return Objects.equals(id, that.id)
				&& Objects.equals(title, that.title)
				&& Objects.equals(description, that.description)
				&& Objects.equals(createdAt, that.createdAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, description, createdAt);
	}

	@Override
	public String toString() {
		return "KnowledgePackage{" +
				"id=" + id +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", createdAt=" + createdAt +
				'}';
	}
}
