package fake.creditcard.generator;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CreditCardGenerator {

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
