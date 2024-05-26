package com.bayard7523.kpac.controller;

import com.bayard7523.kpac.domain.service.KnowledgePackageSetService;
import com.bayard7523.kpac.exception.KnowledgePackageNotFoundException;
import com.bayard7523.kpac.model.KnowledgePackageSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class KnowledgePackageSetViewController {

	private final KnowledgePackageSetService knowledgePackageSetService;

	public KnowledgePackageSetViewController(KnowledgePackageSetService knowledgePackageSetService) {
		this.knowledgePackageSetService = knowledgePackageSetService;
	}

	@GetMapping("/sets")
	public String indexAll() {
		return "sets/all";
	}

	@GetMapping("/set/{id}")
	public String index(@PathVariable(value = "id", required = true) Integer id, Model model) {

		final Optional<KnowledgePackageSet> knowledgePackageSetO = knowledgePackageSetService.getById(id);

		if (knowledgePackageSetO.isEmpty()) {
			throw new KnowledgePackageNotFoundException(id);
		}

		model.addAttribute("title", knowledgePackageSetO.get().getTitle());

		return "sets/index";
	}
}
