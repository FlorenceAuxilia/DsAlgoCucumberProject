package com.dsalgo.stepdefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.dsalgo.pom.DSAlgoHomePom;
import com.dsalgo.DriverManager.DriverFactory;
import com.dsalgo.pom.DSAlgoGetStartedPom;
import com.dsalgo.pom.DSAlgoSignInPom;
import com.dsalgo.pom.DSAlgoStackPom;
import com.dsalgo.utility.ConfigReader;
import com.dsalgo.utility.ExcelReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSAlgoStack_SD extends DSAlgoCommon_SD{
	
	WebDriver driver;
	ConfigReader config =new ConfigReader();
	Actions act; 
	@Before("@test")
	public void setUP() throws Throwable
	{
//setup		
		//config.loadProperties();
		//String browser=config.getBrowserType();
		//DriverFactory.launchBrowser(browser);
		//ConfigReader.initElements();
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
	    signinpage_obj.setUserName(config.getUsername());
	    signinpage_obj.setPassword(config.getPassword());
	    signinpage_obj.clickLogin();
	    stakpage_obj=new DSAlgoStackPom(driver);
	   
	}
	
	@Given ("The user is in home page with successful login")
	public void the_user_is_in_home_page_with_sucessful_login()
	{
		if(driver.getTitle().equals("NumpyNinja"))
		{
			Assert.assertTrue(true);
		}
	}
	
//getting started option
	@When("The user clicks the Getting Started button in Stack Panel")
	public void the_user_clicks_the_getting_started_button_in_stack_panel() {
		homepage_obj.click_select_stack();
	}

//dropdown execution	
	@Given("The user clicks Stack option in the dropdown")
	public void the_user_clicks_stack_option_in_the_dropdown() {
		homepage_obj.click_select_stack_options();
	}

//stack page validation
	@Then("The user should be directed to {string} Page")
	public void the_user_should_be_directed_to_page(String title) {
		
		 if(stakpage_obj.gettile_page().equals(title))
		 {
		    	Assert.assertTrue(true);
		 }
		 else
		 {
			 Assert.assertTrue(false);
		 }
	    
	}
//operations in stack page	
	
	@When("The user clicks Operations in stack link")
		public void the_user_clicks_operations_in_stack_link() {
		stakpage_obj.click_Operations_in_stack();
		}
	
	@Then("The user should be directed to operations in stack page {string}")
	public void the_user_should_be_directed_to_operations_in_stack_page(String title1) {
		 Assert.assertEquals(stakpage_obj.getOperations_in_stack_title(),title1);
	}

	@When("The user clicks on Try here button")
	public void the_user_clicks_on_try_here_button() {
		stakpage_obj.click_tryhere();
	    //act.sendKeys("print('Hello')").build().perform();
	}
	
	@Then("The user redirect to tryEditor page")
	public void the_user_redirect_to_try_editor_page() {
		 Assert.assertEquals(stakpage_obj.click_run(),"Run");
	}
//try editor validation---valid
	@When("The user enter valid python code to print in excel sheetname {string} and rownumber {int}")
	public void the_user_enter_valid_python_code_to_print_in_excel_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
	    reader.getData( System.getProperty("user.dir")+"\\src\\test\\resources\\Utlils\\Python.xlsx", sheetName);
		String code = testData.get(rowNumber).get("code");
		act.sendKeys(code).build().perform();
		
	}
	
	
	
	@And("The user clicks run button scenario")
	public void the_user_clicks_run_button_scenario()
	{
		//popup handling		
				try
				   {
					   stakpage_obj.click_run();
					   Thread.sleep(1000);
					   driver.switchTo().alert().accept();
					   Assert.assertTrue(false);	
				   }
				  catch(Exception e)
				   {
					      
				   }
	}
	
	@Then("User is able to see the output sheetname {string} and rownumber {int}")
	public void user_is_able_to_see_the_output_sheetname_and_rownumber(String sheetName, Integer rowNumber)throws InvalidFormatException, IOException {
	    
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testData = 
	    reader.getData( System.getProperty("user.dir")+"\\src\\test\\resources\\Utlils\\Python.xlsx", sheetName);
		String result=testData.get(rowNumber).get("Result");
		Assert.assertEquals(stakpage_obj.text_output(),result);
	}
	
//Implementation 
	
	@When("The user clicks Implementation link")
	public void the_user_clicks_Implementation_link() {
		stakpage_obj.click_implementation();
	}
	
	@Then("The user should be directed to implementation page {string}")
	public void the_user_should_be_directed_to_implementation_page(String title1) {
		 Assert.assertEquals(stakpage_obj.get_implementation_title(),title1);
	}
	
	

//Applications	
	@When("The user clicks Applications link")
	public void the_user_clicks_Applications_link() {
		stakpage_obj.click_applications();
	}
	
	@Then("The user should be directed to Applications page {string}")
	public void the_user_should_be_directed_to_Applications_page(String title1) {
		 Assert.assertEquals(stakpage_obj.get_applications_title(),title1);
	}

//Practice Questions
	@When("The user clicks Practice Questions link")
	public void the_user_clicks_practice_questions_link() {
		stakpage_obj.click_Practice_Questions();
	}
	@Then("The user should redirect to Practice Questions page")
	public void the_user_should_redirect_to_practice_questions_page() {
	
		Assert.assertTrue(false);
		
	}
	//@After("@test")
	//public void teardown()
	//{
		//driver.close();
	   
	//}
}
