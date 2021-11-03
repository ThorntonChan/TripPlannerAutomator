package com.automator.tripplanner;

import java.util.List;

import com.automator.exception.TripPlannerException;
import com.automator.handler.DriverHandler;
import com.automator.handler.ReportHandler;
import org.openqa.selenium.WebElement;
import java.util.HashMap;


public class TransportRoute_Page {

    public static void inputLocations(String to, String from){
        try {
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
            ReportHandler.output("Input locations success: " + to + " - " + from);
            DriverHandler.wait(1);
        } catch (TripPlannerException e) {
            ReportHandler.output("Input locations failure: " + to + " - " + from);
            e.log();
//            LogHandler
        }
    }

    public static String getEarliestArrival(){
        try {
            String earliestArrival = "a";
            List<WebElement> timelines = DriverHandler.findMulti(TransportRoute_Object.timelines);
            for (WebElement timeline : timelines){
                String currentEarliest = DriverHandler.getText(timeline).substring(8);
                if(currentEarliest.compareTo(earliestArrival) < 0){
                    earliestArrival = currentEarliest;
                }
            }
            System.out.println(earliestArrival);
            return earliestArrival;
        } catch (TripPlannerException e){
            ReportHandler.output("No suitable routes found");
            return "No routes found";
        }
    }

    public static HashMap<Integer, HashMap<Integer, HashMap<String, String>>> findRoutes(List<String> addressList){
        HashMap<Integer, HashMap<Integer, HashMap<String, String>>> mappy = new HashMap<Integer, HashMap<Integer, HashMap<String, String>>>();
        System.out.println("starting loop");
//        List<String> addressList = new ArrayList<String>();
//        try {
//            FileHandler.read("C:\\Addresses.txt");
//            while (FileHandler.hasNext()){
//                addressList.add(FileHandler.readLine());
//            }
//        } catch (FileException e) {
//            System.out.println("error reading from Addresses.txt");
//        }
        for (int i = 0; i < addressList.size(); i++){
            HashMap<Integer, HashMap<String, String>> submappy = new HashMap<Integer, HashMap<String, String>>();
            for (int j = 0 ; j < addressList.size(); j++){
                if (i != j) {
                    HashMap<String, String> subsubmappy = new HashMap<String, String>();
                    String from = addressList.get(i);
                    String to = addressList.get(j);
                    // debug
                    System.out.println(from);
                    System.out.println(to);
                    inputLocations(to, from);

                    subsubmappy.put("Earliest arrival", getEarliestArrival());
                    submappy.put(j, subsubmappy);
                }
            }
            mappy.put(i, submappy);
        }
        return mappy;
    }
}

