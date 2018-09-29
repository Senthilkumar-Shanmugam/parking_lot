package com.assigment.GOJEK.parkinglot;

import com.assigment.GOJEK.parklot.exception.InsufficentNumberOfSlots;
import com.assigment.GOJEK.parklot.exception.NoSuchParkingLotException;

import junit.framework.TestCase;

public class ParkingLotFactoryImplTest extends TestCase {
	ParkingLotFactory parkFactory;
	ParkingLotType parkingLotType;

	protected void setUp() throws Exception {
		parkFactory = new ParkingLotFactoryImpl();
	}

	protected void tearDown() throws Exception {
	}
	
	public void testParkingLotFactoryReturnsPakingLotIfThatParkingLotTypeExists() throws NoSuchParkingLotException, InsufficentNumberOfSlots {
		assertNotNull(parkFactory.getParkingLot(ParkingLotType.PUBLIC, 1));
	}

}
