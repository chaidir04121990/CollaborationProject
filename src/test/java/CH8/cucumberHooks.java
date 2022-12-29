package CH8;

import io.cucumber.java.*;
import java.net.MalformedURLException;

public class cucumberHooks {

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
        baseTest.setupDriver();
    }

    @AfterAll
    public static void afterAll() {
        baseTest.stopDriver();
    }

    @After
    public static void after() {
        baseTest.resetApp();
    }

}
