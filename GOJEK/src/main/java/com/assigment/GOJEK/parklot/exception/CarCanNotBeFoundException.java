package com.assigment.GOJEK.parklot.exception;

public class CarCanNotBeFoundException extends Exception {

	public CarCanNotBeFoundException() {
	}

	public CarCanNotBeFoundException(String message) {
		super(message);
	}

	public CarCanNotBeFoundException(Throwable cause) {
		super(cause);
	}

	public CarCanNotBeFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CarCanNotBeFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
