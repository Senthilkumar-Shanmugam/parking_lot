package com.assigment.GOJEK.parkinglot;

import com.assigment.GOJEK.parklot.exception.InsufficentNumberOfSlots;
import com.assigment.GOJEK.parklot.exception.NoSuchParkingLotException;

import junit.framework.TestCase;

public class ParkingLotFactoryImplTest extends TestCase {
	ParkingLotFactory parkFactory;

	protected void setUp() throws Exception {
		parkFactory = new ParkingLotFactoryImpl();
	}

	protected void tearDown() throws Exception {
		parkFactory = null;
	}
	
	public void testParkingLotFactoryReturnsPakingLotIfThatParkingLotTypeExists() throws  InsufficentNumberOfSlots, NoSuchParkingLotException {
		assertNotNull(parkFactory.getParkingLot(ParkingLotType.PUBLIC, 1));
	}
	
	public void testParkingLotFactoryReturnsExceptionRequestedParkingLotTypeDoesNotExist() throws InsufficentNumberOfSlots {
		try {
			parkFactory.getParkingLot(ParkingLotType.PRIVATE, 1);
		}catch(NoSuchParkingLotException e) {
			assertTrue(true);
		}
	}

}
