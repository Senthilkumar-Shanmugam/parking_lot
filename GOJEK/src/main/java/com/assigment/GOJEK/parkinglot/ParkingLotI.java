package com.assigment.GOJEK.parkinglot;

import java.util.List;

import com.assigment.GOJEK.parklot.exception.CarCanNotBeFoundException;
import com.assigment.GOJEK.parklot.exception.NOFreeSlotException;
import com.assigment.GOJEK.parklot.exception.NoSlotFoundForRegNum;

public interface ParkingLotI {
	public Slot getNearestAvailableSlot() throws NOFreeSlotException;
	@ParkingLotCLI(cliCommandName = "park")
	public Ticket park(Car car) throws NOFreeSlotException;
	@ParkingLotCLI(cliCommandName = "leave")
	public void leave(Slot slot) throws CarCanNotBeFoundException; 
	@ParkingLotCLI(cliCommandName = "slot_number_for_registration_number")
	public Slot getSlotForRegNum(String RegNum) throws NoSlotFoundForRegNum;
	@ParkingLotCLI(cliCommandName="registration_numbers_for_cars_with_colour")
	public List<String> getRegNumsForColor(Color color);
	@ParkingLotCLI(cliCommandName="slot_numbers_for_cars_with_colour")
	public List<Slot> getParkedSlotsForColor(Color color);
	@ParkingLotCLI(cliCommandName = "status")
	public void status() ;
}
