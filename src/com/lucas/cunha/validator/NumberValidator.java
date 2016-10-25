package com.lucas.cunha.validator;

import com.lucas.cunha.exception.InvalidTimeException;

/**
 * @author lucas
 *
 */
public class NumberValidator {
	public static void validate(int hour) throws InvalidTimeException {
		validateHour(hour);
	}
	
	public static void validate(int hour, int minute) throws InvalidTimeException {
		validateHour(hour);
		validateMinute(minute);
	}
	
	private static void validateHour(int hour) throws InvalidTimeException {
		if(hour > 23 ) {
			throw new InvalidTimeException("Hour cannot be greather than 23.");
		}
	}
	
	private static void validateMinute(int minute) throws InvalidTimeException {
		if(minute > 59 ) {
			throw new InvalidTimeException("Minute cannot be greather than 59.");
		}
	}
	
}
