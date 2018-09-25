package com.assigment.GOJEK;

import com.assigment.GOJEK.parklot.exception.NOFreeSlotException;

public class ParkingLotImpl extends ParkingLot {
	
	public ParkingLotImpl() {
		super();
	}
	
	public ParkingLotImpl(int number) {
		super(number);
	}

	@Override
	public Slot getNearestAvailableSlot() throws NOFreeSlotException{
		Slot slot = this.getSlots().poll();
		
		if(slot==null)
			throw new NOFreeSlotException("No Free slot available to park your car");
		return slot;
	}

	@Override
	public Ticket park(Car car) {
		return generateTicket(car);
	}

	private Ticket generateTicket(Car car) {
		//TODO 
		return new Ticket();
	}

	@Override
	public void leave(Slot slot) {
		//TODO.. free up car from parked data strcutures
		this.getSlots().add(slot);
		
	}

	@Override
	public Slot getSlotForRegNum(String RegNum) {
		return this.getRegNumMap().get(RegNum);
	}
}
