package com.lta.flight.scanner.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Dependent
public class FlightsController {

	private Client client;
	private final static String API_KEY = "dr449826115653302252873787438688";
	private final static String HEADER_PARAM = "X-Forwarded-For";
	private final String SKY_API = "http://partners.api.skyscanner.net/apiservices/browsequotes/v1.0";
	private org.elasticsearch.client.Client elClient;

	@PostConstruct
	private void init() {
		client = ClientBuilder.newClient();

	}

	public void gatherFlights() {
		// Test data here
		// TODO replace with actual parameters
		String countryCode = "RO";
		String currency = "EUR";
		String locale = "ro-RO";
		String departure = "TSR-sky";
		String departureDate = "2016-05";
		String arrival = "BCN-sky";
		String returnDate = "2016-07";
		try {
			elClient = establishESConnection();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebTarget target = client.target(SKY_API).path(countryCode).path(currency).path(locale).path(departure)
				.path(arrival).path(departureDate).path(returnDate);

		Response response = target.queryParam("apiKey", API_KEY).request(MediaType.APPLICATION_JSON)
				.header(HEADER_PARAM, "86.125.231.209").get();
		String jsonResponse = response.readEntity(String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode readValue = null;
		try {
			readValue = mapper.readValue(jsonResponse, JsonNode.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		IndexResponse elResponse = elClient.prepareIndex("twitter", "tweet", "1").setSource(readValue).execute()
				.actionGet();
		System.out.println(response);
	}

	private org.elasticsearch.client.Client establishESConnection() throws UnknownHostException {
		Settings settings = Settings.settingsBuilder().put("cluster.name", "elasticsearch").build();
		TransportClient transportClient = TransportClient.builder().settings(settings).build();
		transportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
		return transportClient;
	}
}
