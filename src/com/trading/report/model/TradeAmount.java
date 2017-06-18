package com.trading.report.model;

import java.math.BigDecimal;

public final class TradeAmount {

	private final BigDecimal agreedFx;
	private final Integer unit;
	private final BigDecimal pricePerUnit;

	public TradeAmount(BigDecimal agreedFx, Integer unit, BigDecimal pricePerUnit) {
		this.agreedFx = agreedFx;
		this.unit = unit;
		this.pricePerUnit = pricePerUnit;
	}

	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	public Integer getUnit() {
		return unit;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}
}
