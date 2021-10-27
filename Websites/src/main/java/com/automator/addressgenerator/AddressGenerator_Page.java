package com.automator.addressgenerator;

import java.util.List;
import java.util.ArrayList;

import com.automator.exception.FileException;
import com.automator.exception.TripPlannerException;
import com.automator.handler.DriverHandler;
import com.automator.handler.ReportHandler;
import org.openqa.selenium.WebElement;

public class AddressGenerator_Page {

    public static void changeCity(String targetCity){
        try {
            DriverHandler.inputDropdown(AddressGenerator_Objects.citySelector, targetCity);
        } catch (TripPlannerException e){
            ReportHandler.output("change city unsuccessful");
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
            ReportHandler.output("Get addresses unsuccessful");
            e.log();
        }
        for (String address : addresses){
            ReportHandler.output(address + "\n");
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
