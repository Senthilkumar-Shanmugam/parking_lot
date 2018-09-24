package com.assigment.GOJEK;

import junit.framework.TestCase;

public class ParkingLotTest extends TestCase {
	
	public void testParkingLotExists() {
		ParkingLot parkLot = new ParkingLotImpl();
		assertNotNull(parkLot);
	}

}
