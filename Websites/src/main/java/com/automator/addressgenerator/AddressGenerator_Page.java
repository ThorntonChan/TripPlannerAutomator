package com.automator.addressgenerator;

import java.util.List;
import java.util.ArrayList;

import com.automator.exception.FileException;
import com.automator.exception.TripPlannerException;
import com.automator.handler.DriverHandler;
import com.automator.handler.LogHandler;
import org.openqa.selenium.WebElement;

public class AddressGenerator_Page {

    public static void changeCity(String targetCity){
        try {
            DriverHandler.inputDropdown(AddressGenerator_Objects.citySelector, targetCity);
        } catch (TripPlannerException e){
            LogHandler.log("change city unsuccessful");
            e.log();
        }
    }
    public static List<String> getListItems(){
        List<String> addresses = new ArrayList<String>();
        try {
            List<WebElement> addressContainers = DriverHandler.findMulti(AddressGenerator_Objects.addressContainer);
            for (WebElement item : addressContainers){
                //debug
                addresses.add(DriverHandler.getText(item).substring(8));
            }
        } catch (TripPlannerException e){
            LogHandler.log("Get addresses unsuccessful");
            e.log();
        }
        try{
            LogHandler.options("C:\\Addresses.txt", false);
            for (String address : addresses){
                LogHandler.log(address + "\n");
            }
            LogHandler.options("C:\\log.txt", true); // pathname needs to be stored as a variable somewhere
        } catch (FileException e){
            System.out.println("Error on exporting addresses");
        }
        return addresses;
    }
    public static void generate() {
        try {
            DriverHandler.click(AddressGenerator_Objects.submitButton);
        } catch (TripPlannerException e) {
            e.log();
        }
    }
}
