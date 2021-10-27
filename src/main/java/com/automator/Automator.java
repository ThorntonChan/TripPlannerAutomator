package com.automator;

import com.automator.addressgenerator.AddressGenerator_Service;
import com.automator.exception.FileException;
import com.automator.handler.*;
import com.automator.tripplanner.*;

import java.io.IOException;

public class Automator {

    public static void main( String[] args ){
        if (!ReportHandler.init("C:\\log.txt", false)){
            System.out.println("Reporting could not be initialised");
            System.exit(1);
        }
        TransportRoute_Service.findRoutes(AddressGenerator_Service.generateAddresses("Sydney"));
    }
}
