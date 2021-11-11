package RestTests;

import com.automator.handler.RestHandler;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RestAssuredTests {
    @Test
    public void HelloWorld(){
        RestHandler example = new RestHandler();
        example.response = RestAssured.given().header("Accept", "text/plain")
                .when().get("https://icanhazdadjoke.com/")
                .then().statusCode(200).extract().response();
        System.out.println(example.response.body().asString());
        System.out.println("have a dad joke: " +  example.asString());
    }
}
