package com.assigment.GOJEK.parkinglot.client;

import com.assigment.GOJEK.parkinglot.ParkingLotI;

public class ParkingLotClient {
	private static ParkingLotI parkLot;

	public ParkingLotClient() {
	}

	public static void main(String[] args) {
        ParkingLotFactoryImpl parkFactory = new ParkingLotFactoryImpl();
        //parkLot = parkFactory
	}

}
