package com.assigment.GOJEK.parkinglot;

//TODO ADD more details like tktno,driver and RegNo
public class Ticket {
	private int slotId;

	public int getSlotId() {
		return slotId;
	}

	public Ticket(int slotId) {
		super();
		this.slotId = slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

}
