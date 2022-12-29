package appiumChallenge;
import appiumChallenge.appiumTest;
import io.cucumber.java.*;

import java.net.MalformedURLException;

public class CucumberHooks {

    @Before
    public static void beforeAll() throws MalformedURLException {
//        System.out.println("BEFORE ALL...");
        appiumTest.setupDriver();
    }

    @After
    public static void afterAll(){
//        System.out.println("AFTER ALL...");
        appiumTest.tearDown();
    }

//    @After
//    public static void after(){
//
//    }


}
