package com.automator.addressgenerator;

import com.automator.handler.DriverHandler;

import java.util.List;

public class AddressGenerator_Service {

    public static void landingPage(){
        DriverHandler.visitUrl(AddressGenerator_Objects.primaryURL);
    }
    public static void changeCity(String city){
        AddressGenerator_Page.changeCity(city);
    }
    public static void returnResults(){
        AddressGenerator_Page.generate();
    }
    public static List<String> getListItems(){
        return AddressGenerator_Page.getListItems();
    }
    public static List<String> generateAddresses(String city){
        landingPage();
        changeCity(city);
        returnResults();
        return getListItems();
    }



}
