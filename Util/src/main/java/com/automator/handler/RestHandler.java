package com.automator.handler;

import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestHandler {
    public static Response response;

    public RestHandler(){}

    public Response get(String endpoint){
        response = RestAssured.get(endpoint);
        return response;
    }

    public String asString(){
        if (response != null){
            return response.asString();
        } else {
            //error
            return null;
        }
    }
//    public static RequestSpecification given(){
//        return given();
//    }
//    public static RequestSpecification header(String h, String value){
//        return header(h, value);
//    }


}
