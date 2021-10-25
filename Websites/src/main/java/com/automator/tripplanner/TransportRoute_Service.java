package com.automator.tripplanner;

import com.automator.handler.DriverHandler;

import java.util.HashMap;
import java.util.List;

public class TransportRoute_Service {
    public static HashMap<Integer, HashMap<Integer, String>> findRoutes(List<String> addressList){
        DriverHandler.wait(5);
        DriverHandler.visitUrl(TransportRoute_Object.primaryURL);
        return TransportRoute_Page.findRoutes(addressList);
    }
    public static void terminate(){
        DriverHandler.quit();
    }
}
