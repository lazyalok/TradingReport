package com.trading.report.workingdays;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import com.trading.report.model.Currency;
import com.trading.report.model.SettlementDate;

public class WorkingDaysCheckerTest {

	@Test
	public void shouldReturnTrueWhenArabTradeSettlementDateIsInNonWorkingDays() {

		boolean status = WorkingDaysChecker.isSettlementDateInNonWorkingDays(Currency.AED,
				new SettlementDate(LocalDate.of(2017, 06, 16)));

		assertEquals(true, status);
	}

	@Test
	public void shouldReturnTrueWhenOtherTradeSettlementDateIsInNonWorkingDays() {

		boolean status = WorkingDaysChecker.isSettlementDateInNonWorkingDays(Currency.EUR,
				new SettlementDate(LocalDate.of(2017, 06, 18)));

		assertEquals(true, status);
	}

	@Test
	public void shouldReturnCorrectNextWorkingSettlementDateIfArabTradeFallsOnSaturday() {

		SettlementDate settlementDate = WorkingDaysChecker.getNextWorkingSettlementDate(Currency.AED,
				new SettlementDate(LocalDate.of(2017, 06, 17)));

		assertEquals(LocalDate.of(2017, 06, 18), settlementDate.getSettlementDate());
	}

	@Test
	public void shouldReturnCorrectNextWorkingSettlementDateIfArabTradeFallsOnFriday() {

		SettlementDate settlementDate = WorkingDaysChecker.getNextWorkingSettlementDate(Currency.SGP,
				new SettlementDate(LocalDate.of(2017, 06, 16)));

		assertEquals(LocalDate.of(2017, 06, 18), settlementDate.getSettlementDate());
	}

	@Test
	public void shouldReturnCorrectNextWorkingSettlementDateIfOtherTradeFallsOnSunday() {

		SettlementDate settlementDate = WorkingDaysChecker.getNextWorkingSettlementDate(Currency.USD,
				new SettlementDate(LocalDate.of(2017, 06, 18)));

		assertEquals(LocalDate.of(2017, 06, 19), settlementDate.getSettlementDate());
	}

	@Test
	public void shouldReturnCorrectNextWorkingSettlementDateIfOtherTradeFallsOnSaturday() {

		SettlementDate settlementDate = WorkingDaysChecker.getNextWorkingSettlementDate(Currency.USD,
				new SettlementDate(LocalDate.of(2017, 06, 17)));

		assertEquals(LocalDate.of(2017, 06, 19), settlementDate.getSettlementDate());
	}
}
