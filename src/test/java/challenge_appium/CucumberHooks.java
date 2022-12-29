package challenge_appium;

import io.cucumber.java.*;

public class CucumberHooks {

    @BeforeAll
    public static void beforeAll() {
        BaseTest.setupDriver();
    }

    @AfterAll
    public static void afterAll() {
        BaseTest.stopDriver();
    }

    @After
    public static void after() {
        BaseTest.resetApp();
    }

}
