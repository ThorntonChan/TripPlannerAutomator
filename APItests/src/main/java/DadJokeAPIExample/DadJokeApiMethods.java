package DadJokeAPIExample;

import com.automator.handler.RestHandler;
import java.util.HashMap;
import java.util.Map;

public class DadJokeApiMethods {
    private RestHandler restHandler = new RestHandler();
    private final String baseURL = "https://icanhazdadjoke.com";

    public DadJokeApiMethods(){};

    public Map<String, String> getRandomDadJoke(){
        Map<String, String> result = new HashMap<String, String>();
        Map<String, String> headers= new HashMap<String, String>();
        headers.put("Accept", "application/json");
        restHandler.quickRequest("GET", baseURL, headers, new HashMap<String, String>());
        result.put(restHandler.response.path("id"), restHandler.response.path("joke"));
        return result;
    }

    public Map<String, String> getDadJoke(String id){
        Map<String, String> result = new HashMap<String, String>();
        restHandler.addHeader("Accept", "application/json");
        restHandler.quickRequest("GET", baseURL + "/j/" + id, new HashMap<String, String>(), new HashMap<String, String>());
        result.put(restHandler.response.path("id"), restHandler.response.path("joke"));
        return result;
    }

//    public Map<String, String> getDadJoke(String id){
//        Map<String, String> result = new HashMap<String, String>();
//        restHandler.addHeader("Accept", "application/json");
//        restHandler.quickRequest("GET", baseURL + "/j/" + id, new HashMap<String, String>(), new HashMap<String, String>());
//        result.put(restHandler.response.path("id"), restHandler.response.path("joke"));
//        return result;
//    }



//
//        RestAssured
//                .given()
//                .pathParam("jid", "caxscaMRnjb")
//                .header("Accept", "application/json")
//                .when()
//                .get(baseUrl + "/j/{jid}")
//                .then()
//                .statusCode(200)
//                .body("joke", equalTo("Did you know the first French fries weren't actually cooked in France? They were cooked in Greece."))
//                .extract().response();
//    }
}
