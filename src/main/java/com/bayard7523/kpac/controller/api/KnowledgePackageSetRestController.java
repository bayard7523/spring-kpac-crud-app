package com.bayard7523.kpac.controller.api;

import com.bayard7523.kpac.component.exception.ValidationException;
import com.bayard7523.kpac.component.validator.impl.KnowledgePackageSetValidator;
import com.bayard7523.kpac.component.validator.impl.KnowledgePackageValidator;
import com.bayard7523.kpac.controller.request.KnowledgePackageSetCreationRequest;
import com.bayard7523.kpac.domain.service.KnowledgePackageSetService;
import com.bayard7523.kpac.exception.KnowledgePackageAlreadyExistsException;
import com.bayard7523.kpac.exception.KnowledgePackageSetAlreadyExistsException;
import com.bayard7523.kpac.exception.KnowledgePackageSetNotFoundException;
import com.bayard7523.kpac.model.KnowledgePackageSet;
import com.bayard7523.kpac.model.validation.ValidationResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sets")
public class KnowledgePackageSetRestController {

	private final KnowledgePackageSetService knowledgePackageSetService;
	private final KnowledgePackageSetValidator knowledgePackageSetValidator;

	public KnowledgePackageSetRestController(KnowledgePackageSetService knowledgePackageSetService,
	                                         KnowledgePackageSetValidator knowledgePackageSetValidator) {
		this.knowledgePackageSetService = knowledgePackageSetService;
		this.knowledgePackageSetValidator = knowledgePackageSetValidator;
	}

	@GetMapping("all")
	public List<KnowledgePackageSet> getAll() {
		return knowledgePackageSetService.getAll();
	}

	@GetMapping("{id}")
	public KnowledgePackageSet getById(@PathVariable("id") Integer id) {
		return knowledgePackageSetService.getById(id).orElseThrow(() -> new KnowledgePackageSetNotFoundException(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> saveKnowledgePackageSet(@RequestBody KnowledgePackageSetCreationRequest creationRequest) {
		if (knowledgePackageSetService.existsByTitle(creationRequest.getTitle())) {
			throw new KnowledgePackageSetAlreadyExistsException(creationRequest.getTitle());
		}

		try {
			knowledgePackageSetValidator.validate(creationRequest);
		} catch (ValidationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getValidationResult());
		}

		final Optional<Integer> idO = knowledgePackageSetService.save(creationRequest);

		if (idO.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(idO.get());
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Integer id) {
		knowledgePackageSetService.deleteById(id);
	}
}
