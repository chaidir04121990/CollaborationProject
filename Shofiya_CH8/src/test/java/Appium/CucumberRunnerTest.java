package Appium;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"Appium"},
        plugin = {
                "pretty",
                "html:target/report-cucumber.html",
                "json: target/cucumber-json.json"
        }
)

public class CucumberRunnerTest extends AbstractTestNGCucumberTests{
}
