package com.automator;

import com.automator.addressgenerator.AddressGenerator_Page;
import com.automator.addressgenerator.AddressGenerator_Service;
import com.automator.handler.*;
import com.automator.tripplanner.*;

import java.util.HashMap;
import java.util.List;

public class Automator {

    public static void main( String[] args ){
        TransportRoute_Service.findRoutes(AddressGenerator_Service.generateAddresses("Sydney"));
    }
}
