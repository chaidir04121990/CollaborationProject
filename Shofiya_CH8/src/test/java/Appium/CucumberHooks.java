package Appium;

import io.cucumber.java.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.net.MalformedURLException;

public class CucumberHooks {
    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        BaseTest.setup();
    }

    @AfterAll
    public static void afterAll(){
        BaseTest.tearDown();
    }

//    @After
//    public  static void after(){
//        BaseTest.resetApp();
//    }
}
