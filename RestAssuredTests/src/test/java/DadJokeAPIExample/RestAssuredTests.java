package DadJokeAPIExample;

import com.automator.handler.RestHandler;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class RestAssuredTests {
    private String baseUrl = "https://icanhazdadjoke.com";

//    @Test
//    public void textPlain(){
//        RestHandler example = new RestHandler();
//        example.response = RestAssured
//                .given()
//                    .header("Accept", "text/plain")
//                .when()
//                    .get(baseUrl)
//                .then()
//                    .statusCode(200)
//                .extract().response();
//        System.out.println("have a dad joke: " +  example.asString());
//    }

    @Test
    public void applicationJson(){
        RestAssured
            .given()
                .pathParam("jid", "caxscaMRnjb")
                .header("Accept", "application/json")
            .when()
                .get(baseUrl + "/j/{jid}")
            .then()
                .statusCode(200)
                .body("joke", equalTo("Did you know the first French fries weren't actually cooked in France? They were cooked in Greece."))
            .extract().response();
    }

    @Test
    public void applicationJsonWHandler(){
        try {
            RestHandler dadJokeApiCall = new RestHandler();
            dadJokeApiCall.given();
            dadJokeApiCall.header("Accept", "application/json");
            dadJokeApiCall.when();
            dadJokeApiCall.request("GET", baseUrl);
            dadJokeApiCall.then();
            dadJokeApiCall.statusCode(200);
            dadJokeApiCall.extractResponse();
            System.out.println("have a dad joke: " +  dadJokeApiCall.asString());
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
//    @Test
//    public void applicationJsonHandler(){
//        RestAssured.given()
//                .pathParam("jid", "caxscaMRnjb")
//                .header("Accept", "application/json")
//                .when()
//                    .get(baseUrl + "/j/{jid}")
//                .then()
//                    .statusCode(200)
//                    .body("joke", equalTo("Did you know the first French fries weren't actually cooked in France? They were cooked in Greece."))
//                .extract().response();
//    }

//    @Test
//    public void formparam(){
//        RestAssured
//                .given()
//                .when()
//                    .get(baseUrl + "https://signin.ebay.com.au/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.com.au%2F")
//                    .formParams("userid", "jimmy").post("/")
//                .then()
//                    .statusCode(200)
//                .extract().response();
//    }

    //TODO Deserialization with Generics

}
