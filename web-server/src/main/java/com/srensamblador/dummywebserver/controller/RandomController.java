package com.srensamblador.dummywebserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srensamblador.dummywebserver.component.RandomGenerator;

/**
 * Controller for random operation requests
 *
 */
@RestController
public class RandomController {
	
	private RandomGenerator randomGenerator;
	
	@Autowired
	public RandomController(RandomGenerator randomGenerator) {
		this.randomGenerator = randomGenerator;
	}
	
	/**
	 * Returns a random integer
	 * @return random int
	 */
	@GetMapping("/random/int")
	public int getRandomInt() {
		return randomGenerator.randomInt();
	}
	
	/**
	 * Returns a random integer between two numbers
	 * @param lower lower bound
	 * @param higher upper bound
	 * @return random int within the bounds
	 */
	@GetMapping("/random/int/{lower}/{higher}")
	public int getRandomInt( @PathVariable Integer lower, @PathVariable Integer higher) {
		return randomGenerator.randomInt(lower, higher);
	}
	
	/**
	 * Chooses a random item from the provided list
	 * @param <T> type of the value
	 * @param values list of possible values
	 * @return chosen value
	 */
	@GetMapping("/random/choice")	
	public <T> T getRandomChoice(@RequestParam T[] values) {
		return randomGenerator.randomChoice(values);		
	}
	
	/**
	 * Error handling
	 * @param ex exception thrown
	 * @return error response
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	private ResponseEntity<String> handleException(IllegalArgumentException ex) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return ResponseEntity.status(status).body("Error " + status + ": " + ex.getMessage());
	}

}
