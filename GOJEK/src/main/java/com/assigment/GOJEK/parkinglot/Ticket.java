package com.assigment.GOJEK.parkinglot;

//TODO ADD more details like tktno,driver and RegNo
public class Ticket {
	private String tktNumber;
	private int slotId;
	private String parkingTime;
	private Car parkedCar;
	
	public Ticket() {}
	public Ticket(String tktNumber, int slotId, String parkingTime, Car parkedCar) {
		super();
		this.tktNumber = tktNumber;
		this.slotId = slotId;
		this.parkingTime = parkingTime;
		this.parkedCar = parkedCar;
	}
	
	protected String getTktNumber() {
		return tktNumber;
	}
	protected void setTktNumber(String tktNumber) {
		this.tktNumber = tktNumber;
	}
	public int getSlotId() {
		return slotId;
	}
	protected void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	protected String getParkingTime() {
		return parkingTime;
	}
	protected void setParkingTime(String parkingTime) {
		this.parkingTime = parkingTime;
	}
	protected Car getParkedCar() {
		return parkedCar;
	}
	protected void setParkedCar(Car parkedCar) {
		this.parkedCar = parkedCar;
	}

	@Override
	public String toString() {
		return "Ticket [tktNumber=" + tktNumber + ", slotId=" + slotId + ", parkingTime=" + parkingTime + ", parkedCar="
				+ parkedCar + "]";
	}
	

	}
