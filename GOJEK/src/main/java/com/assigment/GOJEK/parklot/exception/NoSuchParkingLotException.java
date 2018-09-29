package com.assigment.GOJEK.parklot.exception;

public class NoSuchParkingLotException extends Exception {

	public NoSuchParkingLotException() {
	}

	public NoSuchParkingLotException(String message) {
		super(message);
	}

	public NoSuchParkingLotException(Throwable cause) {
		super(cause);
	}

	public NoSuchParkingLotException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchParkingLotException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
