package com.automator.object;

import org.openqa.selenium.By;


public class TransportRoute_Object {
    public static By fromInput = new By.ById("tniFromTripLocation");
    public static By toInput = new By.ById("tniToTripLocation");
    public static By routes = new By.ByClassName("card-wrapper");
    public static By timelines = new By.ByClassName("timeline");
    public static By bestResult0 = new By.ById("autosuggest-item-0");
    public static By bestResult1 = new By.ById("autosuggest-item-1");
    public static By resultText = new By.ByCssSelector(".list-group-item-title.ng-star-inserted");

}
