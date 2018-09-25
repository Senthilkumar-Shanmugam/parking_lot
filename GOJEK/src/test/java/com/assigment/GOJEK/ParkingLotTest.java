package com.assigment.GOJEK;

import com.assigment.GOJEK.parklot.exception.NOFreeSlotException;

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
		Car car = new Car("KA-01-HH-1234",Color.BLACK);
		parkLot.park(car);
	}
	
	public void testParkingGivesTicketNumber() throws NOFreeSlotException {
		Car car = new Car("KA-01-HH-1234",Color.BLACK);
        assertNotNull(parkLot.park(car));
	}
	
	public void testParkAddsRegNumSlotMap() throws NOFreeSlotException {
		Car car = new Car("KA-01-HH-1234",Color.BLACK);
        parkLot.park(car);
        assertTrue(parkLot.getRegNumMap().containsKey(car.getRegNum()));
	}
	
	public void testleaveFreesUpOneSlot() {
		Slot myslot = new Slot(3,0);
		int slotsbefore=parkLot.getSlots().size();
		parkLot.leave(myslot);
		int slotsafter = parkLot.getSlots().size();
		assertEquals(slotsbefore+1, slotsafter);
		
	}
	
	public void testgetSlotForRegNum() throws NOFreeSlotException {
		//First park a car and get the slot for that regnum
		Car car = new Car("KA-01-HH-1234",Color.BLACK);
        parkLot.park(car);
		Slot Slot = parkLot.getSlotForRegNum(car.getRegNum());
		assertNotNull(Slot);		
	}
	
	
}
