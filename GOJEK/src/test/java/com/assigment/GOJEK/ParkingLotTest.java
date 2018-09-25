package com.assigment.GOJEK;

import com.assigment.GOJEK.parklot.exception.NOFreeSlotException;
import com.assigment.GOJEK.parklot.exception.NoSlotFoundForRegNum;

import junit.framework.TestCase;

public class ParkingLotTest extends TestCase {
	ParkingLot parkLot = null;
	Car car = null;
	private static final int NUMBEROFSLOTS = 5;
	
	@Override
	protected void setUp() {
		parkLot = new ParkingLotImpl(NUMBEROFSLOTS);
		car = new Car("KA-01-HH-1234",Color.BLACK);
        
	}
	
	@Override
	protected void tearDown() {
		parkLot = null;
		car = null;
	}
	public void testParkingLotExists() {
		assertNotNull(parkLot);
	}
	
	public void testParkingLotHasNSlots() {
		assertEquals(NUMBEROFSLOTS,parkLot.getSlots().size());
	}
	
	public void testgetNearestAvaiableSlot() throws NOFreeSlotException {
		Slot nearestSlot = new Slot(1,0);
		assertEquals(nearestSlot.getSlotId(), parkLot.getNearestAvailableSlot().getSlotId());
	}
	
	
	public void testNearestAvailableSlot2() throws NOFreeSlotException {
		parkLot.getSlots().poll();
		parkLot.getSlots().poll();
		Slot nearestSlot = new Slot(3,0);
		assertEquals(nearestSlot.getSlotId(), parkLot.getNearestAvailableSlot().getSlotId());
	}
	
	//TODO instead of direct access,need to refactor it to use park and use up slots
	public void testIfNoNearestAvailableFreeSlotThrowException() {
		try {
		parkLot.getSlots().poll();
		parkLot.getSlots().poll();
		parkLot.getSlots().poll();
		parkLot.getSlots().poll();
		parkLot.getSlots().poll();
		parkLot.getNearestAvailableSlot();
		fail();
		}catch(NOFreeSlotException e) {
			assertTrue(true);
		}
		
	}

	public void testParkRegistersCarDetails() throws NOFreeSlotException {
		parkLot.park(car);
	}
	
	public void testParkingGivesTicketNumber() throws NOFreeSlotException {
	    assertNotNull(parkLot.park(car));
	}
	
	public void testParkAddsRegNumSlotMap() throws NOFreeSlotException {
	    parkLot.park(car);
        assertTrue(parkLot.getRegNumMap().containsKey(car.getRegNum()));
	}
	
	public void  testParkAddsToSlotCarMap() throws NOFreeSlotException {
		parkLot.park(car);
		Slot slot = new Slot(1,0);
		assertTrue(parkLot.getSlotCarMap().containsKey(slot));
	}
	
	public void testleaveFreesUpOneSlot() throws Exception {
		int slotsbefore=parkLot.getSlots().size();
		parkLot.park(car);
		Slot slot = parkLot.getSlotForRegNum(car.getRegNum());
		parkLot.leave(slot);
		int slotsafter = parkLot.getSlots().size();
		assertEquals(slotsbefore, slotsafter);
		
	}
	
     public void testLeaveRemovesRegNumSlotMap() throws Exception {
		parkLot.park(car);
		Slot slot = new Slot(1,0);//assigns 1st slot
		parkLot.leave(slot); //leave should remove the slot from regNumMap
		assertNull(parkLot.getRegNumMap().get(car.getRegNum()));
	}
	
	public void testgetSlotForRegNum() throws NOFreeSlotException, NoSlotFoundForRegNum {
		//First park a car and get the slot for that regnum
		parkLot.park(car);
		Slot Slot = parkLot.getSlotForRegNum(car.getRegNum());
		assertNotNull(Slot);		
	}
	
	public void testgetSlotForRegNumThrowsExceptionWhenNOtFound() throws NOFreeSlotException {
		try {
		parkLot.park(car);
		Slot Slot = parkLot.getSlotForRegNum("dummy");
        fail();
		}catch(NoSlotFoundForRegNum expected) {
			assertTrue(true);
		}
		
	}
	
	
}
