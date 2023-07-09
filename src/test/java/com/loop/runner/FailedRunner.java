package com.loop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-report/cucumber-reports.html",
                "json:target/json-reports/json-report/" ,
                "rerun:target/rerun.txt"},
        features = "@target/rerun.txt",    //copy/path right click from loginfeature
        glue = "com/loop/step_definitions",
        dryRun = false,            //generate snippet
        tags = "@N&E",
        monochrome = true
)

public class FailedRunner {

}
