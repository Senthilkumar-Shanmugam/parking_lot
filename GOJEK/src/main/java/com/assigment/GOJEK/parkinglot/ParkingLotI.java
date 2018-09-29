package com.assigment.GOJEK.parkinglot;

import java.util.List;

import com.assigment.GOJEK.parklot.exception.CarCanNotBeFoundException;
import com.assigment.GOJEK.parklot.exception.NOFreeSlotException;
import com.assigment.GOJEK.parklot.exception.NoSlotFoundForRegNum;

public interface ParkingLotI {
	public Slot getNearestAvailableSlot() throws NOFreeSlotException;
	public Ticket park(Car car) throws NOFreeSlotException;
	public void leave(Slot slot) throws CarCanNotBeFoundException; 
	public Slot getSlotForRegNum(String RegNum) throws NoSlotFoundForRegNum;
	public List<String> getRegNumsForColor(Color color);
	public List<Slot> getParkedSlotsForColor(Color color);
	public void status() ;
}
