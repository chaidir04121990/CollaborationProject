package TestNG_RA;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Nizam_RestAssured {
    @Test
    public void get(){
        RestAssured.given()
                .header("Content-Type", "application/json")
                .queryParam("q", "John")
                .get("https://dummyjson.com/users/search")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("users.id", Matchers.hasItems(50))
                .body("users.firstName", Matchers.hasItems("Johnathon"))
                .body("users.lastName", Matchers.hasItems("Predovic"));

    }

    @Test
    public void post(){
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("firstName", "Nizam");
        bodyJson.put("lastName", "Aditya");
        bodyJson.put("age",22);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .post("https://dummyjson.com/users/add")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("firstName", Matchers.equalTo("Nizam"))
                .body("lastName", Matchers.equalTo("Aditya"))
                .body("age",Matchers.equalTo(22));
    }

    @Test
    public void put() {
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("firstName", "Nizam");
        bodyJson.put("lastName", "Aditya");
        bodyJson.put("age",22);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .put("https://dummyjson.com/users/1")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("firstName", Matchers.equalTo("Nizam"))
                .body("lastName", Matchers.equalTo("Aditya"))
                .body("age",Matchers.equalTo(22));
    }

    @Test
    public void delete() {
        RestAssured.given()
                .delete("https://dummyjson.com/users/1")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("isDeleted", Matchers.equalTo(true));
    }
}
