package TestNG_RA;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Itsna_RA {
    @Test
    public void getEmployee() {
        RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("id", 1)
                .get("https://reqres.in/api/users")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("data.id", Matchers.equalTo(1))
                .body("data.first_name", Matchers.equalTo("George"))
                .body("data.last_name", Matchers.equalTo("Bluth"));
    }

    @Test
    public void putEmployee() {
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
                .body("job", Matchers.equalTo("less"));
    }

    @Test
    public void patchEmployee() {
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
                .body("job", Matchers.equalTo("CEO"));
    }

    @Test
    public void postEmployee() {
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
                .body("job", Matchers.equalTo("this is a job"));
    }

    @Test
    public void deleteEmployee() {
        RestAssured.given()
                .header("Content-Type", "application/json")
                .delete("https://dummy.restapiexample.com/api/v1/delete/2")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("data", Matchers.equalTo("2"))
                .body("message", Matchers.containsString("Successfully!"));
    }
}