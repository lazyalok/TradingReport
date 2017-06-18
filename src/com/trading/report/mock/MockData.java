package com.trading.report.mock;

import static com.trading.report.builder.RequestBuilder.aRequestBuilder;
import static com.trading.report.builder.RequestsBuilder.aRequestsBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.trading.report.model.Currency;
import com.trading.report.model.Entity;
import com.trading.report.model.Instruction;
import com.trading.report.model.InstructionDate;
import com.trading.report.model.Request;
import com.trading.report.model.SettlementDate;
import com.trading.report.model.TradeAmount;

public final class MockData {

	public static final List<Request> getMockRequest() {

		return aRequestsBuilder()
				
				.add(aRequestBuilder()
						.withAmount(new TradeAmount(BigDecimal.valueOf(20), 10, BigDecimal.valueOf(20)))
						.withCurrency(Currency.EUR)
						.withEntity(new Entity("foo"))
						.withInstruction(Instruction.SELL)
						.withInstructionDate(new InstructionDate(LocalDate.of(2017, 06, 14)))
						.withSettlementDate(new SettlementDate(LocalDate.of(2017, 06, 16)))
						.build())

				.add(aRequestBuilder()
						.withAmount(new TradeAmount(BigDecimal.valueOf(20), 10, BigDecimal.valueOf(20)))
						.withCurrency(Currency.SGP)
						.withEntity(new Entity("bar"))
						.withInstruction(Instruction.BUY)
						.withInstructionDate(new InstructionDate(LocalDate.of(2017, 06, 16)))
						.withSettlementDate(new SettlementDate(LocalDate.of(2017, 06, 18)))
						.build())

				.add(aRequestBuilder()
						.withAmount(new TradeAmount(BigDecimal.valueOf(30), 10, BigDecimal.valueOf(20)))
						.withCurrency(Currency.AED)
						.withEntity(new Entity("foo1"))
						.withInstruction(Instruction.SELL)
						.withInstructionDate(new InstructionDate(LocalDate.of(2017, 06, 16)))
						.withSettlementDate(new SettlementDate(LocalDate.of(2017, 06, 17)))
						.build())

				.add(aRequestBuilder()
						.withAmount(new TradeAmount(BigDecimal.valueOf(20), 10, BigDecimal.valueOf(20)))
						.withCurrency(Currency.PLN)
						.withEntity(new Entity("bar1"))
						.withInstruction(Instruction.BUY)
						.withInstructionDate(new InstructionDate(LocalDate.of(2017, 06, 17)))
						.withSettlementDate(new SettlementDate(LocalDate.of(2017, 06, 19)))
						.build())

				.add(aRequestBuilder()
						.withAmount(new TradeAmount(BigDecimal.valueOf(20), 10, BigDecimal.valueOf(20)))
						.withCurrency(Currency.AED)
						.withEntity(new Entity("foo2"))
						.withInstruction(Instruction.BUY)
						.withInstructionDate(new InstructionDate(LocalDate.of(2017, 06, 17)))
						.withSettlementDate(new SettlementDate(LocalDate.of(2017, 06, 19)))
						.build())
				
				.add(aRequestBuilder()
						.withAmount(new TradeAmount(BigDecimal.valueOf(20), 10, BigDecimal.valueOf(20)))
						.withCurrency(Currency.EUR)
						.withEntity(new Entity("bar2"))
						.withInstruction(Instruction.BUY)
						.withInstructionDate(new InstructionDate(LocalDate.of(2017, 06, 18)))
						.withSettlementDate(new SettlementDate(LocalDate.of(2017, 06, 19)))
						.build())

				.build();

	}

}
