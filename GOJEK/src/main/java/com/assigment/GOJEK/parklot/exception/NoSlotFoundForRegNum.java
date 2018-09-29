package com.assigment.GOJEK.parklot.exception;

public class NoSlotFoundForRegNum extends Exception {

	public NoSlotFoundForRegNum() {
	}

	public NoSlotFoundForRegNum(String message) {
		super(message);
	}

	public NoSlotFoundForRegNum(Throwable cause) {
		super(cause);
	}

	public NoSlotFoundForRegNum(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSlotFoundForRegNum(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
