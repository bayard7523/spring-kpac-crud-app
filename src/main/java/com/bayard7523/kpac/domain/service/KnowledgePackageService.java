package com.bayard7523.kpac.domain.service;

import com.bayard7523.kpac.model.KnowledgePackage;

import java.util.List;
import java.util.Optional;

public interface KnowledgePackageService {

	List<KnowledgePackage> getAll();

	Optional<Integer> save(KnowledgePackage knowledgePackage);

	Optional<KnowledgePackage> getById(int id);

	boolean existsById(int id);

	boolean existsByTitle(String title);

	void deleteById(Integer id);
}
