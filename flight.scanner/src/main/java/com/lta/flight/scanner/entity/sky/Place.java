package com.lta.flight.scanner.entity.sky;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {

	@JsonProperty(value = "PlaceId")
	private long placeId;

	@JsonProperty(value = "IataCode")
	private String iataCode;

	@JsonProperty(value = "Name")
	private String name;

	@JsonProperty(value = "SkyscannerCode")
	private String skyscannerCode;

	public long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(long placeId) {
		this.placeId = placeId;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSkyscannerCode() {
		return skyscannerCode;
	}

	public void setSkyscannerCode(String skyscannerCode) {
		this.skyscannerCode = skyscannerCode;
	}
}
