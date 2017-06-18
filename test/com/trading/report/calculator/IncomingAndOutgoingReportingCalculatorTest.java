package com.trading.report.calculator;

import static com.trading.report.builder.RequestBuilder.aRequestBuilder;
import static com.trading.report.builder.RequestsBuilder.aRequestsBuilder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.trading.report.model.Currency;
import com.trading.report.model.Entity;
import com.trading.report.model.Instruction;
import com.trading.report.model.InstructionDate;
import com.trading.report.model.Request;
import com.trading.report.model.SettlementDate;
import com.trading.report.model.TradeAmount;

public class IncomingAndOutgoingReportingCalculatorTest {

	@Test
	public void shouldReturnMapWithSingleEntryHavingSumOfTradeAmountPerDayForIncomingOption() {
		IncomingAndOutgoingReportingCalculator cal = new IncomingAndOutgoingReportingCalculator();

		Map<SettlementDate, BigDecimal> resultMap = cal.calculateTradeAmountPerDayWithIncomingBuyOption(getRequest());
		
		assertEquals(1, resultMap.size());
		assertEquals(BigDecimal.valueOf(8000), resultMap.get(new SettlementDate(LocalDate.of(2017, 06, 18))));

	}
	
	
	@Test
	public void shouldReturnMapWithSingleEntryHavingSumOfTradeAmountPerDayForOutgoingOption() {
		IncomingAndOutgoingReportingCalculator cal = new IncomingAndOutgoingReportingCalculator();

		Map<SettlementDate, BigDecimal> resultMap = cal.calculateTradeAmountPerDayWithOutgoingSellOption(getRequest());
		assertEquals(1, resultMap.size());
		
		// Expecting as null since in request SettlementDate falls in holiday(saturday) 
		//and by logic it will change to next working day.
		assertNull(resultMap.get(new SettlementDate(LocalDate.of(2017, 06, 17))));
		//next working day would be 19th.
		assertEquals(BigDecimal.valueOf(4000),resultMap.get(new SettlementDate(LocalDate.of(2017, 06, 19))));

	}

	private List<Request> getRequest() {

		return aRequestsBuilder()
				.add(aRequestBuilder()
						.withAmount(new TradeAmount(BigDecimal.valueOf(10), 10, BigDecimal.valueOf(20)))
						.withCurrency(Currency.EUR)
						.withEntity(new Entity("foo")).withInstruction(Instruction.SELL)
						.withInstructionDate(new InstructionDate(LocalDate.of(2017, 06, 16)))
						.withSettlementDate(new SettlementDate(LocalDate.of(2017, 06, 17))).build())
				
				.add(aRequestBuilder()
						.withAmount(new TradeAmount(BigDecimal.valueOf(10), 10, BigDecimal.valueOf(20)))
						.withCurrency(Currency.EUR)
						.withEntity(new Entity("fooman")).withInstruction(Instruction.SELL)
						.withInstructionDate(new InstructionDate(LocalDate.of(2017, 06, 16)))
						.withSettlementDate(new SettlementDate(LocalDate.of(2017, 06, 17))).build())


				.add(aRequestBuilder()
						.withAmount(new TradeAmount(BigDecimal.valueOf(20), 10, BigDecimal.valueOf(20)))
						.withCurrency(Currency.SGP).withEntity(new Entity("bar"))
						.withInstruction(Instruction.BUY)
						.withInstructionDate(new InstructionDate(LocalDate.of(2017, 06, 16)))
						.withSettlementDate(new SettlementDate(LocalDate.of(2017, 06, 18))).build())

				.add(aRequestBuilder()
						.withAmount(new TradeAmount(BigDecimal.valueOf(20), 10, BigDecimal.valueOf(20)))
						.withCurrency(Currency.AED)
						.withEntity(new Entity("foo1"))
						.withInstruction(Instruction.BUY)
						.withInstructionDate(new InstructionDate(LocalDate.of(2017, 06, 18)))
						.withSettlementDate(new SettlementDate(LocalDate.of(2017, 06, 18))).build())
				.build();
	}
}
