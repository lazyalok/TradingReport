package com.trading.report.workingdays;

import com.trading.report.model.Currency;
import com.trading.report.model.SettlementDate;
import static com.trading.report.workingdays.NonWorkingDaysSet.nonWOrkingDaysArab;
import static com.trading.report.workingdays.NonWorkingDaysSet.nonWOrkingDaysOther;

import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;

public final class WorkingDaysChecker {

	public static boolean isSettlementDateInNonWorkingDays(Currency currency, SettlementDate settlementDate) {

		if (isArabCurrency(currency)) {

			return nonWOrkingDaysArab.stream()
					.anyMatch(day -> day == settlementDate.getSettlementDate().getDayOfWeek());
		}

		return nonWOrkingDaysOther.stream().anyMatch(day -> day == settlementDate.getSettlementDate().getDayOfWeek());
	}

	public static SettlementDate getNextWorkingSettlementDate(Currency currency, SettlementDate settlementDate) {

		if (isArabCurrency(currency)) {

			return getNextWorkingArabDays(settlementDate);

		}
		return getNextWorkingOthersDays(settlementDate);

	}

	private static SettlementDate getNextWorkingOthersDays(SettlementDate settlementDate) {
		return new SettlementDate(settlementDate.getSettlementDate().with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
	}

	private static SettlementDate getNextWorkingArabDays(SettlementDate settlementDate) {
		return new SettlementDate(settlementDate.getSettlementDate().with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));
	}

	private static boolean isArabCurrency(Currency currency) {

		if (currency == Currency.AED || currency == Currency.SGP) {
			return true;
		}

		return false;
	}

}
