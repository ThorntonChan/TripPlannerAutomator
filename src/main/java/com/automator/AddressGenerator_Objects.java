package com.automator;

import org.openqa.selenium.By;


public class AddressGenerator_Objects {
    public static By listItem = new By.ByTagName("li");
    public static By paragraphs = new By.ByTagName("p");
    public static By addressContainer = new By.ByXPath("//p[contains(.//span, 'Address')]");
    public static By citySelector = new By.ByName("city");
    public static By submitButton = new By.ByCssSelector(".btn.btn-primary");
}
