package com.automator;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;

public class AddressGenerator_Page {

    public static void changeCity(String targetCity){
        try {
            DriverHandler.inputDropdown(AddressGenerator_Objects.citySelector, targetCity);
        } catch (TripPlannerException e){
            e.log();
        }
    }
    public static List<String> getListItems(){
        List<String> addresses = new ArrayList<String>();
        try {
            List<WebElement> addressContainers = DriverHandler.findMulti(AddressGenerator_Objects.addressContainer);
            for (WebElement item : addressContainers){
                addresses.add(DriverHandler.getText(item).substring(8));
            }
        } catch (TripPlannerException e){
            e.log();
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
