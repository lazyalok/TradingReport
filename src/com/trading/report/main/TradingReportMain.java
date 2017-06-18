package com.trading.report.main;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.trading.report.builder.ReportBuilder;
import com.trading.report.calculator.IncomingAndOutgoingReportingCalculator;
import com.trading.report.mock.MockData;
import com.trading.report.model.Request;
import com.trading.report.model.SettlementDate;

public final class TradingReportMain {

	public static void main(String[] args) {

		List<Request> requests = MockData.getMockRequest();

		IncomingAndOutgoingReportingCalculator calculator = new IncomingAndOutgoingReportingCalculator();
		Map<SettlementDate, BigDecimal> incomingReport = calculator
				.calculateTradeAmountPerDayWithIncomingBuyOption(requests);
		
		Map<SettlementDate, BigDecimal> outgoingReport = calculator
				.calculateTradeAmountPerDayWithOutgoingSellOption(requests);
		
		
		ReportBuilder.reportBuilder("INCOMING REPORT DATA (BUY OPTION)", incomingReport);
		ReportBuilder.reportBuilder("OUTGOING REPORT DATA (SELL OPTION)", outgoingReport);

	}
}
