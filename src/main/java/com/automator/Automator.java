package com.automator;

import com.automator.handler.*;
import com.automator.page.*;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Automator {

    public static void main( String[] args ){
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin");
        DriverHandler.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        DriverHandler.visitUrl("https://www.fakeaddressgenerator.com/AU_Real_Random_Address");
        
        AddressGenerator_Page.changeCity("Sydney");
        AddressGenerator_Page.generate();
        List<String> addressList= AddressGenerator_Page.getListItems();

        DriverHandler.wait(5);
        DriverHandler.visitUrl("https://transportnsw.info/trip");
        // debug
        System.out.println("debug");
        HashMap<Integer, HashMap<Integer, String>> mappy = TransportRoute_Page.findRoutes(addressList);
        System.out.println(mappy.get(1).get(2));

        DriverHandler.driver.quit();
    }
}
