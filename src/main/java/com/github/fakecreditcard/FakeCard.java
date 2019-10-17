package com.github.fakecreditcard;

import com.github.fakecreditcard.data.Creditcard;
import com.github.fakecreditcard.data.ExpirationDate;
import com.github.fakecreditcard.data.HolderName;
import com.github.fakecreditcard.data.SecurityCode;
import com.github.fakecreditcard.generator.Brand;

/**
 * 
 * @author Fernando
 *
 */
public class FakeCard {

	private Brand brand;

	private HolderName holderName;

	private ExpirationDate expDate;
	
	private SecurityCode securityCode;

	private FakeCard(Brand brand) {
		this.brand = brand;
		this.holderName = new HolderName();
		this.expDate = new ExpirationDate();
		this.securityCode = new SecurityCode();
	}

	public Creditcard createCard() {
		return Creditcard.builder()
				.number(brand.generate())
				.holderName(holderName.getName())
				.cvv(securityCode.getValue())
				.expDate(expDate.getFullDate())
				.expirationMonth(expDate.getMonth())
				.expirationYear(expDate.getYear())
				.build();
	}

	public static FakeCard visa() {
		return new FakeCard(Brand.VISA);
	}

	public static FakeCard master() {
		return new FakeCard(Brand.MASTER);
	}

}
