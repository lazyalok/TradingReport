package com.trading.report.builder;

import com.trading.report.model.Currency;
import com.trading.report.model.Entity;
import com.trading.report.model.Instruction;
import com.trading.report.model.InstructionDate;
import com.trading.report.model.Request;
import com.trading.report.model.SettlementDate;
import com.trading.report.model.TradeAmount;

public final class RequestBuilder {

	private Entity entity;
	private Instruction instruction;
	private InstructionDate instructionDate;
	private SettlementDate settlementDate;
	private Currency currency;
	private TradeAmount amount;

	private RequestBuilder() {
	}

	public static RequestBuilder aRequestBuilder() {
		return new RequestBuilder();
	}

	public RequestBuilder withEntity(Entity entity) {
		this.entity = entity;
		return this;
	}

	public RequestBuilder withInstruction(Instruction instruction) {
		this.instruction = instruction;
		return this;
	}

	public RequestBuilder withInstructionDate(InstructionDate instructionDate) {
		this.instructionDate = instructionDate;
		return this;
	}

	public RequestBuilder withSettlementDate(SettlementDate settlementDate) {
		this.settlementDate = settlementDate;
		return this;
	}

	public RequestBuilder withCurrency(Currency currency) {
		this.currency = currency;
		return this;
	}

	public RequestBuilder withAmount(TradeAmount amount) {
		this.amount = amount;
		return this;
	}

	public Request build() {
		return new Request(entity, instruction, instructionDate, settlementDate, currency, amount);
	}
}
