package com.assigment.GOJEK;

import com.assigment.GOJEK.parklot.exception.NOFreeSlotException;

public interface ParkingLotI {
	public Slot getNearestAvailableSlot() throws NOFreeSlotException;
	public Ticket park(Car car) throws NOFreeSlotException;
	public void leave(Slot slot);
	public Slot getSlotForRegNum(String RegNum);
}
