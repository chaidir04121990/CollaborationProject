package CH8;

import io.cucumber.java.*;

import java.net.MalformedURLException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class CucumberHooks {

    @BeforeAll
    public static void beforeAll() throws MalformedURLException {
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
