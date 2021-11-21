package com.automator.handler;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.List;
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

//    public Map<Object, Map<String, Object>> deserializeToMaps(){
//        if (response == null)
//            return null;
//        Map<Object, Map<String, Object>> body = response.as(new TypeRef<Map<Object, Map<String, Object>>>() {});
//        return body;
//    }

    public Map<String, Object> deserializeToMap(){
        if (response == null)
            return null;
        return response.as(new TypeRef<Map<String, Object>>() {});
    }
    public List<Map<String, Object>> deserializeToMaps(){
        if (response == null)
            return null;
        return response.as(new TypeRef<List<Map<String, Object>>>() {});
    }

    public List<Object> deserializeToList(){
        if (response == null)
            return null;
        return response.as(new TypeRef<List<Object>>() {});
    }

    public List<List<Object>> deserializeToLists(){
        if (response == null)
            return null;
        return response.as(new TypeRef<List<List<Object>>>() {});
    }

}

    // TODO: nested Maps in JSON
