package com.trading.report.builder;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import com.trading.report.model.SettlementDate;

public final class ReportBuilder {

	public static void reportBuilder(String header, Map<SettlementDate, BigDecimal> report) {

		StringBuilder sb = new StringBuilder();

		sb.append("<--------" + header + "----------->\n");
		sb.append("[Date]		|	[Amount]\n");

		for (Entry<SettlementDate, BigDecimal> entries : report.entrySet()) {

			sb.append(entries.getKey().getSettlementDate() + "	|	" + entries.getValue()+"\n");
		}

		System.out.println(sb);
	}
}
