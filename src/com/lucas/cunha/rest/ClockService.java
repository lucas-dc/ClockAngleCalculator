package com.lucas.cunha.rest;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.json.JSONObject;

import com.lucas.cunha.calculator.ClockAngleCalculator;
import com.lucas.cunha.validator.NumberValidator;

/**
 * @author lucas
 *
 */
@Singleton
@Path("/")
public class ClockService extends ResourceConfig {
	private ClockAngleCalculator calculator;
	
	public ClockService() {
		register(ClockService.class);
		this.calculator = new ClockAngleCalculator();
	}
	
	@GET
	@Path("/clock/{hours}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAngle(@PathParam("hours") int hours) {
		NumberValidator.validate(hours);
		
		int angle = this.calculator.getSmallestAngle(hours);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("angle", angle); 
		return jsonObject.toString();
	}
	
	@GET
	@Path("/clock/{hours}/{minutes}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAngle(@PathParam("hours") int hours, @PathParam("minutes") int minutes) {
		NumberValidator.validate(hours, minutes);
		
		int angle = this.calculator.getSmallestAngle(hours, minutes);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("angle", angle); 
		return jsonObject.toString();
	}
}
