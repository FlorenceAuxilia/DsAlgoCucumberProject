package com.dsalgo.stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.dsalgo.pom.DSAlgoHomePom;
import com.dsalgo.DriverManager.DriverFactory;
import com.dsalgo.pom.DSAlgoGetStartedPom;
import com.dsalgo.pom.DSAlgoSignInPom;
import com.dsalgo.utility.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSAlgoSignIn_SD extends DSAlgoCommon_SD{
	WebDriver driver;
	ConfigReader config =new ConfigReader();
	Actions act; 
	@Given("User is on signin page url")
	public void user_is_on_signin_page_url() throws Throwable {
		
		config.loadProperties();
		String browser=config.getBrowserType();
		DriverFactory.launchBrowser(browser);
		ConfigReader.initElements();
		driver=DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    act=new Actions(driver);
	    getstartedpage_obj=new DSAlgoGetStartedPom(DriverFactory.getDriver());
	    driver.get(config.getUrl());
	    getstartedpage_obj.clickGetStarted();
	    homepage_obj=new DSAlgoHomePom(driver);
	    homepage_obj.click_Signin();   
	    signinpage_obj=new DSAlgoSignInPom(driver);
	}
	
	@When("User enters valid username {string} into username field")
	public void user_enters_valid_username_into_username_field(String name) {
		signinpage_obj.setUserName(name);
	}

	@When("User enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String pwd) {
		signinpage_obj.setPassword(pwd);
	}
	
	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		signinpage_obj.clickLogin();
	}

	@Then("The user should successfully land in Data Structure Home Page")
	public void the_user_should_successfully_land_in_data_structure_home_page() {
		if(driver.getPageSource().contains(homepage_obj.LoginMsg()))
		{
			
		    	Assert.assertTrue(true);
		}
		else
	    {
		    	Assert.assertTrue(false);
		}
		driver.quit();
	}
}
