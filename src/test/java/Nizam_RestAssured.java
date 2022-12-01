import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Nizam_RestAssured {
    @Test(priority = 1)
    public void get(){
        given()
                .header("Content-Type", "application/json")
                .get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/get.json"))
                .statusCode(200)
                .body("page",Matchers.equalTo(2));
    }

    @Test(priority = 2)
    public void post(){
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("name", "morpheus");
        bodyJson.put("job", "leader");

        given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .post("https://reqres.in/api/users")
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/post.json"))
                .statusCode(201)
                .body("name", Matchers.equalTo("morpheus"))
                .body("job", Matchers.equalTo("leader"));
    }

    @Test(priority = 3)
    public void put() {
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("name", "morpheus");
        bodyJson.put("job", "zion resident");

        given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .put("https://reqres.in/api/users/2")
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/put.json"))
                .assertThat()
                .statusCode(200)
                .body("name", Matchers.equalTo("morpheus"))
                .body("job", Matchers.equalTo("zion resident"));
    }

    @Test(priority = 4)
    public void delete(){
        given()
                .delete("https://reqres.in/api/users/2")
                .then()
                .assertThat()
                .statusCode(204);
    }
}
