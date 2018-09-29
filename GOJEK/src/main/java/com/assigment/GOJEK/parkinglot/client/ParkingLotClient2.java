package com.assigment.GOJEK.parkinglot.client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.assigment.GOJEK.parkinglot.ParkingLotFactoryImpl;
import com.assigment.GOJEK.parkinglot.ParkingLotI;
import com.assigment.GOJEK.parkinglot.ParkingLotType;
import com.assigment.GOJEK.parklot.exception.InsufficentNumberOfSlotsException;
import com.assigment.GOJEK.parklot.exception.NoSuchParkingLotException;


public class ParkingLotClient2 {
    static ParkingLotFactoryImpl parkFactory = new ParkingLotFactoryImpl();
	private static ParkingLotI parkingLot =null;
	private static Map<String,Method> commandRegistry = new HashMap<String,Method>();


	public ParkingLotClient2() {
	}
	
	public static void initializeWithParkingLotOperations() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] parkMethods = parkingLot.getClass().getDeclaredMethods();
		
		for(Method method:parkMethods) {
			if(method.getName().equals(anObject))
		}
	}

	public static void main(String[] args) throws Exception {
		
		 if(args.length > 0)
	        {
	            String fileName = args[0];
	            executeCommandsInFile(fileName);
	        }
	        else
	        {
	            Scanner scanner = new Scanner(System.in);
	            while (true) {
	                String commandLine = scanner.nextLine();
	                runCommand(commandLine);
	            }
	        }
    }
    private static void runCommand(String commandLine) throws Exception
    {
    	 String[] commandInput = commandLine.split(" ");
         String command = commandInput[0];
         
    	  if("create_parking_lot".equals(command))
          {
              if(commandInput.length != 2)
              {
                  System.out.println("Invalid input,number of slots not passed");
              }
              else
              {
                  int slots = Integer.parseInt(commandInput[1]);
                  create_parking_lot(slots);
                  initializeWithParkingLotOperations();
              }
          }else {//dynamically invoke parking lot operations using reflection
        	  
          }
    	
    }
    private static void executeCommandsInFile(String fileName) throws Exception
    {
        String commandLine;
        BufferedReader bReader = null;
        FileReader fReader = null;
        try {

            fReader = new FileReader(fileName);
            bReader = new BufferedReader(fReader);

            while ((commandLine = bReader.readLine()) != null)
            {
                runCommand(commandLine);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally
        {
                try {

                if (bReader != null)
                    bReader.close();

                if (fReader != null)
                    fReader.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }
    private static void create_parking_lot(int slots) throws NoSuchParkingLotException, InsufficentNumberOfSlotsException
    {
    	parkingLot = parkFactory.getParkingLot(ParkingLotType.PUBLIC, slots);
        System.out.println("Created a parking lot with " + slots + " slots");
    }
}
