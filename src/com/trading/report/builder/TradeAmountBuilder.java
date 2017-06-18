package com.trading.report.builder;

import java.math.BigDecimal;

import com.trading.report.model.TradeAmount;

public final class TradeAmountBuilder {

	private BigDecimal agreedFx;
	private Integer unit;
	private BigDecimal pricePerUnit;

	private TradeAmountBuilder() {
	}

	public static TradeAmountBuilder aTradeAmountBuilder() {
		return new TradeAmountBuilder();
	}

	public TradeAmountBuilder withAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
		return this;
	}

	public TradeAmountBuilder withUnit(Integer unit) {
		this.unit = unit;
		return this;
	}

	public TradeAmountBuilder withPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
		return this;
	}

	public TradeAmount build() {
		return new TradeAmount(agreedFx, unit, pricePerUnit);
	}
}
