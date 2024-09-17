package com.atom.shiftregister_arduino.service;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.springframework.stereotype.Service;

@Service
public class Address {

       private static Logger logger = LogManager.getLogger(Address.class);


       public void address(String myPort) throws IOException{
        //String myPort = "/dev/ttyUSB0"; // modify for your own computer & setup.
        IODevice myGroveBoard = new FirmataDevice(myPort); // using the name of a port

        try {
            myGroveBoard.start();       // start comms with board;
            logger.info("Opening.. '" + myPort + "'");
            myGroveBoard.ensureInitializationIsDone();
        }
        catch (Exception ex) {
             logger.info("couldn't connect to board.");

        }
        finally {
            var myLED = myGroveBoard.getPin(4);
            myLED.setMode(Pin.Mode.OUTPUT);

            // LED D4 on.
            myLED.setValue(1);

            // Pause for half a second.
            try {
                Thread.sleep(2500);
            }
            catch(Exception ex){
                 logger.info("sleep error.");
            }
            // LED D4 off.
            myLED.setValue(0);

            myGroveBoard.stop();        // finish with the board.
             logger.info("Board stopped.");

        }
    }
}
