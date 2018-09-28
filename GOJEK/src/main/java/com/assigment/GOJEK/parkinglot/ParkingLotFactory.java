package com.assigment.GOJEK.parkinglot;

import com.assigment.GOJEK.parklot.exception.NoSuchParkingLotException;

public interface ParkingLotFactory {
    public ParkingLotI getParkingLot(ParkingLotType parkingLotType,int slots) throws NoSuchParkingLotException;

}
