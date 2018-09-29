package com.assigment.GOJEK.parklot.exception;

public class InsufficentNumberOfSlotsException extends Exception {

	private static final long serialVersionUID = 5229032062L;

	public InsufficentNumberOfSlotsException() {
	}

	public InsufficentNumberOfSlotsException(String message) {
		super(message);
	}

	public InsufficentNumberOfSlotsException(Throwable cause) {
		super(cause);
	}

	public InsufficentNumberOfSlotsException(String message, Throwable cause) {
		super(message, cause);
	}

	public InsufficentNumberOfSlotsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
