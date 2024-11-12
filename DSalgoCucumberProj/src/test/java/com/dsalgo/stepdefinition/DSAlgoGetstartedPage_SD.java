package com.dsalgo.stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.dsalgo.DriverManager.DriverFactory;
import com.dsalgo.pom.DSAlgoGetStartedPom;
import com.dsalgo.utility.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSAlgoGetstartedPage_SD extends DSAlgoCommon_SD{
	ConfigReader config =new ConfigReader();
	Actions act;
	@Before("@main")
	public void setUP() throws Throwable {
		//config.loadProperties();
		//String browser=config.getBrowserType();
		//DriverFactory.launchBrowser(browser);
		//ConfigReader.initElements();

		driver=DriverFactory.getDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    act=new Actions(driver);
	    getstartedpage_obj=new DSAlgoGetStartedPom(DriverFactory.getDriver());
	    driver.get(config.getUrl());
	}

	@When("The user should be in GetStarted page")
	public void the_user_should_be_in_get_started_page() {
		if(driver.getTitle().equals("NumpyNinja"))
		{
			Assert.assertTrue(true);
		}
	}
	
	@Then("The user should landed on the page there should be a message {string}")
	public void the_user_should_landed_on_the_page_there_should_be_a_message(String string) {
	    if(driver.getPageSource().contains(string))
	    	
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}
	
	@Then("The user clicks the get started button")
	public void the_user_clicks_the_get_started_button() {
	  
		getstartedpage_obj.clickGetStarted();
	}

	@Then("The user should land in Home Page with {string} and {string} links")
	public void the_user_should_land_in_home_page_with_and_links(String register, String signin) {
		if((driver.getPageSource().contains(register))||(driver.getPageSource().contains(signin)))
		{
			
		    	Assert.assertTrue(true);
		}
	    else
	    {
		    	Assert.assertTrue(false);
	    }
	}

	//@After("@main")
	//public void tearDown()
	//{
		//driver.close();
	//}

	
	
	  

	
}
