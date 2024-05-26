package com.bayard7523.kpac.domain.service.impl;

import com.bayard7523.kpac.domain.service.KnowledgePackageService;
import com.bayard7523.kpac.model.KnowledgePackage;
import com.bayard7523.kpac.persistence.dao.KnowledgePackageDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultKnowledgePackageService implements KnowledgePackageService {

	private final KnowledgePackageDAO knowledgePackageDAO;

	public DefaultKnowledgePackageService(KnowledgePackageDAO knowledgePackageDAO) {
		this.knowledgePackageDAO = knowledgePackageDAO;
	}

	@Override
	public List<KnowledgePackage> getAll() {
		return knowledgePackageDAO.getAll();
	}

	@Override
	public Optional<Integer> save(KnowledgePackage knowledgePackage) {
		return knowledgePackageDAO.save(knowledgePackage);
	}

	@Override
	public Optional<KnowledgePackage> getById(int id) {
		return knowledgePackageDAO.findById(id);
	}

	@Override
	public boolean existsById(int id) {
		return knowledgePackageDAO.existsById(id);
	}

	@Override
	public boolean existsByTitle(String title) {
		return knowledgePackageDAO.existsByTitle(title);
	}

	@Override
	public void deleteById(Integer id) {
		knowledgePackageDAO.deleteById(id);
	}
}
