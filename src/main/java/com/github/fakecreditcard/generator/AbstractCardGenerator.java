package com.github.fakecreditcard.generator;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public abstract class AbstractCardGenerator implements CreditCardGenerator {

	private StringBuilder sb;
	private AtomicInteger digitSum;

	protected abstract String getFillStarter();

	protected abstract int getFillDigitSum();

	protected abstract int maxRange();

	protected abstract boolean applyMultiplication(int index);

	protected void appendDigit(Integer digit) {
		sb.append(digit);
	}

	protected void sumDigit(Integer digit) {
		digitSum.addAndGet(digit);
	}

	protected void before() {
		sb = new StringBuilder(getFillStarter());
		digitSum = new AtomicInteger(getFillDigitSum());
	}

	@Override
	public String generate() {
		before();
		executeLoop();
		after();
		return sb.toString();
	}

	private void after() {
		int lastDigit = getLastDigit();
		appendDigit(lastDigit);
	}

	private void executeLoop() {
		IntStream.range(0, maxRange()).forEach(index -> {
			int randomDigit = getRandomDigit();
			appendDigit(randomDigit);
			if (applyMultiplication(index)) {
				randomDigit *= 2;
				randomDigit = verifyLunhFactor(randomDigit);
			}
			sumDigit(randomDigit);
		});
	}

	protected int getRandomDigit() {
		return (int) Math.floor(Math.random() * 10);
	}

	private int verifyLunhFactor(int randomDigit) {
		if (randomDigit > 9) {
			return randomDigit -= 9;
		}
		return randomDigit;
	}

	private int getLastDigit() {
		int lastDigit = 10 - (digitSum.get() % 10);
		if (digitSum.get() % 10 == 0) {
			return 0;
		}
		return lastDigit;
	}

}
