package com.lta.destination.finder.boundary;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lta.destination.finder.controller.DestinationsController;
import com.lta.destination.finder.entity.Destination;
import com.lta.destination.finder.entity.Tag;

@Path("/")
@Stateless
public class DestinationsResource {

	@Inject
	private DestinationsController controller;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Destination> getDestinations(List<Tag> tags) {
		List<Destination> findDestinationsForTags = controller.findDestinationsForTags(tags);
		return findDestinationsForTags;
	}

	@GET
	@Path("/testData")
	public Response addTestData() {
		controller.addTestData();
		return Response.ok().build();
	}
}
