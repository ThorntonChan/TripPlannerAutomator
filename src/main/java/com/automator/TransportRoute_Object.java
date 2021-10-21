package com.automator;

import org.openqa.selenium.By;


public class TransportRoute_Object {
    public static By fromInput = new By.ById("tniFromTripLocation");
    public static By toInput = new By.ById("tniToTripLocation");
    public static By routes = new By.ByClassName("card-wrapper");
    public static By timelines = new By.ByClassName("timeline");
    public static By bestResult = new By.ById("autosuggest-item-0");

}
