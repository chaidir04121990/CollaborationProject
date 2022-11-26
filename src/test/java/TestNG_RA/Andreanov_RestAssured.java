package TestNG_RA;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Andreanov_RestAssured {
    public String newAddress = "Bali";
    public String idPlace = "";
    public String keyValue = "qaclick123";

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI= "https://rahulshettyacademy.com";
    }

    @Test (priority = 1)
    public void post() {
        String response = given().log().all().queryParam("key", keyValue)
                .header("Content-Type", "application/json")
                .body("{\r\n" +
                        "  \"location\": {\r\n" +
                        "    \"lat\": -38.383494,\r\n" +
                        "    \"lng\": 33.427362\r\n" +
                        "  },\r\n" +
                        "  \"accuracy\": 90,\r\n" +
                        "  \"name\": \"Andreanov Ridhovan\",\r\n" +
                        "  \"phone_number\": \"(+62) 888999888\",\r\n" +
                        "  \"address\": \"Bekasi\",\r\n" +
                        "  \"types\": [\r\n" +
                        "    \"shoe park\",\r\n" +
                        "    \"shop\"\r\n" +
                        "  ],\r\n" +
                        "  \"website\": \"https://www.linkedin.com/in/andreanovr\",\r\n" +
                        "  \"language\": \"Indonesia-ID\"\r\n" +
                        "}\r\n" +
                        "")
                .when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.41 (Ubuntu)")
                .extract().response().asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String placeId = js.getString("place_id");
        idPlace = placeId;
    }

    @Test (priority = 2)
    public void update (){
        given().log().all().queryParam("key", keyValue)
                .header("Content-Type", "application/json")
                .body("{\r\n" +
                        "\"place_id\":\"" + idPlace + "\",\r\n" +
                        "\"address\":\"" + newAddress + "\",\r\n" +
                        "\"key\":\""+keyValue+"\"\r\n" +
                        "}")
                .when().put("maps/api/place/update/json")
                .then().assertThat().log().all()
                .statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

    }

    @Test (priority = 3)
    public void get (){
        String getPlaceResponse = given().log().all().queryParam("key", keyValue)
                .queryParam("place_id", idPlace)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all()
                .statusCode(200)
                .body("address", equalTo(newAddress))
                .extract().response().asString();

        JsonPath js = new JsonPath(getPlaceResponse);
        String actualAddress =js.getString("address");
        Assert.assertEquals(actualAddress, "Bali");
    }
}
