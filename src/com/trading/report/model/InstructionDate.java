package com.trading.report.model;

import java.time.LocalDate;

public final class InstructionDate {

	private final LocalDate instructionDate;

	public InstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}

}

