package com.reebbok.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReebokController {
	@GetMapping("hello")
	public String get() {
		return "hello world!";
	}
}
