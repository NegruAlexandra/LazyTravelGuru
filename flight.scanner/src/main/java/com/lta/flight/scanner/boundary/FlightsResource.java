package com.lta.flight.scanner.boundary;

import java.net.HttpURLConnection;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lta.flight.scanner.controller.FlightsController;

@Path("/flight")
@Stateless
public class FlightsResource {

	@Inject
	private FlightsController controller;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response retrieveFlights() {
		controller.gatherFlights();
		return Response.status(HttpURLConnection.HTTP_OK).build();
	}
	
}
