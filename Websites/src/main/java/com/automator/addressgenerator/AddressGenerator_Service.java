package com.automator.addressgenerator;

import com.automator.handler.DriverHandler;

import java.util.List;

public class AddressGenerator_Service {

    public static List<String> generateAddresses(String city){
        DriverHandler.visitUrl(AddressGenerator_Objects.primaryURL);
        AddressGenerator_Page.changeCity(city);
        AddressGenerator_Page.generate();
        return AddressGenerator_Page.getListItems();

    }
}
