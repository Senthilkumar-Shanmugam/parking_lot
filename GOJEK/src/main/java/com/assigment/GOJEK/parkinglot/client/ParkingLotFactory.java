package com.assigment.GOJEK.parkinglot.client;

import com.assigment.GOJEK.parkinglot.ParkingLotI;
import com.assigment.GOJEK.parkinglot.ParkingLotType;
import com.assigment.GOJEK.parklot.exception.NoSuchParkingLotException;

public interface ParkingLotFactory {
    public ParkingLotI getParkingLot(ParkingLotType parkingLotType,int slots) throws NoSuchParkingLotException;

}
