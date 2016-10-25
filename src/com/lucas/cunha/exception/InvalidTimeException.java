package com.lucas.cunha.exception;

import javax.ws.rs.BadRequestException;

/**
 * @author lucas
 *
 */
public class InvalidTimeException extends BadRequestException {
	private static final long serialVersionUID = 1L;

	public InvalidTimeException(String msg) {
		super(msg);
	}
}
