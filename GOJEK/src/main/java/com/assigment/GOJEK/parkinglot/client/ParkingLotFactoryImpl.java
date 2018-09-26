package com.assigment.GOJEK.parkinglot.client;

import java.sql.ParameterMetaData;
import java.sql.SQLException;

import com.assigment.GOJEK.parkinglot.ParkingLotI;
import com.assigment.GOJEK.parkinglot.ParkingLotImpl;
import com.assigment.GOJEK.parklot.exception.NoSuchParkingLotException;

public class ParkingLotFactoryImpl implements ParkingLotFactory {

	public ParkingLotFactoryImpl() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public ParkingLotI getParkingLot(String param,int slots) throws NoSuchParkingLotException {
         if(param.equals("Building1"))
        	 return new ParkingLotImpl(slots);
         else
        	 throw new NoSuchParkingLotException("No such parking lot exists");
	}

}
