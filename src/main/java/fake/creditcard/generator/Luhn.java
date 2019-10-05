package fake.creditcard.generator;

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

	public String generate() {
		final StringBuilder sb = new StringBuilder("4");
		final AtomicInteger visaDigSum = new AtomicInteger(8);
		IntStream.range(0, 14).forEach(index -> {
			int randomDigit = (int) Math.floor(Math.random() * 10);
			sb.append(randomDigit);
			if (index % 2 == 1) {
				randomDigit *= 2;
				if (randomDigit > 9) {
					randomDigit -= 9;
				}
			}
			visaDigSum.addAndGet(randomDigit);
		});
		int lastDigit = 10 - (visaDigSum.get() % 10);
		if (visaDigSum.get() % 10 == 0) {
			lastDigit = 0;
		}
		sb.append(lastDigit);
		return sb.toString();
	}
}
