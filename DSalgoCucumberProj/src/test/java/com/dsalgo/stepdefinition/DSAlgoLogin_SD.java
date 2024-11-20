package com.dsalgo.stepdefinition;



import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.dsalgo.DriverManager.DriverFactory;
import com.dsalgo.pom.DSAlgoGetStartedPom;
import com.dsalgo.pom.DSAlgoHomePom;
import com.dsalgo.pom.DSAlgoLoginPom;
import com.dsalgo.pom.DSAlgoSignInPom;
import com.dsalgo.utility.ConfigReader;
import com.dsalgo.utility.ExcelReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSAlgoLogin_SD extends DSAlgoCommon_SD{

	String homepageTitle="NumpyNinja";
	String loginpageTitle="Login";
	String registrationPageTitile="Registration";
	WebDriver driver;
	ConfigReader config =new ConfigReader();
	String expectedMessage ="Please fill out this field";

	@Before("@login")
	public void preCondition () throws Throwable {
		
		
//		//driver= new ChromeDriver();
//		driver.get("https://dsportalapp.herokuapp.com/");
//		driver.manage().window().maximize();
		//config.loadProperties();
		//String browser=config.getBrowserType();
		//DriverFactory.launchBrowser(browser);
		//ConfigReader.initElements();
		driver=DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	    getstartedpage_obj=new DSAlgoGetStartedPom(DriverFactory.getDriver());
	    driver.get(config.getUrl());
//	    getstartedpage_obj.clickGetStarted();
//	    homepage_obj=new DSAlgoHomePom(driver);
//	    homepage_obj.click_Signin();   
//	    signinpage_obj=new DSAlgoSignInPom(driver);
	}

	//@After("@login")
	//public void postCondition()
	//{
		//driver.close();
	//}


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
	
	
	@When("Enter the Credentials sheetname {string} and rownumber {int}")
	public void enter_the_credentials_sheetname_and_rownumber(String string_sheet, Integer rownum) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
	    reader.getData( System.getProperty("user.dir")+"\\src\\test\\resources\\Utlils\\Python (1).xlsx", string_sheet);
		String username = testData.get(rownum).get("username");
		String password =testData.get(rownum).get("password");
		System.out.println("Username +++++++++"+ username+"passwd+++++++"+password);
		loginpage_obj.enterUsername(username);
		loginpage_obj.enterPassword(password);
	}

	@When("Enter the username")
	public void enter_the_username() {
		loginpage_obj.enterUsername("ninja4");
	}
	
	@When("Enter the password")
	public void enter_the_password() {
		loginpage_obj.enterPassword("Tiger123");
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
	
	
	
	@Then("Error popup should be displayed")
	public void error_popup_should_be_displayed() {
		if(loginpage_obj.checkForErrorpopup().equalsIgnoreCase(expectedMessage))
		{
			Assert.assertTrue(true);
		}
	}





}



