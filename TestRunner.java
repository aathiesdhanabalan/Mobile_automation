package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/athies/Downloads/Mobile_Testing_Cucumber/src/test/resources/MobileCategory.feature",
        glue = {"StepDefinitions"}, plugin = {"pretty"} , monochrome = true
)


public class TestRunner {
}
