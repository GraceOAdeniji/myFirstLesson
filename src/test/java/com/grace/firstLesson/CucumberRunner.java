package com.grace.firstLesson;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.grace.firstLesson",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
@RunWith(Cucumber.class)
public class CucumberRunner {
}
