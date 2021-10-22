package com.automator.page;

import java.util.List;

import com.automator.exception.TripPlannerException;
import com.automator.handler.DriverHandler;
import com.automator.object.TransportRoute_Object;
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
                        DriverHandler.clear(TransportRoute_Object.fromInput);
                        DriverHandler.input(TransportRoute_Object.fromInput, from);                        
                        DriverHandler.wait(1);
                        WebElement fromResult = DriverHandler.eWaitForElement(TransportRoute_Object.bestResult0, 5);
                        if (DriverHandler.hasChild(fromResult, TransportRoute_Object.resultText) && DriverHandler.find(TransportRoute_Object.resultText).getText().equals("My current location")){
                            DriverHandler.click(TransportRoute_Object.bestResult1);
                        } else {
                            DriverHandler.click(TransportRoute_Object.bestResult0);
                        }
                        DriverHandler.wait(1);
                        DriverHandler.clear(TransportRoute_Object.toInput);                        
                        DriverHandler.input(TransportRoute_Object.toInput, to);
                        DriverHandler.wait(1);
                        WebElement toResult = DriverHandler.fWaitForElement(TransportRoute_Object.bestResult0, 1, 5);
                        if (DriverHandler.hasChild(toResult, TransportRoute_Object.resultText) && DriverHandler.find(TransportRoute_Object.resultText).getText().equals("My current location")){
                            DriverHandler.click(TransportRoute_Object.bestResult1);
                        } else {
                            DriverHandler.click(TransportRoute_Object.bestResult0);
                        }
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

