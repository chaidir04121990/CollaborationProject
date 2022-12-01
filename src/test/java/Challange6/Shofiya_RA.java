package Challange6;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
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
                .then()
                .assertThat()
                .statusCode(200)
                .body("data.id[1]", Matchers.equalTo(8))
                .body("data.first_name", Matchers.hasItems("Michael","Lindsay"))
                .log().all();
                //.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/get_schema.json"));
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
                .then()
                .assertThat()
                .statusCode(201 )
                .body("name", Matchers.equalTo("Shofiya"))
                .body("job", Matchers.equalTo("QA"))
                .log().all()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/post_schema.json"));
    }

    @Test
    public void test3() {
        JSONObject request = new JSONObject();
        RestAssured.given()
                .body(request.toJSONString())
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .assertThat()
                .statusCode(204)
                .log().all();
    }

    @Test
    public void test4() {

        JSONObject request = new JSONObject();
        request.put("name", "Shofiya");
        request.put("job", "QA");

        System.out.println(request);
        System.out.println(request.toString());

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .assertThat()
                .statusCode(200)
                .log().all()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/put_schema.json"));
    }
}
