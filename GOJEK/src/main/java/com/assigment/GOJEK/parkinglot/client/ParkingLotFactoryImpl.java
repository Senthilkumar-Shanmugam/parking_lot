package com.assigment.GOJEK.parkinglot.client;


import java.util.HashMap;
import java.util.Map;

import com.assigment.GOJEK.parkinglot.ParkingLot;
import com.assigment.GOJEK.parkinglot.ParkingLotI;
import com.assigment.GOJEK.parkinglot.PublicParkingLot;
import com.assigment.GOJEK.parklot.exception.NoSuchParkingLotException;

public class ParkingLotFactoryImpl implements ParkingLotFactory {
	private static Map<String,ParkingLot> parkingLots = new HashMap<String,ParkingLot>();

	public ParkingLotFactoryImpl() {
	}


	@Override
	public ParkingLotI getParkingLot(String param,int slots) throws NoSuchParkingLotException {
		ParkingLot parkingLot = null;
         if(param.equals("Public")) {
        	 parkingLot = parkingLots.get(param);
        	 
        	 if(parkingLot == null) {
        		synchronized (ParkingLotFactoryImpl.class) {
					if(parkingLot == null)
					{
						parkingLot = new PublicParkingLot(slots);
						parkingLots.put(param, parkingLot);
					}
				} 
        	 }
         }
         else
        	 throw new NoSuchParkingLotException("No such parking lot exists");
         return parkingLot;
	}
}

