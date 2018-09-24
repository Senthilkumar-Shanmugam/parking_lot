package com.assigment.GOJEK;

import junit.framework.TestCase;

public class ParkingLotTest extends TestCase {
	
	public void testParkingLotExists() {
		ParkingLot parkLot = new ParkingLotImpl();
		assertNotNull(parkLot);
	}
	
	public void testParkingLotHasNSlots() {
		int noOfSlots = 5;
		ParkingLot parkLot = new ParkingLotImpl(noOfSlots);
		assertEquals(noOfSlots,parkLot.getSlots().size());
	}
	
	public void testgetNearestAvaiableSlot() {
		int noOfSlots = 5;
		ParkingLot parkLot = new ParkingLotImpl(noOfSlots);
		Slot nearestSlot = new Slot(1,0);
		assertEquals(nearestSlot.getSlotId(), parkLot.getNearestAvailableSlot().getSlotId());
	}
	
	
	public void testNearestAvailableSlot2() {
		int noOfSlots = 5;
		ParkingLot parkLot = new ParkingLotImpl(noOfSlots);
		parkLot.getSlots().poll();
		parkLot.getSlots().poll();
		Slot nearestSlot = new Slot(3,0);
		assertEquals(nearestSlot.getSlotId(), parkLot.getNearestAvailableSlot().getSlotId());
	}

}
