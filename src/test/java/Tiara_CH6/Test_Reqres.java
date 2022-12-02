package Tiara_CH6;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Reqres {
//
//    @Test (priority = 1)
//    public void test_get(){
//        //get single user not found
//
//        RestAssured.baseURI = "https://reqres.in/api/users/23";
//
//        RequestSpecification httpRequest = RestAssured.given();
//        Response response = httpRequest.request(Method.GET,"");
//
//        System.out.println("Status received : " + response.getStatusLine());
//
//        int statusCode = response.getStatusCode();
//        Assert.assertEquals(statusCode, 404);
//        System.out.println("Status code is " + statusCode);
//
//        int responseTime = (int) response.getTime();
//        System.out.println("Response time is " + responseTime + " ms");
//
//        System.out.println(response.asPrettyString());
//    }
//
//    @Test (priority = 2)
//    public void test_post(){
//        //post create
//        JSONObject objJSON = new JSONObject();
//        objJSON.put("name", "morpheus");
//        objJSON.put("job", "leader");
//
//        RestAssured.baseURI = "https://reqres.in/api/users";
//
//        RequestSpecification httpRequest = RestAssured.given();
//        httpRequest.body(objJSON.toString());
//
//        Response response = httpRequest.request(Method.POST, "");
//
//        System.out.println("Status received : " + response.getStatusLine());
//
//        int statusCode = response.getStatusCode();
//        Assert.assertEquals(statusCode, 201);
//        System.out.println("Status code is " + statusCode);
//
//        int responseTime = (int) response.getTime();
//        System.out.println("Response time is " + responseTime + " ms");
//
//        System.out.println(response.asPrettyString());
//    }
//
//    @Test (priority = 3)
//    public void test_delete(){
//
//        RestAssured.baseURI = "https://reqres.in/api/users/2";
//
//        RequestSpecification httpRequest = RestAssured.given();
//        Response response = httpRequest.request(Method.DELETE,"");
//
//        System.out.println("Status received : " + response.getStatusLine());
//
//        int statusCode = response.getStatusCode();
//        Assert.assertEquals(statusCode, 204);
//        System.out.println("Status code is " + statusCode);
//
//        int responseTime = (int) response.getTime();
//        System.out.println("Response time is " + responseTime + " ms");
//
//        System.out.println(response.asPrettyString());
//    }
//
//    @Test (priority = 4)
//    public void test_put(){
//        JSONObject objJSON = new JSONObject();
//        objJSON.put("name", "morpheus");
//        objJSON.put("job", "zion resident");
//
//        RestAssured.baseURI = "https://reqres.in/api/users/2";
//
//        RequestSpecification httpRequest = RestAssured.given();
//        Response response = httpRequest.request(Method.PUT,"");
//        httpRequest.body(objJSON.toString());
//
//        System.out.println("Status received : " + response.getStatusLine());
//
//        int statusCode = response.getStatusCode();
//        Assert.assertEquals(statusCode, 200);
//        System.out.println("Status code is " + statusCode);
//
//        int responseTime = (int) response.getTime();
//        System.out.println("Response time is " + responseTime + " ms");
//
//        System.out.println(response.asPrettyString());
//    }

    @Test (priority = 5)
    public void test_get_all_data(){

        RestAssured.baseURI = "https://reqres.in/api/users?page=2";

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"");

        System.out.println("Status received : " + response.getStatusLine());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("Status code is " + statusCode);

        int responseTime = (int) response.getTime();
        System.out.println("Response time is " + responseTime + " ms");

        System.out.println(response.asPrettyString());
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("src/test/resources/schema/schema.json"));
    }
}
