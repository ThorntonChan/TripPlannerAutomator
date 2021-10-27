package com.automator.exception;

import org.openqa.selenium.WebElement;

public class FileException extends TripPlannerException{
    public FileException(String msg, Throwable e) {
        errorMessage = msg;
        error = e;
    }
}
