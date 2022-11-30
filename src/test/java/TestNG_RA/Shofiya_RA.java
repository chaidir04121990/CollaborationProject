package TestNG_RA;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;

public class Shofiya_RA {
    @Test
    public void test() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test1() {
        RestAssured.given()
                .header("Content-Type", "application/json")
                .get("https://reqres.in/api/users?page=2")
                .then().statusCode(200)
                .body("data.id[1]", equalTo(8))
                .body("data.first_name", hasItems("Michael","Lindsay"))
                .log().all();
    }

    @Test
    public void test2() {
        JSONObject request = new JSONObject();
        request.put("name", "Shofiya");
        request.put("job", "QA");

        System.out.println(request);
        System.out.println(request.toString());

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then().statusCode(201 )
                .body("name", equalTo("Shofiya"))
                .body("job", equalTo("QA"))
                .log().all();
    }

    @Test
    public void test3() {
        JSONObject request = new JSONObject();
        RestAssured.given()
                .body(request.toJSONString())
                .when()
                .delete("https://reqres.in/api/users/2")
                .then().statusCode(204)
                .log().all();
    }
}
