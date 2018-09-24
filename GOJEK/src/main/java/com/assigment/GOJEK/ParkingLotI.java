package com.assigment.GOJEK;

public interface ParkingLotI {
	public Slot getNearestAvailableSlot();
	public Ticket park(Car car);

}
