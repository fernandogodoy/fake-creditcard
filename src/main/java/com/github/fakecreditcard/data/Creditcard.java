package com.github.fakecreditcard.data;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Creditcard {

	private String number;

	private String holderName;

	private String cvv;

	private String expDate;
	
	private String expirationYear;
	
	private String expirationMonth;

}
