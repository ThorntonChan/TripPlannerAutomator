package com.automator.handler;

import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.core.IsEqual.equalTo;

public class RestHandler {
    private String Url;
    public Response response;
    private RequestSpecification requestSpecification;
    private ValidatableResponse validatableResponse;

    public RestHandler(){}

    public void get(String endpoint){
        response = RestAssured.get(endpoint);
    }
    public void post(String endpoint){
        response = RestAssured.post(endpoint);
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

    public void with() throws Exception{
        if (requestSpecification == null){
            requestSpecification = RestAssured.with();
        } else {
            throw new Exception("requestSpecification already defined");
        }
    }

    public void given() throws Exception{
        if (requestSpecification == null){
            requestSpecification = RestAssured.with();
        } else {
            throw new Exception("requestSpecification already defined");
        }
    }

    public void header(String s, String o) throws Exception{ //TODO: Refactor to array
        if (requestSpecification != null){
            requestSpecification = requestSpecification.header(s, o);
        } else {
            throw new Exception("requestSpecification undefined, was there a given or when method called?");
        }
    }

    public void when() throws Exception{
        if (requestSpecification != null){
            requestSpecification = requestSpecification.when();
        } else {
            throw new Exception("requestSpecification undefined, was there a given or when method called?");
        }
    }

    public void body(String JSONstring) throws Exception{
        if (requestSpecification != null){
            requestSpecification = requestSpecification.body(JSONstring);
        } else {
            throw new Exception("requestSpecification unspecified, was there a call to given()?");
        }
    }

    public void request(String requestType, String endpoint) throws Exception{
        if (requestSpecification != null){
            response = requestSpecification.request(requestType, endpoint);
        } else {
            throw new Exception("requestSpecification undefined, was there a given or when method called?");
        }
    }

    public void then() throws Exception{
        if (response != null){
            validatableResponse = response.then();
        } else {
            throw new Exception("response undefined, was there a request method called?");
        }
    }

    public void statusCode(int expected) throws Exception{
        if (response != null){
            validatableResponse.statusCode(expected);
        } else {
            throw new Exception("validatableResponse undefined, was there a call to then()?");
        }
    }


    public void extractResponse() throws Exception{
        if (response != null){
            response = validatableResponse.extract().response();
        } else {
            throw new Exception("validatableResponse unspecified, was there a call to then()?");
        }
    }


    public void clear(){
        response = null;
        requestSpecification = null;
    }
}
