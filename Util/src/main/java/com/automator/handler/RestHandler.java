package com.automator.handler;

import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.core.IsEqual.equalTo;

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
            System.out.println("response not exists");
            return null;
        }
    }

    public void basicRequest(String header_s, String header_o, String request_type, String endpoint){
        response = RestAssured
                .with()
                .header(header_s, header_o)
                .when()
                .request(request_type, endpoint)
                .then()
                .statusCode(200)
                .extract().response();
    }

//    public static RequestSpecification given(){
//        return given();
//    }
//    public static RequestSpecification header(String h, String value){
//        return header(h, value);
//    }


}
