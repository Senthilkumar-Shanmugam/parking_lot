package com.assigment.GOJEK;

public class ParkingLotImpl extends ParkingLot {
	
	public ParkingLotImpl() {
		super();
	}
	
	public ParkingLotImpl(int number) {
		super(number);
	}

	@Override
	public Slot getNearestAvailableSlot() {
		Slot slot = this.getSlots().poll();
		return slot;
	}

	@Override
	public Ticket park(Car car) {
		return null;
	}

}
