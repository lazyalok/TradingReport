package com.trading.report.model;

public final class Request {

	private final Entity entity;
	private final Instruction instruction;
	private final InstructionDate instructionDate;
	private final Currency currency;
	private final TradeAmount amount;
	private SettlementDate settlementDate; // mutable field

	public Request(Entity entity, Instruction instruction, InstructionDate instructionDate,
			SettlementDate settlementDate, Currency currency, TradeAmount amount) {

		this.entity = entity;
		this.instruction = instruction;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.currency = currency;
		this.amount = amount;
	}

	public Entity getEntity() {
		return entity;
	}

	public Instruction getInstruction() {
		return instruction;
	}

	public InstructionDate getInstructionDate() {
		return instructionDate;
	}

	public SettlementDate getSettlementDate() {
		return settlementDate;
	}

	public Currency getCurrency() {
		return currency;
	}

	public TradeAmount getAmount() {
		return amount;
	}

	public void setNewSettlementDate(SettlementDate settlementDate) {
		this.settlementDate = settlementDate;
	}

}
