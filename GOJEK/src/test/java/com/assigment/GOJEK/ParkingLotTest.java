package com.assigment.GOJEK;

import junit.framework.TestCase;

public class ParkingLotTest extends TestCase {
	ParkingLot parkLot = null;
	private static final int NUMBEROFSLOTS = 5;
	
	@Override
	protected void setUp() {
		parkLot = new ParkingLotImpl(NUMBEROFSLOTS);
	}
	
	@Override
	protected void tearDown() {
		parkLot = null;
	}
	public void testParkingLotExists() {
		assertNotNull(parkLot);
	}
	
	public void testParkingLotHasNSlots() {
		assertEquals(NUMBEROFSLOTS,parkLot.getSlots().size());
	}
	
	public void testgetNearestAvaiableSlot() {
		Slot nearestSlot = new Slot(1,0);
		assertEquals(nearestSlot.getSlotId(), parkLot.getNearestAvailableSlot().getSlotId());
	}
	
	
	public void testNearestAvailableSlot2() {
		parkLot.getSlots().poll();
		parkLot.getSlots().poll();
		Slot nearestSlot = new Slot(3,0);
		assertEquals(nearestSlot.getSlotId(), parkLot.getNearestAvailableSlot().getSlotId());
	}

	
	public void testPark() {
		parkLot.park();
	}
	
	
}
