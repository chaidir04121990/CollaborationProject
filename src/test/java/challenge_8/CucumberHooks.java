package challenge_8;

import java.net.MalformedURLException;

import io.cucumber.java.*;

public class CucumberHooks {
     @BeforeAll
     public static void beforeAll() throws MalformedURLException {
          System.out.println("before all");
     BaseTest.setup();
     }

     @After
     public static void afterAll() {
          System.out.println("after all");
     BaseTest.teardown();
     }

//     @After
//     public static void after() {
//     BaseTest.reset();
//     }
}
