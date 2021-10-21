package com.automator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TPElementNotFoundError extends TripPlannerException {
    public TPElementNotFoundError(WebElement we, Throwable e) {
        errorMessage = "Originating element was not found";
        error = e;
    }
    public TPElementNotFoundError(By by, Throwable e) {
        errorMessage = "Element was not found using ref: " + by.toString();
        error = e;
    }
}
