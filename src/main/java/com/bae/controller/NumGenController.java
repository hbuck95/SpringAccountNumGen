package com.bae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.service.NumGenService;

@RestController
@RequestMapping("/numgen")
public class NumGenController {

	private NumGenService service;

	@Autowired
	public NumGenController(NumGenService service) {
		this.service = service;
	}

	@GetMapping
	public String generateAccountNumber() {
		return service.generateAccountNumber();
	}
}
