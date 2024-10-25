package com.dsalgo.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import com.dsalgo.pom.DSAlgoHomePom;
import com.dsalgo.pom.DSAlgoGetStartedPom;
import com.dsalgo.pom.DSAlgoSignInPom;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSAlgoSignIn_SD extends DSAlgoCommon_SD{

	@Given("User is on signin page url")
	public void user_is_on_signin_page_url() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	    mp=new DSAlgoGetStartedPom(driver);
	    driver.get("https://dsportalapp.herokuapp.com/");
	    mp.clickGetStarted();
	    hp=new DSAlgoHomePom(driver);
	    hp.click_Signin();   
	    sp=new DSAlgoSignInPom(driver);
	}
	
	@When("User enters valid username {string} into username field")
	public void user_enters_valid_username_into_username_field(String name) {
	    sp.setUserName(name);
	}

	@When("User enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String pwd) {
	    sp.setPassword(pwd);
	}
	
	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		sp.clickLogin();
	}

	@Then("The user should successfully land in Data Structure Home Page")
	public void the_user_should_successfully_land_in_data_structure_home_page() {
		if(driver.getPageSource().contains(hp.LoginMsg()))
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
