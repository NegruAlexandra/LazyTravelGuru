package com.lta.flight.scanner.boundary;

import java.net.HttpURLConnection;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.lta.flight.scanner.controller.UsersController;

@Path("/user")
@Stateless
public class UsersResource {
	
	@Inject
	private UsersController controller;
	
	//TODO Secure login
//	@GET
//	public Response signIn(final String userName, final String password) {
//		return Response.status(HttpURLConnection.HTTP_OK).build();
//	}
}
