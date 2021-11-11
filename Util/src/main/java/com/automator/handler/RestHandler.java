package com.automator.handler;

import io.restassured.*;
import io.restassured.response.Response;
public class RestHandler {
    public Response response;

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



}
