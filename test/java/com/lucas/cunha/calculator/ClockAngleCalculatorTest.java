package com.lucas.cunha.calculator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.json.JSONObject;
import org.junit.Test;

import com.lucas.cunha.rest.ClockService;

/**
 * @author lucas
 *
 */
public class ClockAngleCalculatorTest extends JerseyTest {
	@Override
	protected Application configure() {
		return new ResourceConfig(ClockService.class);
	}

	@Test
	public void shouldReturn0WhenHourIs0AndMinuteIs0() {
		JSONObject response = new JSONObject(target("clock/0/0").request().get(String.class));
		assertThat(response.get("angle"), is(0));
	}

	@Test
	public void shouldReturn0WhenHourIs0() {
		JSONObject response = new JSONObject(target("clock/0").request().get(String.class));
		assertThat(response.get("angle"), is(0));
	}

	@Test
	public void shouldReturn6WhenHourIs3AndMinuteIs16() {
		JSONObject response = new JSONObject(target("clock/3/16").request().get(String.class));
		assertThat(response.get("angle"), is(6));
	}

	@Test
	public void shouldReturn180WhenHourIs12AndMinuteIs30() {
		JSONObject response = new JSONObject(target("clock/12/30").request().get(String.class));
		assertThat(response.get("angle"), is(180));
	}

	@Test
	public void shouldReturn180WhenHourIs6() {
		JSONObject response = new JSONObject(target("clock/6").request().get(String.class));
		assertThat(response.get("angle"), is(180));
	}

	@Test
	public void shouldReturn180WhenHourIs13AndMinuteIs50() {
		JSONObject response = new JSONObject(target("clock/13/50").request().get(String.class));
		assertThat(response.get("angle"), is(90));
	}

	@Test
	public void shouldReturn144WhenHourIs10AndMinuteIs14() {
		JSONObject response = new JSONObject(target("clock/10/14").request().get(String.class));
		assertThat(response.get("angle"), is(144));
	}
}
