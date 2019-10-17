package com.github.fakecreditcard.data;

import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import com.github.fakecreditcard.util.RandomDigit;

/**
 * 
 * @author Fernando
 *
 */
public class ExpirationDate {

	private String fullDate;

	private int year;

	private int month;

	public ExpirationDate() {
		final YearMonth yearMonth = createDate();
		this.fullDate = yearMonth.format(DateTimeFormatter.ofPattern("yyyy/MM"));
	}

	public String getFullDate() {
		return fullDate;
	}

	public String getYear() {
		return String.valueOf(year);
	}

	public String getMonth() {
		return String.valueOf(month);
	}

	private YearMonth createDate() {
		YearMonth yearMonth;
		do {
			Year now = Year.now();
			year = RandomDigit.build().createRandomNumberBetween(now.getValue(), now.plusYears(4).getValue()).intValue();
			month = RandomDigit.build().createRandomNumberBetween(1, 12).intValue();
			yearMonth = YearMonth.of(year, month);
		} while (yearMonth.isBefore(YearMonth.now()));
		return yearMonth;
	}
}
