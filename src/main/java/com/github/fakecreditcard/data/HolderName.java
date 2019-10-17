package com.github.fakecreditcard.data;

import com.github.javafaker.Faker;

public class HolderName {

	private String name;

	public HolderName() {
		this.name = new Faker().name().fullName();
	}

	public String getName() {
		return name;
	}
}
