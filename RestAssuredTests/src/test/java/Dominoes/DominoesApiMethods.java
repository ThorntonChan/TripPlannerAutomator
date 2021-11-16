package Dominoes;

import com.automator.handler.RestHandler;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DominoesApiMethods {
    static final String baseURL = "http://localhost";
    private RestHandler restHandler = new RestHandler();
    private String token;

    public DominoesApiMethods(){};

    public String login(String email, String password){
        Map<String, String> bodyParams = new HashMap<String, String>();
        bodyParams.put("email", email);
        bodyParams.put("password", password);
        JSONObject body = restHandler.bodyMaptoJSON(bodyParams);
        restHandler.quickRequest("POST", "/admin/auth/login", new HashMap<String, String>(), bodyParams);
        token = restHandler.response.path("token");
        return token;
    }

    public void getAllQuizzes(String token2){
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Bearer " + token);
        restHandler.quickRequest("GET", "/admin/quiz", headers, new HashMap<String, String>());
        System.out.println((String) restHandler.response.path("quizzes"));
    }

//    public String logout(){
//        if (token == null) {
//            System.out.println("Please call login first");
//        }
//    }

}
