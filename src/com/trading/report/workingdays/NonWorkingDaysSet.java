package com.trading.report.workingdays;

import java.time.DayOfWeek;
import java.util.EnumSet;

public final class NonWorkingDaysSet {

	public static final EnumSet<DayOfWeek> nonWOrkingDaysArab = EnumSet.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);
	public static final EnumSet<DayOfWeek> nonWOrkingDaysOther = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);

}
