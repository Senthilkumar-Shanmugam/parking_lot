package com.assigment.GOJEK.parkinglot.client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.assigment.GOJEK.parkinglot.ParkingLotCLI;
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
             if(method.getName().equals("getSlotForRegNum"))
            	 commandRegistry.put("slot_number_for_registration_number", method);
             else if(method.getName().equals("slot_numbers_for_cars_with_colour"))
            	 commandRegistry.put("slot_numbers_for_cars_with_colour", method);
             else if(method.getName().equals("registration_numbers_for_cars_with_colour"))
            	 commandRegistry.put("registration_numbers_for_cars_with_colour", method);
             else
                 commandRegistry.put(method.getName(), method);		 
            	 
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println("inside main");
		
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
          }else  if("exit".equals(command)) {
            	System.exit(0);
          }else { // run the command from map
        	  Method method = commandRegistry.get(command);
        	  
        	  if(method == null)
                  System.out.println("Invalid command");
        	  else {
	              if(commandInput.length < method.getParameterCount()+1) {
	            	  System.out.println("Not enough arguments to this operation");
	              }

	              //construct obj array for method invocation
	              Object[] params = new Object[commandInput.length-1];
	              if(commandInput.length > 2) {
		              for(int i=1,j=0;i<commandInput.length;i++) {
		            	  params[j++]=commandInput[i];
		              }
	              }
	              method.invoke(parkingLot, params);
        	  }
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
