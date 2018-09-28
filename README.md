# parking_lot
This is parking lot assigment for GO-JEK

Assumptions:
    There is no multiple entries to the parking lot, as such assumed there would not be
     any race condition and contention to slots.

    Did not abstract vehicles. Assumed this only accomodates car.

    This is a free public parking lot. there is no charging here. 

    All these and other features can be extended later.

Pre-requsities. 

   Maven and Java installed and environment variables are set for that
   export PARKLOT_HOME=<dir of parking lot - full path>

To build goto parking_lot.

   -> $ bin/setup

To run the program with file input,

  -> $ bin/parking_lot file_inputs.txt
     Note : make sure the path of file_inputs.txt 

To run command CLI
   -> $bin/parking_lot  
   
To run functional tests
   $bin/run_functional_tests