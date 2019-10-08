package fake.creditcard.generator;

import java.util.concurrent.atomic.AtomicInteger;

public class VisaCardGenerator extends AbstractCardGenerator {

	@Override
	protected String getFillStarter() {
		return "4";
	}

	@Override
	protected int getFillDigitSum() {
		return 8;
	}

	@Override
	protected int maxRange() {
		return 14;
	}

	@Override
	protected boolean applyLunhFactor(int index) {
		return index % 2 == 1;
	}

	@Override
	protected void preConfig(StringBuilder sb, AtomicInteger digitSum) {}

}
