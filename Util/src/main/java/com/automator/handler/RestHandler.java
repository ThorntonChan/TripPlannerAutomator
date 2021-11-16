package com.automator.handler;

import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.Map;


public class RestHandler {
    public Response response;

    public RestHandler(){
        RestAssured.requestSpecification = RestAssured.given();
    }

    public void addHeader(String s, String o){
        RestAssured.requestSpecification.header(s, o);
    }

    public void addBody(String bodyAsString){
        RestAssured.requestSpecification.body(bodyAsString);
    }

    public void addOAuth(String token){
        RestAssured.requestSpecification.auth().oauth2(token);
    }

    public void request(String request_type, String endpoint){
        RestAssured.request(request_type, endpoint);
    }

    public void quickRequest(String request_type, String endpoint, Map<String, String> headerParams, Map<String, String> bodyParams){
        JSONObject body = bodyMaptoJSON(bodyParams);
            RestAssured
                .given();
                for (Map.Entry<String, String> head : headerParams.entrySet()) {
                    RestAssured.requestSpecification.header(head.getKey(), head.getValue());
                }
            response = RestAssured.requestSpecification.body(body.toJSONString())
                .when()
                .request(request_type, endpoint)
                .then()
                .extract().response();
    }

    public JSONObject bodyMaptoJSON(Map<String, String> params){
        JSONObject bodyBuilder = new JSONObject();
        for (Map.Entry<String, String> entry : params.entrySet()){
            bodyBuilder.put(entry.getKey(), entry.getValue());
        }
        return bodyBuilder;
    }
}

    // Todo public map of Json Response
