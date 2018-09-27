package com.assigment.GOJEK.parkinglot.client;


import java.util.HashMap;
import java.util.Map;

import com.assigment.GOJEK.parkinglot.ParkingLot;
import com.assigment.GOJEK.parkinglot.ParkingLotI;
import com.assigment.GOJEK.parkinglot.ParkingLotType;
import com.assigment.GOJEK.parkinglot.PublicParkingLot;
import com.assigment.GOJEK.parklot.exception.NoSuchParkingLotException;

public class ParkingLotFactoryImpl implements ParkingLotFactory {
	private static Map<ParkingLotType,ParkingLot> parkingLots = new HashMap<ParkingLotType,ParkingLot>();

	public ParkingLotFactoryImpl() {
	}


	@Override
	public ParkingLotI getParkingLot(ParkingLotType parkingLotType,int slots) throws NoSuchParkingLotException {
		ParkingLot parkingLot = null;
         if(parkingLotType.equals(ParkingLotType.PUBLIC)) {
        	 parkingLot = parkingLots.get(parkingLotType);
        	 
        	 if(parkingLot == null) {
        		synchronized (ParkingLotFactoryImpl.class) {
					if(parkingLot == null)
					{
						parkingLot = new PublicParkingLot(slots);
						parkingLots.put(parkingLotType, parkingLot);
					}
				} 
        	 }
         }
         else
        	 throw new NoSuchParkingLotException("No such parking lot exists");
         return parkingLot;
	}
}

