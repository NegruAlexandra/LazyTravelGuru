package com.lta.flight.scanner.entity.sky;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Carrier {

	@JsonProperty(value="CarrierId")
	private long carrierId;
	
	@JsonProperty(value="Name")
	private String name;

	public long getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(long carrierId) {
		this.carrierId = carrierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
