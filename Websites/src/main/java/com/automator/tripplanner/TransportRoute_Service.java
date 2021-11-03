package com.automator.tripplanner;

import com.automator.handler.DriverHandler;

import java.util.HashMap;
import java.util.List;

public class TransportRoute_Service {
    public HashMap<Integer, HashMap<Integer, HashMap<String, String>>> findRoutes(List<String> addressList){
        DriverHandler.wait(5);
        DriverHandler.visitUrl(TransportRoute_Object.primaryURL);
        return TransportRoute_Page.findRoutes(addressList);
    }
    public static void visitUrl(){
        DriverHandler.visitUrl(TransportRoute_Object.primaryURL);
    }

    public static void inputDestinations(String to, String from){
        TransportRoute_Page.inputLocations(to, from);
    }
    public static String getEarliestArrival(){
        return TransportRoute_Page.getEarliestArrival();
    }
}
