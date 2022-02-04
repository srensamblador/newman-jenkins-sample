package com.srensamblador.dummywebserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Basic controller that returns text
 * 
 */
@RestController
public class HelloWorldController {

	@GetMapping("/")
	public String home() {
		return "Hello world!";
	}
}
