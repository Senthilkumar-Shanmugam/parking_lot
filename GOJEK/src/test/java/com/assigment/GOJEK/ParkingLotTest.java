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
		assertEquals(1, parkLot.getNearestAvailableSlot());
		
	}

}
