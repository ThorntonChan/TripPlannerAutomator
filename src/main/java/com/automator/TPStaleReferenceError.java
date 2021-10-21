package com.automator;
import org.openqa.selenium.WebElement;


public class TPStaleReferenceError extends TripPlannerException {
    public TPStaleReferenceError(WebElement we, Throwable e) {
        errorMessage = "Originating element was not found";
        error = e;
    }
}
