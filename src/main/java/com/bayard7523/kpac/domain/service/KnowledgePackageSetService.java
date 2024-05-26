package com.bayard7523.kpac.domain.service;

import com.bayard7523.kpac.controller.request.KnowledgePackageSetCreationRequest;
import com.bayard7523.kpac.model.KnowledgePackageSet;

import java.util.List;
import java.util.Optional;

public interface KnowledgePackageSetService {

	List<KnowledgePackageSet> getAll();

	Optional<KnowledgePackageSet> getById(int id);

	Optional<Integer> save(KnowledgePackageSetCreationRequest creationRequest);

	boolean existsById(int id);

	boolean existsByTitle(String title);

	void deleteById(int id);

}
