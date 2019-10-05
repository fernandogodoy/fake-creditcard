package fake.creditcard.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LuhnTest {

	private Luhn luhn;

	private static final String AURA = "5090955735189370";
	private static final String HIPER = "6062825021306875";
	private static final String VOYAGER = "869970687660716";
	private static final String JCB = "3564047136150284";
	private static final String ENROUTE = "214916233852127";
	private static final String DISCOVER = "6011537455363965";
	private static final String DINERS = "38647293111179";
	private static final String AMEX = "349197230599270";
	private static final String VISA = "4485320155635251";
	private static final String MASTER = "5335732618376324";

	@BeforeEach
	public void init() {
		luhn = new Luhn();
	}

	@Test
	void shoulReturnTruForValidNumber() {
		assertTrue(luhn.isValid(MASTER));
		assertTrue(luhn.isValid(VISA));
		assertTrue(luhn.isValid(AMEX));
		assertTrue(luhn.isValid(DINERS));
		assertTrue(luhn.isValid(DISCOVER));
		assertTrue(luhn.isValid(ENROUTE));
		assertTrue(luhn.isValid(JCB));
		assertTrue(luhn.isValid(VOYAGER));
		assertTrue(luhn.isValid(HIPER));
		assertTrue(luhn.isValid(AURA));
	}

	@Test
	void shouldReturnVisa() {
		String generate = luhn.generate();
		assertTrue(luhn.isValid(generate));
	}

}
