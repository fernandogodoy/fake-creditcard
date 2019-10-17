package com.github.fakecreditcard.util;

import java.util.Random;

/**
 * 
 * @author Fernando
 *
 */

public class RandomDigit {

	private int digit;

	public static RandomDigit build() {
		return new RandomDigit();
	}

	public RandomDigit createRandomNumberBetween(int start, int end) {
		this.digit = new Random().ints(start, end).findFirst().getAsInt();
		return this;
	}

	public int intValue() {
		return digit;
	}

	public String stringValue() {
		return String.valueOf(digit);
	}

}
