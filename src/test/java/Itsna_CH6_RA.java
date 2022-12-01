import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class Itsna_CH6_RA {
    @Test
    public void getRequest() {
        RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("id", 2)
                .get("https://reqres.in/api/users")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("data.id", Matchers.equalTo(2))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/get_schema.json"));
    }

    @Test
    public void putRequest() {
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("name", "kiiakiia");
        bodyJson.put("job", "less");

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .put("https://reqres.in/api/users/2")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("name", Matchers.equalTo("kiiakiia"))
                .body("job", Matchers.equalTo("less"))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/put_schema.json"));
    }

    @Test
    public void patchRequest() {
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("name", "kiiakiia");
        bodyJson.put("job", "CEO");

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .patch("https://reqres.in/api/users/2")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("name", Matchers.equalTo("kiiakiia"))
                .body("job", Matchers.equalTo("CEO"))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/patch_schema.json"));
    }

    @Test
    public void postRequest() {
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("name", "kiiakiia");
        bodyJson.put("job", "this is a job");

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .post("https://reqres.in/api/users")
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .body("name", Matchers.equalTo("kiiakiia"))
                .body("job", Matchers.equalTo("this is a job"))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/post_schema.json"));
    }

    @Test
    public void deleteRequest() {
        RestAssured.given()
                .header("Content-Type", "application/json")
                .delete("https://reqres.in/api/users/1")
                .then().log().all()
                .assertThat()
                .statusCode(204);
    }
}
