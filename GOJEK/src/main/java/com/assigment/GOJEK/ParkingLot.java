package com.assigment.GOJEK;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public abstract class ParkingLot implements ParkingLotI {
	private PriorityQueue<Slot> slots = null;
	private Map<String,Slot> regNumMap;
	
    public ParkingLot() {}
	
	public ParkingLot(int number) {
		slots = new PriorityQueue(number,new SlotComparator());
		regNumMap = new HashMap<String,Slot>();
		addSlotsToParkingLot(number);
	}
	
	private void addSlotsToParkingLot(int number) {
		for(int slot=1;slot<=number;slot++)
			slots.add(new Slot(slot,0));// since we are not handling any usecases related to level, assing all slots to level 0
		
	}
	//TODO  -- REMOVE MUTATOR METHODS
	public PriorityQueue<Slot> getSlots() {
		return slots;
	}

	public void setSlots(PriorityQueue<Slot> slots) {
		this.slots = slots;
	}

	public Map<String, Slot> getRegNumMap() {
		return regNumMap;
	}

	public void setRegNumMap(Map<String, Slot> regNumMap) {
		this.regNumMap = regNumMap;
	}

	

}
