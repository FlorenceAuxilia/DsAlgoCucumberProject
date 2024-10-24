package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = { "src/test/resources/feature1/stack.feature"},//location of feature files
		glue={"ds_stepdefinition"} ,//location of step definition
		plugin= {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
		)


public class test {

}
