package com.srensamblador.dummywebserver.component;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * 
 * Random operations
 *
 */
@Component
public class RandomGenerator {
	
	private final Random rng; 
	
	public RandomGenerator() {
		rng = new Random();
	}
	
	/**
	 * Generates a random integer
	 * 
	 * @return random int >= 0
	 */
	public int randomInt() {
		return rng.nextInt();
	}
	
	/**
	 * Generates a random integer between two numbers 
	 * 
	 * @param lower lower bound
	 * @param higher upper bound
	 * @return random int within the specified bounds
	 */
	public int randomInt(final int lower, final int higher) throws IllegalArgumentException{
		if (lower > higher) {
			throw new IllegalArgumentException("Lower bound must be inferior or equal to the upper bound");
		}
		return rng.nextInt(higher-lower) + lower ; 
	}
	
	/**
	 * Picks a random element from an array of values
	 * @param <T> type of the values
	 * @param values values to pick from
	 * @return chosen value
	 */
	public <T> T randomChoice(final T[] values) throws IllegalArgumentException{
		if (values.length == 0) {
			throw new IllegalArgumentException("Values size cannot be zero");
		}
		return values[rng.nextInt(values.length)];
	}

}
