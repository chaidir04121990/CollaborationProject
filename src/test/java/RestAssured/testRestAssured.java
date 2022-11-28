package RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class testRestAssured {
    //GET test
    @Test
    public void test_1() {
        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.getStatusCode());

        System.out.println(response.getTime());

        System.out.println(response.getBody().asString());

        System.out.println(response.getStatusLine());

        System.out.println(response.getHeader("content-type"));

        Integer statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);
    }

    //GET test
    @Test
    public void test_2() {
        baseURI = "https://reqres.in/";
        given().get(baseURI + "api/users?page=2").then().statusCode(200).body("data[1].id",equalTo(8)).log().all();
    }

    //POST test
    @Test
    public void test_3() {
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("name", "Dimas");
        bodyJson.put("job", "Student");
        bodyJson.toString();

        baseURI = "https://reqres.in/";

        given().header("Content-Type", "application/json")
                //Mengirim data dalam bentuk JSON
                .contentType(ContentType.JSON)
                //Menerima data dalam bentuk JSON
                .accept(ContentType.JSON)
                .body(bodyJson.toString())
                .when()
                .post(baseURI + "api/users/2")
                .then()
                //validate status code
                .statusCode(201)
                //validate body
                .body("name", equalTo("Dimas"))
                .body("job", equalTo("Student"))
                .log()
                .all();
    }

    //PUT test
    @Test
    public void test_4() {
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("name", "Dimas");
        bodyJson.put("job", "Student");
        bodyJson.toString();

        baseURI = "https://reqres.in/";

        given().header("Content-Type", "application/json")
                //Mengirim data dalam bentuk JSON
                .contentType(ContentType.JSON)
                //Menerima data dalam bentuk JSON
                .accept(ContentType.JSON)
                .body(bodyJson.toString())
                .when()
                //PUT method
                .put(baseURI + "api/users/2")
                .then()
                //validate status code
                .statusCode(200)
                //validate body
                .body("name", equalTo("Dimas"))
                .body("job", equalTo("Student"))
                .log()
                .all();
    }
}