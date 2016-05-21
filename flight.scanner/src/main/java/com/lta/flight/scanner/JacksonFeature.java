package com.lta.flight.scanner;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Provider
public class JacksonFeature implements Feature {
	@Override
	public boolean configure(FeatureContext context) {
		context.property("jersey.config.server.disableMoxyJson", true);
		// this is in jersey-media-json-jackson
		context.register(JacksonFeature.class);

		// or from jackson-jaxrs-json-provider
		context.register(JacksonJsonProvider.class);
		// for JAXB annotation support
		context.register(JacksonJaxbJsonProvider.class);

		return true;
	}
}
