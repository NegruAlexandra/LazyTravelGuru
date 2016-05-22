package com.lta.user.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.lta.user.controller.UsersController;
import com.lta.user.entity.UserProfile;

@Path("/")
public class UsersResource {

	@Inject
	private UsersController controller;

	@GET
	@Path("/test")
	public Response createTestData() {
		controller.createTestData();
		return Response.ok().build();
	}

	@GET
	@Path("/details")
	public Response getUserDetails() {
		UserProfile profile = controller.getProfile();
		return Response.ok().entity(profile).build();
	}

	@GET
	@Path("/tickets")
	public Response getTickets() {
		return controller.getTickets();
	}
}
