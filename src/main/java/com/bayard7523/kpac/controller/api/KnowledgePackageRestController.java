package com.bayard7523.kpac.controller.api;

import com.bayard7523.kpac.component.exception.ValidationException;
import com.bayard7523.kpac.component.validator.impl.KnowledgePackageValidator;
import com.bayard7523.kpac.domain.service.KnowledgePackageService;
import com.bayard7523.kpac.exception.KnowledgePackageAlreadyExistsException;
import com.bayard7523.kpac.exception.KnowledgePackageNotFoundException;
import com.bayard7523.kpac.model.KnowledgePackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kpacs")
public class KnowledgePackageRestController {

	private final KnowledgePackageService knowledgePackageService;
	private final KnowledgePackageValidator knowledgePackageValidator;

	public KnowledgePackageRestController(KnowledgePackageService knowledgePackageService,
	                                      KnowledgePackageValidator knowledgePackageValidator) {
		this.knowledgePackageService = knowledgePackageService;
		this.knowledgePackageValidator = knowledgePackageValidator;
	}

	@GetMapping("/all")
	public List<KnowledgePackage> getKnowledgePackages() {
		return knowledgePackageService.getAll();
	}

	@GetMapping("{id}")
	public KnowledgePackage getById(@PathVariable("id") Integer id) {
		return knowledgePackageService.getById(id).orElseThrow(() -> new KnowledgePackageNotFoundException(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> saveKnowledgePackage(@RequestBody KnowledgePackage knowledgePackage) {
		if (knowledgePackageService.existsByTitle(knowledgePackage.getTitle())) {
			throw new KnowledgePackageAlreadyExistsException(knowledgePackage.getTitle());
		}

		try {
			knowledgePackageValidator.validate(knowledgePackage);
		} catch (ValidationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getValidationResult());
		}

		final Optional<Integer> idO = knowledgePackageService.save(knowledgePackage);

		if (idO.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(idO.get());
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteKnowledgePackage(@PathVariable("id") Integer id) {
		knowledgePackageService.deleteById(id);
	}
}
