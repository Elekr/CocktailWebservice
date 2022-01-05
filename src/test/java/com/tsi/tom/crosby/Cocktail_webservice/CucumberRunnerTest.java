package com.tsi.tom.crosby.Cocktail_webservice;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
                features = "src/test/resources/cucumber/AccessDatabase.feature",
                glue = {"com.tsi.tom.crosby.Cocktail_webservice"})
public class CucumberRunnerTest {


}