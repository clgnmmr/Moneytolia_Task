package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ApiUtils;
import utilities.ConfigurationReader;
import static hooks.Hooks.*;

public class ApiStepDef {

    Response response;

    @Given("User sends  Get request {string}")
    public void userSendsGetRequest(String list) {
         apiTest="ON";
        response= ApiUtils.getRequest(ConfigurationReader.getProperty(list));
        response.prettyPrint();
    }

    JsonPath jsonPath;
    @Then("User validates statuscode {string}")
    public void userValidatesStatuscode(String statusCode) {

        jsonPath=response.jsonPath();
        if (jsonPath.getInt("responseCode")==200) {
            response.then().statusCode(Integer.parseInt(statusCode));
            System.out.println("jsonPath.getString(\"responseCode\") = " + jsonPath.getString("responseCode"));
            Assert.assertEquals(statusCode,jsonPath.getString("responseCode"));
            System.out.println("jsonPath.getList(\"products.id\") = " + jsonPath.getList("products.id"));
            for (int i = 0; i <jsonPath.getList("products.id").size() ; i++) {

                Assert.assertTrue(jsonPath.getList("products.id").get(i)!=null);
            }
        }else {
            Assert.assertEquals(statusCode,jsonPath.getString("responseCode"));
            Assert.assertEquals(ConfigurationReader.getProperty("message405"),jsonPath.getString("message"));

        }
    }

    @Given("User sends  Post request {string}")
    public void userSendsPostRequest(String list) {
        apiTest="ON";
        response= ApiUtils.postRequest(ConfigurationReader.getProperty(list),"");
        response.prettyPrint();
    }
}
