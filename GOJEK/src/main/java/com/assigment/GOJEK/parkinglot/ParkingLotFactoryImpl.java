package com.assigment.GOJEK.parkinglot;


import java.util.HashMap;
import java.util.Map;

import com.assigment.GOJEK.parklot.exception.InsufficentNumberOfSlotsException;
import com.assigment.GOJEK.parklot.exception.NoSuchParkingLotException;

public class ParkingLotFactoryImpl implements ParkingLotFactory {
	private static Map<ParkingLotType,ParkingLot> parkingLots = new HashMap<ParkingLotType,ParkingLot>();

	public ParkingLotFactoryImpl() {
	}


	@Override
	public ParkingLotI getParkingLot(ParkingLotType parkingLotType,int slots) throws NoSuchParkingLotException, InsufficentNumberOfSlotsException {
		ParkingLot parkingLot = parkingLots.get(parkingLotType);

         if(parkingLotType.equals(ParkingLotType.PUBLIC)) {
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

