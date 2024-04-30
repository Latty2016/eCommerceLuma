package Api_Test;

import com.qa.apiPayloadUtilities.CustomerPayloadUtility;
import com.qa.configFileManager.ConfigFileManager;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.log4testng.Logger;


public class Rest_Assured_API {
    private static String baseUrl;
    private static String apiToken;
    private static String configFile = "config.properties";
    Logger log = Logger.getLogger(Rest_Assured_API.class);

    @BeforeClass
    public void setUp(){
      baseUrl = ConfigFileManager.readValue(configFile,"api_baseUrl");
      apiToken = ConfigFileManager.readValue(configFile,"api_user_token");
    }
    @Test(description = "Authorized user should be able to get all countries")
    public void getAllCountriesTest(){
        //send request get response
        Response response = (Response) RestAssured.given().header("Authorization","Bearer " + apiToken)
                .when().get(baseUrl+ "V1/directory/countries");
        //.when().get(baseUrl+ "/V1/directory/countries").then().assertThat().statusCode(200);
        System.out.println(response.getBody().prettyPrint());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
      }
      @Test(description = "Authorized user should be able to get currency")
    public void getCurrencyTest(){
        Response response = (Response) RestAssured.given().header("Authorization","Bearer" + apiToken)
                .when().get(baseUrl + "V1/directory/currency");
          System.out.println(response.getBody().prettyPrint());
          int statusCode = response.getStatusCode();
          Assert.assertEquals(statusCode,200);
      }
      @Test(description = "Authorized user should be able to get specific country by using country id")
    public void getCountryTest(){
        Response response = (Response)RestAssured.given().header("Authorization","Bearer" + apiToken)
                .when().get(baseUrl + "V1/directory/countries/TR");
          System.out.println(response.getBody().prettyPrint());
          int statusCode = response.getStatusCode();
          Assert.assertEquals(statusCode,200);

      }
    }

