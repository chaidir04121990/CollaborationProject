package Tugas2_TestNG_RestAssuredReqres;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;

public class TangkasWahyu_RestAssured {
    String baseUrl = "https://reqres.in/api/users";

    @Test(priority = 1)
    public void testGetRequest1() {
        baseURI = baseUrl;

        RestAssured.given()
                .header("Content-Type", "application/json")
                .get(baseURI +"?page=2")
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/get1.json"))
                .statusCode(200)
                .body("page",Matchers.equalTo(2))
                .log()
                .all();
    }

    @Test(priority = 2)
    public void testGetRequest2() {
        baseURI = baseUrl;
        RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("id", 7)
                .get(baseURI +"?page=2")
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/get2.json"))
                .statusCode(200)
                .body("data.id", Matchers.equalTo(7))
                .body("data.email", Matchers.equalTo("michael.lawson@reqres.in"))
                .body("data.first_name", Matchers.equalTo("Michael"))
                .body("data.last_name", Matchers.equalTo("Lawson"))
                .log()
                .all();;
    }

    @Test(priority = 3)
    public void testPostRequest() {
        JSONObject bodyJson = new JSONObject();
        baseURI = baseUrl;

        bodyJson.put("name", "TangkasWahyu");
        bodyJson.put("job", "Associate QA Engineer");

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .post(baseURI)
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/post.json"))
                .statusCode(201)
                .body("name", Matchers.equalTo("TangkasWahyu"))
                .body("job", Matchers.equalTo("Associate QA Engineer"))
                .log()
                .all();
    }

    @Test(priority = 4)
    public void testPutRequest() {
        JSONObject bodyJson = new JSONObject();
        baseURI = baseUrl;

        bodyJson.put("name", "TangkasWahyu");
        bodyJson.put("job", "Associate QA Engineer");

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .put(baseURI + "/2")
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/put.json"))
                .statusCode(200)
                .body("name", Matchers.equalTo("TangkasWahyu"))
                .body("job", Matchers.equalTo("Associate QA Engineer"))
                .log()
                .all();
    }

    @Test(priority = 5)
    public void testPatchRequest() {
        JSONObject bodyJson = new JSONObject();
        baseURI = baseUrl;

        bodyJson.put("name", "TangkasWahyu");
        bodyJson.put("job", "Associate QA Engineer");

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .patch(baseURI + "/2")
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/patch.json"))
                .statusCode(200)
                .body("name", Matchers.equalTo("TangkasWahyu"))
                .body("job", Matchers.equalTo("Associate QA Engineer"))
                .log()
                .all();
    }

    @Test(priority = 6)
    public void testDeleteRequest() {
        baseURI = baseUrl;

        RestAssured.given()
                .header("Content-Type", "application/json")
                .delete(baseURI + "/2")
                .then()
                .assertThat()
                .statusCode(204)
                .log()
                .all();;
    }
}
