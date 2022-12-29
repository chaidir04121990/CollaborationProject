package belajar;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {
                "pretty",
                "html: cucumber-html-reports",
                "json: cucumber-json.json" },
        glue = {"belajar"}
)

public class cucumberRunner extends AbstractTestNGCucumberTests {
}
