package com.assigment.GOJEK.parkinglot.client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.assigment.GOJEK.parkinglot.Car;
import com.assigment.GOJEK.parkinglot.Color;
import com.assigment.GOJEK.parkinglot.ParkingLotI;
import com.assigment.GOJEK.parkinglot.Slot;
import com.assigment.GOJEK.parkinglot.Ticket;
import com.assigment.GOJEK.parklot.exception.CarCanNotBeFoundException;
import com.assigment.GOJEK.parklot.exception.NOFreeSlotException;
import com.assigment.GOJEK.parklot.exception.NoSlotFoundForRegNum;
import com.assigment.GOJEK.parklot.exception.NoSuchParkingLotException;


public class ParkingLotClient {
	private static ParkingLotI parkingLot;
    static ParkingLotFactoryImpl parkFactory = new ParkingLotFactoryImpl();


	public ParkingLotClient() {
	}

	public static void main(String[] args) throws Exception {

        if(args.length > 0)
        {
            String fileName = args[0];
            System.out.println("********************* Run Parking Lot Utility using the commands in File*********************");
            executeCommandsInFile(fileName);
        }
        else
        {
            System.out.println("==============================================================================");
            System.out.println("********************* WELCOME TO PARKING LOT CLI CONSOLE *********************");
            System.out.println("==============================================================================");
            displayAllOptions();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String commandln = scanner.nextLine();
                runCommand(commandln);
            }
        }
    }
    private static void displayAllOptions()
    {
        System.out.println("Available commands:" );
        System.out.println("\t help");
        System.out.println("\t create_parking_lot <slots>");
        System.out.println("\t park <RegistrationNumber> <Color>");
        System.out.println("\t leave <slot>");
        System.out.println("\t status");
        System.out.println("\t registration_numbers_for_cars_with_colour <color>");
        System.out.println("\t slot_numbers_for_cars_with_colour <color>");
        System.out.println("\t slot_number_for_registration_number <registrationNumber>");
        System.out.println("\t exit");
    }
    private static void runCommand(String commandln) throws Exception
    {
        String[] commandInput = commandln.split(" ");
        String command = commandInput[0];
        if("help".equals(command))
        {
            displayAllOptions();
        }
        else if("create_parking_lot".equals(command))
        {
            if(commandInput.length != 2)
            {
                System.out.println("Invalid input,number of slots not passed");
            }
            else
            {
                int nrOfSlots = Integer.parseInt(commandInput[1]);
                create_parking_lot(nrOfSlots);
            }
        }
        else if("park".equals(command))
        {
            if(commandInput.length != 3)
            {
                System.out.println("not enough input parameters");
            }
            else
            {
                String registrationNumber = commandInput[1];
                String color = commandInput[2];
                park(registrationNumber, color);
            }
        }
        else if("leave".equals(command))
        {
            if(commandInput.length != 2)
            {
                System.out.println("Not enough input parameters");
            }
            else
            {
                int slotId = Integer.parseInt(commandInput[1]);
                leave(slotId);
            }
        }
        else if("status".equals(command))
        {
            if(commandInput.length != 1)
            {
                System.out.println("Not enough input parameters");
            }
            else
            {
                status();
            }
        }
        else if("registration_numbers_for_cars_with_colour".equals(command))
        {
            if(commandInput.length != 2)
            {
                System.out.println("Not enoung input parameters");
            }
            else
            {
                String color = commandInput[1];
                registration_numbers_for_cars_with_colour(color);
            }
        }
        else if("slot_numbers_for_cars_with_colour".equals(command))
        {
            if(commandInput.length != 2)
            {
                System.out.println("Not enough input parameters");
            }
            else
            {
                String color = commandInput[1];
                slot_numbers_for_cars_with_colour(color);
            }
        }
        else if("slot_number_for_registration_number".equals(command))
        {
            if(commandInput.length != 2)
            {
                System.out.println("Not enough input parameters");
            }
            else
            {
                String regNo = commandInput[1];
                slot_number_for_registration_number(regNo);
            }
        }else if("exit".equals(command)) {
        	System.exit(0);
        }
        else
        {
            System.out.println("Invalid command");
        }

    }
    private static void executeCommandsInFile(String fileName) throws Exception
    {
        BufferedReader br = null;
        FileReader fr = null;
        try {

            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null)
            {
                runCommand(sCurrentLine);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally
        {
                try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }
    private static void create_parking_lot(int nrOfSlots) throws NoSuchParkingLotException
    {
    	parkingLot = parkFactory.getParkingLot("Building1", nrOfSlots);
        System.out.println("Created a parking lot with " + nrOfSlots + " slots");
    }
    private static void park(String registrationNumber, String color) 
    {
        Ticket tkt = null;
		try {
			tkt = parkingLot.park(new Car(registrationNumber, Color.valueOf(color)));
		} catch (NOFreeSlotException e) {
            System.out.println("Sorry, parking lot is full");
		}
		if(tkt !=null)
        System.out.println("Allocated slot number: " + tkt.getSlotId());
    }
    private static void leave(int slotId) throws CarCanNotBeFoundException
    {
    	parkingLot.leave(new Slot(slotId,0));
        System.out.println("Slot number " + slotId + " is free");
    }
    private static void status() throws Exception
    {
       parkingLot.status();
    }
    private static void registration_numbers_for_cars_with_colour(String color)
    {
        List<String> registrationNumbers = parkingLot.getRegNumsForColor(Color.valueOf(color));
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < registrationNumbers.size(); i++)
        {
            sb.append(registrationNumbers.get(i));
            if(i != registrationNumbers.size()-1)
            {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }
    private static void slot_numbers_for_cars_with_colour(String color)
    {
        List<Slot> slotsForColor =  parkingLot.getParkedSlotsForColor(Color.valueOf(color));
        
        StringBuffer sb = new StringBuffer();
        for(int c = 0; c < slotsForColor.size(); c++)
        {
            sb.append(slotsForColor.get(c).getSlotId());
            if(c != slotsForColor.size()-1)
            {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }
    private static void slot_number_for_registration_number(String registrationNumber) 
    {
        Slot s=null;
		try {
			s = parkingLot.getSlotForRegNum(registrationNumber);
		} catch (NoSlotFoundForRegNum e) {
			//e.printStackTrace();
		}
        if(s == null)
        {
            System.out.println("Not found");
        }
        else
        {
            System.out.println(s.getSlotId());
        }
    }

}
