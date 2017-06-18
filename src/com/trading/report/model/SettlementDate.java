package com.trading.report.model;

import java.time.LocalDate;

public final class SettlementDate {

	private final LocalDate settlementDate;

	public SettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}

	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	@Override
	public String toString() {
		return "SettlementDate [settlementDate=" + settlementDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((settlementDate == null) ? 0 : settlementDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SettlementDate other = (SettlementDate) obj;
		if (settlementDate == null) {
			if (other.settlementDate != null)
				return false;
		} else if (!settlementDate.equals(other.settlementDate))
			return false;
		return true;
	}

}
