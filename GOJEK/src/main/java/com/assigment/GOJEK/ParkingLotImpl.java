package com.assigment.GOJEK;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.assigment.GOJEK.parklot.exception.NOFreeSlotException;
import com.assigment.GOJEK.parklot.exception.NoSlotFoundForRegNum;

public class ParkingLotImpl extends ParkingLot {
	
	public ParkingLotImpl() {
		super();
	}
	
	public ParkingLotImpl(int number) {
		super(number);
	}

	@Override
	public Slot getNearestAvailableSlot() throws NOFreeSlotException{
		Slot slot = this.getSlots().poll();
		
		if(slot==null)
			throw new NOFreeSlotException("No Free slot available to park your car");
		return slot;
	}

	@Override
	public Ticket park(Car car) throws NOFreeSlotException {
		Slot slot = getNearestAvailableSlot();
		
		if(slot != null) {
		  this.getRegNumMap().put(car.getRegNum(), slot);
		  this.getSlotCarMap().put(slot, car);
		}
		
		//add car to the color map
		Map<Color,List<Car>> colorCarMap = getColorCarMap();
		List<Car> cars = colorCarMap.get(car.getColor());
		
		if(cars==null) { // violating TDD need to add test coverage later
			cars = new ArrayList<Car>();
			cars.add(car);
			this.getColorCarMap().put(car.getColor(), cars);
		}else {
			cars.add(car);
		}
		
		
		return generateTicket(car);
	}

	private Ticket generateTicket(Car car) {
		//TODO 
		return new Ticket();
	}

	@Override
	public void leave(Slot slot) throws Exception {
		//TODO.. free up car from parked data strcutures
		this.getSlots().add(slot);
		
		Car car = getSlotCarMap().get(slot);
		if(car == null)
			throw new Exception("No car found"); // need to add test coverage for this , violating TDD
		
		
		//remove slot from regNumSlotMap and SlotCarMap
		if(getRegNumMap() != null && getRegNumMap().size() > 0) {
		   getRegNumMap().remove(car.getRegNum());
		}
		
		getSlotCarMap().remove(slot); //need to add test coverage for this
		
		//remove it from color map
		
		List<Car> cars = getColorCarMap().get(car.getColor());
		if(cars != null && cars.size() > 0)
			cars.remove(car);
		
	}

	@Override
	public Slot getSlotForRegNum(String RegNum) throws NoSlotFoundForRegNum {
		Slot slot = this.getRegNumMap().get(RegNum);
		
		if(slot == null)
			throw new NoSlotFoundForRegNum("No Slot found for this register number:"+RegNum);
		return slot;
	}

	@Override
	public List<String> getRegNumsForColor(Color color) {
		List<String> regNums = new ArrayList<String>();
		
		List<Car> carsForColor = getColorCarMap().get(color);
		
		for(Car car:carsForColor)
			regNums.add(car.getRegNum());
		
		return regNums;
	}

	@Override
	public List<Slot> getParkedSlotsForColor(Color color)  {
		List<Slot> slots = new ArrayList<Slot>();
		
		try {
		  List<Car> cars = getColorCarMap().get(color);
		
		  for(Car car:cars) {
			Slot slot = getSlotForRegNum(car.getRegNum());
			slots.add(slot);
		  }
		} catch (NoSlotFoundForRegNum e) {
			e.printStackTrace();
		}
		
		return slots;
	}

	@Override
	public void status() {
		System.out.println("Slot No.     Registeration No     Color");		
	}
}
