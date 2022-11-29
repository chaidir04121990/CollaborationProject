package Testing_tesNG_Kamis.RestAssuredDummy;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TangkasWahyu_TestNG_RA {
    @Test (priority = 1)
    public void GetUserDummyRest() {
        RestAssured.given()
                .header("Content-Type", "application/json")
                .get("https://dummy.restapiexample.com/api/v1/employee/1")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("data.id", Matchers.equalTo(1))
                .body("data.employee_name", Matchers.equalTo("Tiger Nixon"))
                .body("data.employee_salary", Matchers.equalTo(320800))
                .body("data.employee_age", Matchers.equalTo(61));
//                .body("profile_image", Matchers.equalTo(""));
    }

    @Test (priority = 2)
    public void PostUserDummyRest2() {
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("name", "TangkasWahyu");
        bodyJson.put("salary", 330800);
        bodyJson.put("age", 24);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .post("https://dummy.restapiexample.com/api/v1/create")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("data.name", Matchers.equalTo("TangkasWahyu"))
                .body("data.salary", Matchers.equalTo(330800))
                .body("data.age", Matchers.equalTo(24));
    }

    @Test (priority = 3)
    public void PutUserDummyRest3() {
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("name", "TangkasWahyu");
        bodyJson.put("salary", 330800);
        bodyJson.put("age", 24);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .put("https://dummy.restapiexample.com/api/v1/update/21")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("data.name", Matchers.equalTo("TangkasWahyu"))
                .body("data.salary", Matchers.equalTo(330800))
                .body("data.age", Matchers.equalTo(24));
    }

    @Test (priority = 4)
    public void PatchUserDummyRest4() {
        JSONObject bodyJson = new JSONObject();

        bodyJson.put("name", "TangkasWahyu");
        bodyJson.put("salary", 330800);
        bodyJson.put("age", 24);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(bodyJson.toString())
                .patch("https://dummy.restapiexample.com/api/v1/update/21")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("data.name", Matchers.equalTo("TangkasWahyu"))
                .body("data.salary", Matchers.equalTo(330800))
                .body("data.age", Matchers.equalTo(24));
    }

    @Test (priority = 5)
    public void DeleteUserDummyRest5() {
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
