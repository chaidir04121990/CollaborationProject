package RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class testRestAssured {
    //GET test
    @Test
    public void test_1() {
        baseURI = "https://reqres.in/";
        given().get(baseURI + "api/users?page=2").then()
                //validate json schema
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/get_schema.json"))
                //validate status code
                .statusCode(200)
                .body("data[1].id",equalTo(8)).log().all();
    }

    //POST test
    @Test
    public void test_2() {
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
                //validate json schema
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/post_schema.json"))
                .log()
                .all();
    }

    //PUT test
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
                //PUT method
                .put(baseURI + "api/users/2")
                .then()
                //validate status code
                .statusCode(200)
                //validate body
                .body("name", equalTo("Dimas"))
                .body("job", equalTo("Student"))
                //validate json schema
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/put_schema.json"))
                .log()
                .all();
    }

    //DELETE test
    @Test
    public void test_4() {
        baseURI = "https://reqres.in/";

        when()
                .delete("api/users?page=2")
                .then()
                //validate status code
                .statusCode(204)
                .log()
                .all();
    }
}