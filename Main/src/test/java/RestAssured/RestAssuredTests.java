package RestAssured;

import io.restassured.*;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class RestAssuredTests {
    @Test
    public void HelloWorld(){
        given().
        Response response = RestAssured.get("https://icanhazdadjoke.com/");
//        System.out.println(response.getHeaders().getValue("joke"));
        System.out.println(response.getHeader("joke"));
        System.out.println(response.asString());
    }
}
