package com.bayard7523.kpac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kpacs")
public class KnowledgePackageViewController {

	@GetMapping
	public String index(Model model) {
		return "kpacs/index";
	}

}
