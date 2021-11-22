package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "D://WORK//SeleniumCucumber//Feature/" ,
        tags = "@Sanity",
        glue = "stepDefinition",
        dryRun = false,
        monochrome = true,
        plugin ={"pretty", "html:test-output.html"}
        )



public class TestRunner
{



}
