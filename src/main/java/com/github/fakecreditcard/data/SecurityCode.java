package com.github.fakecreditcard.data;

import com.github.fakecreditcard.util.RandomDigit;

/**
 * 
 * @author Fernando
 *
 */
public class SecurityCode {

	private String value;

	public SecurityCode() {
		this.value = RandomDigit.build().createRandomNumberBetween(100, 999).stringValue();
	}

	public String getValue() {
		return value;
	}

}
