package io.github.fernandogodoy.fkcard.validator;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Luhn {

	public boolean isValid(String cardNumber) {
		final AtomicInteger sum = new AtomicInteger(0);
		final AtomicBoolean skip = new AtomicBoolean(false);
		IntStream.iterate(cardNumber.length() - 1, next -> next - 1)
				.limit(cardNumber.length())
				.forEach(index -> {
					int number = Character.getNumericValue(cardNumber.charAt(index));
					if (skip.get()) {
						number *= 2;
						if (number > 9) {
							number = (number % 10) + 1;
						}
					}
					sum.addAndGet(number);
					skip.compareAndSet(skip.get(), !skip.get());
				});
		return sum.get() % 10 == 0;
	}

}
