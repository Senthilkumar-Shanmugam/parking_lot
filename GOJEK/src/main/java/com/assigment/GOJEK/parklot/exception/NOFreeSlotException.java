package com.assigment.GOJEK.parklot.exception;

public class NOFreeSlotException extends Exception {
	private static final long serialVersionUID = 7568568L;

	public NOFreeSlotException() {
	}

	public NOFreeSlotException(String message) {
		super(message);
	}

	public NOFreeSlotException(Throwable cause) {
		super(cause);
	}

	public NOFreeSlotException(String message, Throwable cause) {
		super(message, cause);
	}

	public NOFreeSlotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
