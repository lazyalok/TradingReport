package com.trading.report.calculator;

import java.math.BigDecimal;

import com.trading.report.model.TradeAmount;

public final class TradeAmountCalculator {

	public BigDecimal tradeAmountCalulator(TradeAmount amount) {
		return calculateAmount(amount);
	}

	private BigDecimal calculateAmount(TradeAmount amount) {
		return amount.getAgreedFx()
				.multiply(BigDecimal.valueOf(amount.getUnit()))
				.multiply(amount.getPricePerUnit());
	}

}
