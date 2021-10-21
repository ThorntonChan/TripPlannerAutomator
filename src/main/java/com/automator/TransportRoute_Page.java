package com.automator;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.HashMap;


public class TransportRoute_Page {

    public static HashMap<Integer, HashMap<Integer, String>> findRoutes(List<String> addressList){
        HashMap<Integer, HashMap<Integer, String>> mappy = new HashMap<Integer, HashMap<Integer, String>>();
        System.out.println("starting loop");
        for (int i = 0; i < addressList.size(); i++){
            HashMap<Integer, String> submappy = new HashMap<Integer, String>();
            for (int j = 0 ; j < addressList.size(); j++){
                if (i != j) {
                    try {
                        String earliestArrival = "a";
                        String from = addressList.get(i); 
                        String to = addressList.get(j);
                        System.out.println(from);
                        System.out.println(to);
                        // debug
                        DriverHandler.input(TransportRoute_Object.fromInput, from + Keys.ENTER);                        
                        DriverHandler.wait(3);
                        DriverHandler.click(DriverHandler.eWaitForElement(Automator.eWaitDriver, TransportRoute_Object.bestResult, 5));
                        DriverHandler.input(TransportRoute_Object.toInput, to + Keys.ENTER);
                        DriverHandler.wait(3);
                        DriverHandler.click(DriverHandler.fWaitForElement(Automator.fWaitDriver, TransportRoute_Object.bestResult, 1, 5));
                        List<WebElement> timelines = DriverHandler.findMulti(TransportRoute_Object.timelines);
                        for (WebElement timeline : timelines){
                            String currentEarliest = DriverHandler.getText(timeline).substring(8);
                            if(currentEarliest.compareTo(earliestArrival) < 0){
                                earliestArrival = currentEarliest;
                            }
                        }
                        System.out.println(earliestArrival);
                        submappy.put(j, earliestArrival);
                    } catch (TripPlannerException e){
                        e.log();
                        continue;
                    }
                }
            }
            mappy.put(i, submappy);
        }
        return mappy;
    }
}

