package com.dsalgo.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = { "src/test/resources/feature1/DSAlgoStack.feature"},//location of feature files
		glue={"com.dsalgo.stepdefinition","com.dsalgo.AppHooks"} ,//location of step definition
		plugin= {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)


public class TestRunner {
}
