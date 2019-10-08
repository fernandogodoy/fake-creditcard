package fake.creditcard.generator;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public abstract class AbstractCardGenerator implements CreditCardGenerator {

	protected abstract String getFillStarter();

	protected abstract int getFillDigitSum();

	protected abstract int maxRange();

	protected abstract boolean applyLunhFactor(int index);
	
	protected abstract void preConfig(StringBuilder sb, AtomicInteger digitSum);

	@Override
	public String generate() {
		final StringBuilder sb = new StringBuilder(getFillStarter());
		final AtomicInteger digitSum = new AtomicInteger(getFillDigitSum());
		preConfig(sb, digitSum);
		IntStream.range(0, maxRange()).forEach(index -> {
			int randomDigit = generateRandomDigit();
			sb.append(randomDigit);
			if (applyLunhFactor(index)) {
				randomDigit *= 2;
				randomDigit = verifyLunhFactor(randomDigit);
			}
			digitSum.addAndGet(randomDigit);
		});
		sb.append(getLastDigit(digitSum));
		return sb.toString();
	}

	protected int generateRandomDigit() {
		int randomDigit = (int) Math.floor(Math.random() * 10);
		return randomDigit;
	}

	private int verifyLunhFactor(int randomDigit) {
		if (randomDigit > 9) {
			randomDigit -= 9;
		}
		return randomDigit;
	}

	private int getLastDigit(final AtomicInteger digitSum) {
		int lastDigit = 10 - (digitSum.get() % 10);
		if (digitSum.get() % 10 == 0) {
			lastDigit = 0;
		}
		return lastDigit;
	}

}
