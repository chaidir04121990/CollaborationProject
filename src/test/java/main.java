import com.jayway.restassured.module.jsv.JsonSchemaValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class main extends config {

    @Test (priority = 1)
    public void getListUser() throws InterruptedException {
        // Open Web
        driver.get(url);


        // Click Method Button
        WebElement methodButton = driver.findElement(By.xpath(methodButtonXPath+"[1]/a"));
        methodButton.click();

        // Get Path
        WebElement path = driver.findElement(By.xpath(pathXPath));
        Thread.sleep(waitTime);

        // Get Status Code
        WebElement statusCode = driver.findElement(By.xpath(statusCodeXPath));

        // API Test & Validate
        given().log().all()
                .header("Content-Type", contentTypeValue)
                .when().get(path.getText())
                .then().assertThat().statusCode(Integer.parseInt(statusCode.getText()))
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/schema/getListUserSchema.json")))
                .header("server", serverValue)
                .extract().response().asString();
    }

    @Test (priority = 2)
    public void getSingleUser() throws InterruptedException {
        // Open Web
        driver.get(url);

        // Click Method Button
        WebElement methodButton = driver.findElement(By.xpath(methodButtonXPath+"[2]/a"));
        methodButton.click();

        // Get Path
        WebElement path = driver.findElement(By.xpath(pathXPath));
        Thread.sleep(waitTime);

        // Get Status Code
        WebElement statusCode = driver.findElement(By.xpath(statusCodeXPath));

        // API Test & Validate
        given().log().all()
                .header("Content-Type", contentTypeValue)
                .when().get(path.getText())
                .then().assertThat().statusCode(Integer.parseInt(statusCode.getText()))
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/schema/getSingleUserSchema.json")))
                .header("server", serverValue)
                .extract().response().asString();
    }

    @Test (priority = 3)
    public void getSingleUserNotFound() throws InterruptedException {
        // Open Web
        driver.get(url);

        // Click Method Button
        WebElement methodButton = driver.findElement(By.xpath(methodButtonXPath+"[3]/a"));
        methodButton.click();

        // Get Path
        WebElement path = driver.findElement(By.xpath(pathXPath));
        Thread.sleep(waitTime);

        // Get Status Code
        WebElement statusCode = driver.findElement(By.xpath(statusCodeXPath));

        // API Test & Validate
        given().log().all()
                .header("Content-Type", contentTypeValue)
                .when().get(path.getText())
                .then().assertThat().statusCode(Integer.parseInt(statusCode.getText()))
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/schema/getSingleUserNotFoundSchema.json")))
                .header("server", serverValue)
                .extract().response().asString();
    }

    @Test (priority = 4)
    public void getListResource() throws InterruptedException {
        // Open Web
        driver.get(url);

        // Click Method Button
        WebElement methodButton = driver.findElement(By.xpath(methodButtonXPath+"[4]/a"));
        methodButton.click();

        // Get Path
        WebElement path = driver.findElement(By.xpath(pathXPath));
        Thread.sleep(waitTime);

        // Get Status Code
        WebElement statusCode = driver.findElement(By.xpath(statusCodeXPath));

        // API Test & Validate
        given().log().all()
                .header("Content-Type", contentTypeValue)
                .when().get(path.getText())
                .then().assertThat().statusCode(Integer.parseInt(statusCode.getText()))
                .body("page", equalTo(1))
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/schema/getListResourceSchema.json")))
                .header("server", serverValue)
                .extract().response().asString();
    }

    @Test (priority = 5)
    public void getSingleResource() throws InterruptedException {
        // Open Web
        driver.get(url);

        // Click Method Button
        WebElement methodButton = driver.findElement(By.xpath(methodButtonXPath+"[5]/a"));
        methodButton.click();

        // Get Path
        WebElement path = driver.findElement(By.xpath(pathXPath));
        Thread.sleep(waitTime);

        // Get Status Code
        WebElement statusCode = driver.findElement(By.xpath(statusCodeXPath));

        // API Test & Validate
        given().log().all()
                .header("Content-Type", contentTypeValue)
                .when().get(path.getText())
                .then().assertThat().statusCode(Integer.parseInt(statusCode.getText()))
                .body("data.id", equalTo(2))
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/schema/getSingleResourceSchema.json")))
                .header("server", serverValue)
                .extract().response().asString();
    }

    @Test (priority = 6)
    public void getSingleResourceNotFound() throws InterruptedException {
        // Open Web
        driver.get(url);

        // Click Method Button
        WebElement methodButton = driver.findElement(By.xpath(methodButtonXPath+"[6]/a"));
        methodButton.click();

        // Get Path
        WebElement path = driver.findElement(By.xpath(pathXPath));
        Thread.sleep(waitTime);

        // Get Status Code
        WebElement statusCode = driver.findElement(By.xpath(statusCodeXPath));

        // API Test & Validate
        given().log().all()
                .header("Content-Type", contentTypeValue)
                .when().get(path.getText())
                .then().assertThat().statusCode(Integer.parseInt(statusCode.getText()))
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/schema/getSingleResourceNotFoundSchema.json")))
                .header("server", serverValue)
                .extract().response().asString();
    }

    @Test (priority = 7)
    public void postUser() throws InterruptedException {
        // Open Web
        driver.get(url);

        // Click Method Button
        WebElement methodButton = driver.findElement(By.xpath(methodButtonXPath+"[7]/a"));
        methodButton.click();

        // Get Path
        WebElement path = driver.findElement(By.xpath(pathXPath));

        // Get Body Request
        WebElement bodyRequest = driver.findElement(By.xpath(bodyRequestXPath));
        Thread.sleep(waitTime);

        // Get Request Data
        WebElement data = driver.findElement(By.xpath(bodyRequestXPath+"/span[2]"));
        String dataConvert = data.getText();
        dataConvert = dataConvert.replace("\"", "");
        WebElement data1 = driver.findElement(By.xpath(bodyRequestXPath+"/span[4]"));
        String data1Convert = data1.getText();
        data1Convert = data1Convert.replace("\"", "");

        // Get Status Code
        WebElement statusCode = driver.findElement(By.xpath(statusCodeXPath));

        // API Test & Validate
        given().log().all()
                .header("Content-Type", contentTypeValue)
                .body(bodyRequest.getText())
                .when().post(path.getText())
                .then().assertThat().statusCode(Integer.parseInt(statusCode.getText()))
                .body("name", equalTo(dataConvert))
                .body("job", equalTo(data1Convert))
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/schema/postUserSchema.json")))
                .header("server", serverValue)
                .extract().response().asString();
    }


    @Test (priority = 8)
    public void updateUserPut() throws InterruptedException {
        // Open Web
        driver.get(url);

        // Click Method Button
        WebElement methodButton = driver.findElement(By.xpath(methodButtonXPath+"[8]/a"));
        methodButton.click();

        // Get Path
        WebElement path = driver.findElement(By.xpath(pathXPath));

        // Get Body Request
        WebElement bodyRequest = driver.findElement(By.xpath(bodyRequestXPath));
        Thread.sleep(waitTime);

        // Get Request Data
        WebElement data = driver.findElement(By.xpath(bodyRequestXPath+"/span[2]"));
        String dataConvert = data.getText();
        dataConvert = dataConvert.replace("\"", "");
        WebElement data1 = driver.findElement(By.xpath(bodyRequestXPath+"/span[4]"));
        String data1Convert = data1.getText();
        data1Convert = data1Convert.replace("\"", "");

        // Get Status Code
        WebElement statusCode = driver.findElement(By.xpath(statusCodeXPath));

        // API Test & Validate
        given().log().all()
                .header("Content-Type", contentTypeValue)
                .body(bodyRequest.getText())
                .when().put(path.getText())
                .then().assertThat().statusCode(Integer.parseInt(statusCode.getText()))
                .body("name", equalTo(dataConvert))
                .body("job", equalTo(data1Convert))
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/schema/updateUserPutSchema.json")))
                .header("server", serverValue)
                .extract().response().asString();
    }

    @Test (priority = 9)
    public void updateUserPatch() throws InterruptedException {
        // Open Web
        driver.get(url);

        // Click Method Button
        WebElement methodButton = driver.findElement(By.xpath(methodButtonXPath+"[9]/a"));
        methodButton.click();

        // Get Path
        WebElement path = driver.findElement(By.xpath(pathXPath));

        // Get Body Request
        WebElement bodyRequest = driver.findElement(By.xpath(bodyRequestXPath));
        Thread.sleep(waitTime);

        // Get Request Data
        WebElement data = driver.findElement(By.xpath(bodyRequestXPath+"/span[2]"));
        String dataConvert = data.getText();
        dataConvert = dataConvert.replace("\"", "");
        WebElement data1 = driver.findElement(By.xpath(bodyRequestXPath+"/span[4]"));
        String data1Convert = data1.getText();
        data1Convert = data1Convert.replace("\"", "");

        // Get Status Code
        WebElement statusCode = driver.findElement(By.xpath(statusCodeXPath));

        // API Test & Validate
        given().log().all()
                .header("Content-Type", contentTypeValue)
                .body(bodyRequest.getText())
                .when().patch(path.getText())
                .then().assertThat().statusCode(Integer.parseInt(statusCode.getText()))
                .body("name", equalTo(dataConvert))
                .body("job", equalTo(data1Convert))
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/schema/updateUserPatchSchema.json")))
                .header("server", serverValue)
                .extract().response().asString();
    }

    @Test (priority = 10)
    public void deleteUser() throws InterruptedException {
        // Open Web
        driver.get(url);

        // Click Method Button
        WebElement methodButton = driver.findElement(By.xpath(methodButtonXPath+"[10]/a"));
        methodButton.click();

        // Get Path
        WebElement path = driver.findElement(By.xpath(pathXPath));
        Thread.sleep(waitTime);

        // Get Status Code
        WebElement statusCode = driver.findElement(By.xpath(statusCodeXPath));

        // API Test & Validate
        given().log().all()
                .header("Content-Type", contentTypeValue)
                .when().delete(path.getText())
                .then().assertThat().statusCode(Integer.parseInt(statusCode.getText()))
//                .body(JsonSchemaValidator.matchesJsonSchema(
//                        new File("src/schema/deleteUserSchema.json")))
                .header("server", serverValue)
                .extract().response().asString();
    }

    @Test (priority = 11)
    public void postRegisterSuccessful() throws InterruptedException {
        // Open Web
        driver.get(url);

        // Click Method Button
        WebElement methodButton = driver.findElement(By.xpath(methodButtonXPath+"[11]/a"));
        methodButton.click();

        // Get Path
        WebElement path = driver.findElement(By.xpath(pathXPath));

        // Get Body Request
        WebElement bodyRequest = driver.findElement(By.xpath(bodyRequestXPath));
        Thread.sleep(waitTime);

        // Get Status Code
        WebElement statusCode = driver.findElement(By.xpath(statusCodeXPath));

        // API Test & Validate
        given().log().all()
                .header("Content-Type", contentTypeValue)
                .body(bodyRequest.getText())
                .when().post(path.getText())
                .then().assertThat().statusCode(Integer.parseInt(statusCode.getText()))
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/schema/postRegisterSuccsessfulSchema.json")))
                .header("server", serverValue)
                .extract().response().asString();
    }

    @Test (priority = 12)
    public void postRegisterUnsuccessful() throws InterruptedException {
        // Open Web
        driver.get(url);

        // Click Method Button
        WebElement methodButton = driver.findElement(By.xpath(methodButtonXPath+"[12]/a"));
        methodButton.click();

        // Get Path
        WebElement path = driver.findElement(By.xpath(pathXPath));

        // Get Body Request
        WebElement bodyRequest = driver.findElement(By.xpath(bodyRequestXPath));
        Thread.sleep(waitTime);

        // Get Status Code
        WebElement statusCode = driver.findElement(By.xpath(statusCodeXPath));

        // API Test & Validate
        given().log().all()
                .header("Content-Type", contentTypeValue)
                .body(bodyRequest.getText())
                .when().post(path.getText())
                .then().assertThat().statusCode(Integer.parseInt(statusCode.getText()))
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/schema/postRegisterUnsuccsessfulSchema.json")))
                .header("server", serverValue)
                .extract().response().asString();
    }

    @Test (priority = 13)
    public void postLoginSuccessful() throws InterruptedException {
        // Open Web
        driver.get(url);

        // Click Method Button
        WebElement methodButton = driver.findElement(By.xpath(methodButtonXPath+"[13]/a"));
        methodButton.click();

        // Get Path
        WebElement path = driver.findElement(By.xpath(pathXPath));

        // Get Body Request
        WebElement bodyRequest = driver.findElement(By.xpath(bodyRequestXPath));
        Thread.sleep(waitTime);

        // Get Status Code
        WebElement statusCode = driver.findElement(By.xpath(statusCodeXPath));

        // API Test & Validate
        given().log().all()
                .header("Content-Type", contentTypeValue)
                .body(bodyRequest.getText())
                .when().post(path.getText())
                .then().assertThat().statusCode(Integer.parseInt(statusCode.getText()))
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/schema/postLoginSuccsessfulSchema.json")))
                .header("server", serverValue)
                .extract().response().asString();
    }

    @Test (priority = 14)
    public void postLoginUnsuccessful() throws InterruptedException {
        // Open Web
        driver.get(url);

        // Click Method Button
        WebElement methodButton = driver.findElement(By.xpath(methodButtonXPath+"[14]/a"));
        methodButton.click();

        // Get Path
        WebElement path = driver.findElement(By.xpath(pathXPath));

        // Get Body Request
        WebElement bodyRequest = driver.findElement(By.xpath(bodyRequestXPath));
        Thread.sleep(waitTime);

        // Get Status Code
        WebElement statusCode = driver.findElement(By.xpath(statusCodeXPath));

        // API Test & Validate
        given().log().all()
                .header("Content-Type", contentTypeValue)
                .body(bodyRequest.getText())
                .when().post(path.getText())
                .then().assertThat().statusCode(Integer.parseInt(statusCode.getText()))
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/schema/postLoginUnsuccsessfulSchema.json")))
                .header("server", serverValue)
                .extract().response().asString();
    }

    @Test (priority = 15)
    public void getDelayedResponse() throws InterruptedException {
        // Open Web
        driver.get(url);

        // Click Method Button
        WebElement methodButton = driver.findElement(By.xpath(methodButtonXPath+"[15]/a"));
        methodButton.click();

        // Get Path
        WebElement path = driver.findElement(By.xpath(pathXPath));
        Thread.sleep(waitTime);

        // Get Status Code
        WebElement statusCode = driver.findElement(By.xpath(statusCodeXPath));

        // API Test & Validate
        given().log().all()
                .header("Content-Type", contentTypeValue)
                .when().get(path.getText())
                .then().assertThat().statusCode(Integer.parseInt(statusCode.getText()))
                .body(JsonSchemaValidator.matchesJsonSchema(
                        new File("src/schema/getDelayedResponseSchema.json")))
                .header("server", serverValue)
                .extract().response().asString();
    }
}