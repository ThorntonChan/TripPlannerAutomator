package com.automator.exception;


//import com.automator.handler.ReportHandler;

public class TripPlannerException extends Exception {
    public String errorMessage;
    public Throwable error;

    public TripPlannerException(){};
    public TripPlannerException(Exception e) {
        super("Operation Unsuccessful", e);
        errorMessage = "Operation Unsuccessful";
        error = e;
    }
    public void log(){
//        ReportHandler.output(errorMessage); cyclic dependency debug
        System.out.println(errorMessage);
    }
    public void details(){
        System.out.println("Operation unsuccessful");
        if (error != null) {
            System.out.println(error);
        }
    }

}
