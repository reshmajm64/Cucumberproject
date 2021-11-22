package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
            features = "D://WORK//SeleniumCucumber//Feature/" ,
            tags = "@Sanity",
            glue = "stepDefinition",
            dryRun = false,
            monochrome = true,
            plugin ={"pretty", "html:test-output.html"})


public class TestRunnerTestNG extends AbstractTestNGCucumberTests {



    }
