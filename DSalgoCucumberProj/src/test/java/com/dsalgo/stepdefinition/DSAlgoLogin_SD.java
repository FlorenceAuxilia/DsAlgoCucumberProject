package com.dsalgo.stepdefinition;



import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.dsalgo.pom.DSAlgoLoginPom;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSAlgoLogin_SD extends DSAlgoCommon_SD{

	String homepageTitle="NumpyNinja";
	String loginpageTitle="Login";
	String registrationPageTitile="Registration";


	@Before("@login")
	public void preCondition () {
		driver= new ChromeDriver();
		driver.get("https://dsportalapp.herokuapp.com/");
		driver.manage().window().maximize();

	}

	@After("@login")
	public void postCondition()
	{
		driver.close();
	}


	@Given("The user is in login page")
	public void the_user_is_in_login_page() throws InterruptedException  {
		driver.navigate().to("https://dsportalapp.herokuapp.com/login");
		loginpage_obj = new DSAlgoLoginPom(driver);
		//driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		Thread.sleep(2000);
	}

	@When("^Enter the (.*) and (.*) as$")
	public void enter_the_username_and_password_as(String username,String password) {
		//lp = new loginPage(driver);

		System.out.println("inside username method");
		loginpage_obj.enterUsername(username);
		loginpage_obj.enterPassword(password);
	}




	@When("Click on Login")
	public void click_on_login() {
		loginpage_obj.Clciklogin();

	}

	@Then("Homepage should be displayed")
	public void homepage_should_be_displayed() {
		//	loginpage_obj.verifyPage(homepageTitle);
		if(loginpage_obj.getPageTitle().equals(homepageTitle))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}

	}


	@Then("Homepage should not be displayed")
	public void homepage_should_not_be_displayed() {

		if(loginpage_obj.getPageTitle().equals(loginpageTitle))
		{
			Assert.assertFalse(true);
		}
		else
		{
			Assert.assertFalse(false);
		}

	}

	@When("Click register Button")
	public void click_register_button() {

		loginpage_obj.clickRegister();
	}

	@Then("Registartion page should be displayed")
	public void registartion_page_should_not_be_displayed() {
		//loginpage_obj.verifyPage(registrationPageTitile);

		if(loginpage_obj.getPageTitle().equals(registrationPageTitile))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}


	@Then("Error Message should be displayed")
	public void error_message_should_be_displayed() {
		if(loginpage_obj.checkForErrorMessage())
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}





}



