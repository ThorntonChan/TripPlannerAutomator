package Binance;

import com.automator.handler.RestHandler;
import org.testng.annotations.Test;

public class BasicAPITests {
    private final String baseUrl = "https://api.binance.com";

    @Test
    public void fetchData(){
        System.out.println("Running binance api test");
        RestHandler apiHandler = new RestHandler();
        apiHandler.basicRequest("Accept" , "application/json" , "GET", baseUrl + "/api/v3/exchangeInfo");
        System.out.println("Response: " + apiHandler.asString());
    }
}
