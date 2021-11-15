package Binance;

import com.automator.handler.RestHandler;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class BasicAPITests {
    private final String baseUrl = "https://api.binance.com";

    @Test
    public void fetchData(){
        System.out.println("Running binance api test");
        RestHandler apiHandler = new RestHandler();
        apiHandler.basicRequest("Accept" , "application/json" , "GET", baseUrl + "/api/v3/time");
        System.out.println("Response: " + apiHandler.asString());
    }
    @Test
    public void postData(){
        System.out.println("Running binance api test");
        JSONObject requestParams = new JSONObject();
        requestParams.put("symbol", "USDBTC");
        requestParams.put("side", "BUY");
        requestParams.put("type", "LIMIT");
        requestParams.put("timeInForce", "GTC");
        requestParams.put("quantity",  "1");
        requestParams.put("price",  "1");
        try {
            RestHandler apiHandler = new RestHandler();
            apiHandler.given();
            apiHandler.header("Content-Type", "application/x-www-form-urlencoded");
            apiHandler.header("apiKey", BinanceModel.APIKey);
            apiHandler.header("secretKey", BinanceModel.Secretkey);
            apiHandler.body(requestParams.toJSONString());
            apiHandler.post(baseUrl + "/api/v3/order");
            System.out.println("Response: " + apiHandler.asString());
        } catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
