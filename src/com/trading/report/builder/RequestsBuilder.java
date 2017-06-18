package com.trading.report.builder;

import java.util.ArrayList;
import java.util.List;

import com.trading.report.model.Request;

public final class RequestsBuilder {

	private final List<Request> requests = new ArrayList<>();

	public static RequestsBuilder aRequestsBuilder() {
		return new RequestsBuilder();
	}

	public RequestsBuilder add(Request request) {
		requests.add(request);
		return this;
	}

	public List<Request> build() {
		return requests;
	}

}
