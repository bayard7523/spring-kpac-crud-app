package com.bayard7523.kpac.domain.service.impl;

import com.bayard7523.kpac.controller.request.KnowledgePackageSetCreationRequest;
import com.bayard7523.kpac.domain.service.KnowledgePackageSetService;
import com.bayard7523.kpac.model.KnowledgePackageSet;
import com.bayard7523.kpac.persistence.dao.KnowledgePackageSetDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultKnowledgePackageSetService implements KnowledgePackageSetService {

	private final KnowledgePackageSetDAO knowledgePackageSetDAO;

	public DefaultKnowledgePackageSetService(KnowledgePackageSetDAO knowledgePackageSetDAO) {
		this.knowledgePackageSetDAO = knowledgePackageSetDAO;
	}

	@Override
	public List<KnowledgePackageSet> getAll() {
		return knowledgePackageSetDAO.getAll();
	}

	@Override
	public Optional<KnowledgePackageSet> getById(int id) {
		return knowledgePackageSetDAO.getById(id);
	}

	@Override
	public Optional<Integer> save(KnowledgePackageSetCreationRequest creationRequest) {
		return knowledgePackageSetDAO.save(creationRequest);
	}

	@Override
	public boolean existsById(int id) {
		return knowledgePackageSetDAO.existsById(id);
	}

	@Override
	public boolean existsByTitle(String title) {
		return knowledgePackageSetDAO.existsByTitle(title);
	}

	@Override
	public void deleteById(int id) {
		knowledgePackageSetDAO.deleteById(id);
	}
}
