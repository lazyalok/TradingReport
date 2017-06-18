package com.trading.report.calculator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trading.report.model.Instruction;
import com.trading.report.model.Request;
import com.trading.report.model.SettlementDate;
import com.trading.report.workingdays.WorkingDaysChecker;

public final class IncomingAndOutgoingReportingCalculator {

	public Map<SettlementDate, BigDecimal> calculateTradeAmountPerDayWithIncomingBuyOption(List<Request> requests) {

		Map<SettlementDate, BigDecimal> totalIncomingBuyAmountPerDay = new HashMap<SettlementDate, BigDecimal>();

		for (Request request : requests) {
			if (request.getInstruction() == Instruction.BUY) {
				getTotalAmountAndWorkingDaysLogic(totalIncomingBuyAmountPerDay, request);
			}
		}
		return totalIncomingBuyAmountPerDay;

	}

	public Map<SettlementDate, BigDecimal> calculateTradeAmountPerDayWithOutgoingSellOption(List<Request> requests) {

		Map<SettlementDate, BigDecimal> totalIncomingBuyAmountPerDay = new HashMap<SettlementDate, BigDecimal>();

		for (Request request : requests) {
			if (request.getInstruction() == Instruction.SELL) {
				getTotalAmountAndWorkingDaysLogic(totalIncomingBuyAmountPerDay, request);
			}
		}
		return totalIncomingBuyAmountPerDay;

	}

	private void getTotalAmountAndWorkingDaysLogic(Map<SettlementDate, BigDecimal> totalIncomingBuyAmountPerDay,
			Request request) {
		if (WorkingDaysChecker.isSettlementDateInNonWorkingDays(request.getCurrency(), request.getSettlementDate())) {
			request.setNewSettlementDate(getNextSettlementDate(request));
		}

		getTotalAmountPerDay(totalIncomingBuyAmountPerDay, request);
	}

	private Map<SettlementDate, BigDecimal> getTotalAmountPerDay(
			Map<SettlementDate, BigDecimal> totalIncomingBuyAmountPerDay, Request request) {

		if (totalIncomingBuyAmountPerDay.get(request.getSettlementDate()) != null) {
			BigDecimal amount = totalIncomingBuyAmountPerDay.get(request.getSettlementDate());
			totalIncomingBuyAmountPerDay.put(request.getSettlementDate(),
					new TradeAmountCalculator().tradeAmountCalulator(request.getAmount()).add(amount));
		} else {
			totalIncomingBuyAmountPerDay.put(request.getSettlementDate(),
					new TradeAmountCalculator().tradeAmountCalulator(request.getAmount()));
		}

		return totalIncomingBuyAmountPerDay;
	}

	private SettlementDate getNextSettlementDate(Request request) {
		return WorkingDaysChecker.getNextWorkingSettlementDate(request.getCurrency(), request.getSettlementDate());
	}
}