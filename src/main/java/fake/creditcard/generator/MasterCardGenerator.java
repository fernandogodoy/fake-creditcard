package fake.creditcard.generator;

import java.util.concurrent.atomic.AtomicInteger;

public class MasterCardGenerator extends AbstractCardGenerator {

	@Override
	protected String getFillStarter() {
		return "5";
	}

	@Override
	protected int getFillDigitSum() {
		return 1;
	}

	@Override
	protected int maxRange() {
		return 13;
	}

	@Override
	protected boolean applyLunhFactor(int index) {
		return index % 2 == 0;
	}

	@Override
	protected void preConfig(StringBuilder sb, AtomicInteger digitSum) {
		int digit = generateRandomDigit();
		sb.append(digit);
		digitSum.addAndGet(digit);
	}

}
