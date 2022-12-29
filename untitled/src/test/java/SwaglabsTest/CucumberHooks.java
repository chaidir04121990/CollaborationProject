package SwaglabsTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

import java.net.MalformedURLException;

public class CucumberHooks {

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        System.out.println("print before all");
        BaseTest.setUpDriver();
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("print after all");
        BaseTest.stopDriver();
    }

//    @After
//    public static void after(){
//        BaseTest.resetApp();
//    }

}
