package com.atom.shiftregister_arduino.config;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.firmata4j.IODevice;
import org.firmata4j.firmata.FirmataDevice;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigArduino {
   private static Logger logger = LogManager.getLogger(ConfigArduino.class);

   public void initializeBoard(String myPort) {
        //String myPort = "/dev/ttyUSB0"; // modify for your own computer & setup.
        IODevice myGroveBoard = new FirmataDevice(myPort); // using the name of a port

        try {
            logger.info("Opening.. '" + myPort + "'");
            myGroveBoard.start();       // start comms with board;
          
            logger.info("Board started.");

         myGroveBoard.ensureInitializationIsDone();
        }
        catch (Exception ex){
            logger.error("couldn't connect to board.");
        }
    }

    public void stopingBoard(String myPort){
        IODevice myGroveBoard = new FirmataDevice(myPort); // using the name of a port
       
        try {
        logger.info("closing.. '" + myPort + "'");
        myGroveBoard.stop();        // finish with the board.
            logger.info("Board stopped.");

        }
        catch (Exception ex){
            logger.error("couldn't connect to board.");
        }
    }
}
