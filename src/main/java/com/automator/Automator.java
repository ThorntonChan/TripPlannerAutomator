package com.automator;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.FluentWait;

public class Automator {
    public static WebDriver driver = new ChromeDriver();
    public static WebDriverWait eWaitDriver = new WebDriverWait(driver, 5);
    public static FluentWait<WebDriver> fWaitDriver = new FluentWait<WebDriver>(driver);
    
    public static void main( String[] args ){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

        driver.quit();
    }
}
