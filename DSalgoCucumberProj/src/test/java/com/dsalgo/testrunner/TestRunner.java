package com.dsalgo.testrunner;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.dsalgo.utility.ConfigReader;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
		



		features = { "src/test/resources/feature1"},//location of feature files
			glue={"com.dsalgo.stepdefinition","com.dsalgo.AppHooks"} ,//location of step definition
		plugin= {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)




public class TestRunner extends AbstractTestNGCucumberTests{

	@BeforeTest
	@Parameters( {"browsertype"})
	public void defineBrowser(String browser) throws Throwable {
		ConfigReader configreader = new ConfigReader();
		configreader.setPropertiesforCrossbrowsertesting(browser);

	}

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
