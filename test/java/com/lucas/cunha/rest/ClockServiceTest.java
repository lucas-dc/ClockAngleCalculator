package com.lucas.cunha.rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.json.JSONObject;
import org.junit.Test;

/**
 * @author lucas
 *
 */
public class ClockServiceTest extends JerseyTest {
	@Override
	protected Application configure() {
		return new ResourceConfig(ClockService.class);
	}

	@Test
	public void shouldReturnValidJsonWhenPassingValidHourAsParam() {
		JSONObject response = new JSONObject(target("clock/1").request().get(String.class));
		assertNotNull(response);
		assertTrue(response.has("angle"));
	}
	
	@Test
	public void shouldReturnValidJsonWhenPassingValidHourAndMinuteAsParam() {
		JSONObject response = new JSONObject(target("clock/1/10").request().get(String.class));
		assertNotNull(response);
		assertTrue(response.has("angle"));
	}

	@Test(expected=BadRequestException.class)
	public void shouldThrowBadRequestExceptionWhenHourIsGreaterThan23() {
		target("clock/24").request().get(String.class);
	}
	
	@Test(expected=BadRequestException.class)
	public void shouldThrowBadRequestExceptionWhenMinuteIsGreaterThan59() {
		target("clock/1/60").request().get(String.class);
	}
}
