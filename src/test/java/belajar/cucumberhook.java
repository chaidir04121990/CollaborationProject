package belajar;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

public class cucumberhook {
    @Before
    public void beforeAll() throws MalformedURLException {
        Base.setup();
    }

    @After
    public void afterAll() {
        Base.stopDriver();
    }

}
