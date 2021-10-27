package com.automator;

import com.automator.addressgenerator.AddressGenerator_Service;
import com.automator.exception.FileException;
import com.automator.handler.*;
import com.automator.tripplanner.*;

import java.io.IOException;

public class Automator {

    public static void main( String[] args ){
        try {
            FileHandler logFileHandler = new FileHandler("C:\\log.txt");
            ReportHandler reportHandler = new ReportHandler(logFileHandler, false);
        } catch (FileException e){
            System.out.println("Log file not accessible");
            System.out.println(e);
        }
        TransportRoute_Service.findRoutes(AddressGenerator_Service.generateAddresses("Sydney"));
    }
}
