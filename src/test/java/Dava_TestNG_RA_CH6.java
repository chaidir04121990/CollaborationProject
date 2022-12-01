import io.restassured.module.jsv.JsonSchemaValidator;
import okhttp3.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import org.json.JSONObject;

public class Dava_TestNG_RA_CH6 {

    String url = "https://reqres.in/api";
//    @BeforeMethod
//    public void prep(){
//
//    }
    @Test
    public void test_get_a_user(){
        RestAssured.given()
                .get(url+"/users/2")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema_get_a_user.json"));
    }
    @Test
    public void test_post_a_user(){

        JSONObject bodyJson = new JSONObject();

        bodyJson.put("name","Dava");
        bodyJson.put("job","Tester");

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .post(url+"/users")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201)
                .body("name", Matchers.equalTo("Dava"))
                .body("job", Matchers.equalTo("Tester"))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema_post_a_user.json"));
    }
    @Test
    public void test_put_a_user(){

        JSONObject bodyJson = new JSONObject();

        bodyJson.put("name","Jauhar");
        bodyJson.put("job","AI Engineer");

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .put(url+"/users/2")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .body("name", Matchers.equalTo("Jauhar"))
                .body("job", Matchers.equalTo("AI Engineer"))
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema_put_a_user.json"));
    }
    @Test
    public void test_delete_a_user(){

        RestAssured.given()
                .header("Content-Type", "application/json")
                .delete(url+"/users/2")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(204);
    }

}
