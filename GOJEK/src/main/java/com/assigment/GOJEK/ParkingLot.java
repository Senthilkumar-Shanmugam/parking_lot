package com.assigment.GOJEK;

import java.util.PriorityQueue;

public abstract class ParkingLot implements ParkingLotI {
	private PriorityQueue<Slot> slots = null;
	
public ParkingLot() {}
	
	public ParkingLot(int number) {
		slots = new PriorityQueue<Slot>(number);
	}
	
	public PriorityQueue<Slot> getSlots() {
		return slots;
	}

	public void setSlots(PriorityQueue<Slot> slots) {
		this.slots = slots;
	}

	

}
