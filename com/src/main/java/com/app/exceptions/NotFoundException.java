package com.app.exceptions;

public class NotFoundException extends Exception {
	public NotFoundException(String msg) {
		super(String.format("Not Found : '%s'", msg));
	}
}