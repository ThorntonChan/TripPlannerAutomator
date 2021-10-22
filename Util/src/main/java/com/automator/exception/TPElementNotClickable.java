package com.automator.exception;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TPElementNotClickable extends TripPlannerException {
    public TPElementNotClickable(WebElement we, Throwable e) {
        errorMessage = "Element is not clickable";
        error = e;
    }
    public TPElementNotClickable(By by, Throwable e) {
        errorMessage = "Element found was not clickable: " + by.toString();
        error = e;
    }
}
