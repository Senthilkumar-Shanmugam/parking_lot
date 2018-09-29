package com.assigment.GOJEK.parkinglot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import com.assigment.GOJEK.parklot.exception.CarCanNotBeFoundException;
import com.assigment.GOJEK.parklot.exception.InsufficentNumberOfSlotsException;
import com.assigment.GOJEK.parklot.exception.NOFreeSlotException;
import com.assigment.GOJEK.parklot.exception.NoSlotFoundForRegNum;

public class PublicParkingLot extends ParkingLot {
	
	public PublicParkingLot() {
		super();
	}
	
	public PublicParkingLot(int number) throws  InsufficentNumberOfSlotsException{
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
		  this.getRegNumSlotMap().put(car.getRegNum(), slot);
		  this.getSlotCarMap().put(slot, car);
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
		}
		return generateTicket(car,slot.getSlotId());
	}

	private Ticket generateTicket(Car car,int slotId) {
		Ticket ticket = new Ticket();
		ticket.setSlotId(slotId);
		ticket.setParkedCar(car);
		ticket.setParkingTime(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
		return ticket;
	}

	@Override
	public void leave(Slot slot) throws CarCanNotBeFoundException {
		Car car = getSlotCarMap().get(slot);
		if(car == null)
			throw new CarCanNotBeFoundException("Car cannot be found at this slot:"+slot.getSlotId());
		
		this.getSlots().add(slot);
		
		
		
		//remove slot from regNumSlotMap and SlotCarMap
		if(getRegNumSlotMap() != null && getRegNumSlotMap().size() > 0) {
		   getRegNumSlotMap().remove(car.getRegNum());
		}
		
		getSlotCarMap().remove(slot); //need to add test coverage for this
		
		//remove it from color map
		
		List<Car> cars = getColorCarMap().get(car.getColor());
		if(cars != null && cars.size() > 0)
			cars.remove(car);
		
	}

	@Override
	public Slot getSlotForRegNum(String RegNum) throws NoSlotFoundForRegNum {
		Slot slot = this.getRegNumSlotMap().get(RegNum);
		
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
	public void status(){
		System.out.println("Slot No.    Registration No    Colour");
		
		Map<Slot,Car> slotCarMap = getSlotCarMap();
		
		if(slotCarMap.size() < 1) {
			System.out.println("No car is parked");
		}
		
		for(Map.Entry<Slot, Car> entry : slotCarMap.entrySet()) {
			Slot slot =  entry.getKey();
			Car car = entry.getValue();
			System.out.println(slot.getSlotId()+"           "+car.getRegNum()+"      "+car.getColor());
			
		}
		
	}
}
