package com.dsalgo.stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.dsalgo.pom.DataStructure_IntroductionPom;
import com.dsalgo.pom.DSAlgoHomePom;
import com.dsalgo.pom.DSAlgoGetStartedPom;
import com.dsalgo.pom.DSAlgoSignInPom;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSAlgoDataStructureIntro_SD extends DSAlgoCommon_SD {
Actions act;
	
	@Before("@DataStructure")
	public void setUP()
	{
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    act=new Actions(driver);
	    mp=new DSAlgoGetStartedPom(driver);
	    driver.get("https://dsportalapp.herokuapp.com/");
	    mp.clickGetStarted();
	    hp=new DSAlgoHomePom(driver);
	    hp.click_Signin();   
	    sp=new DSAlgoSignInPom(driver);
	    sp.setUserName("ninja4");
	    sp.setPassword("Tiger123@");
	    sp.clickLogin();
	   ds=new DataStructure_IntroductionPom(driver);
	   
	}
	@Given ("The user is in home page after login")
	public void the_user_is_in_home_page_after_login()
	{
		if(driver.getTitle().equals("NumpyNinja"))
		{
			Assert.assertTrue(true);
		}
	}
	@When("The user clicks the Getting Started button in Data Structures-Introduction panel")
	public void the_user_clicks_the_getting_started_button_in_data_structures_introduction_panel() {
	    hp.click_data_structures_introduction();
	}
	@Then("The user should be directed to data structure {string} Page")
	public void the_user_should_be_directed_to_data_structure_page(String title) {
		
		if( driver.getTitle().equals(title))
		{
			Assert.assertTrue(true);
		}
		else
		{
			 Assert.assertTrue(false);
		}
	    
	}
	
	@When("The user clicks Time Complexity link")
	public void the_user_clicks_time_complexity_link() {
	   ds.click_time_complexity();
	}
	
	@Then("The user should be directed to Time Complexity {string} page")
	public void the_user_should_be_directed_to_time_complexity_page(String string) {
	    if( driver.getTitle().equals(string))
		{
			Assert.assertTrue(true);
		}
		else
		{
			 Assert.assertTrue(false);
		}
	}
	
	@When("The user clicks on time complexity Try here button")
	public void the_user_clicks_on_time_complexity_try_here_button() {
	   
	    ds.tc_click_tryhere();
	}
	
	@Then("The user redirect to time complexity tryEditor page")
	public void the_user_redirect_to_time_complexity_try_editor_page() {
		 Assert.assertEquals(ds.time_complexity_click_run(), "Run");
	}
	
	@When("The user enter a python code to print {string}")
	public void the_user_enter_a_python_code_to_print(String string) {
		
		act.sendKeys("print('"+ string +"')").build().perform();
	}

	@When("The user clicks on run button valid scenario")
	public void the_user_clicks_on_run_button_valid_scenario() {
		ds.time_complexity_click_run();
	}
//output
	
	
	@Then("User is able to see output in console {string}")
	public void user_is_able_to_see_output_in_console(String string) {
		Assert.assertEquals(ds.tc_text_output(),string);
	}
	
	@When("The user enter a Invalid python code to print {string}")
	public void the_user_enter_a_invalid_python_code_to_print(String string) {
		act.sendKeys(string).build().perform();
	}

	@Then("popup Window handle")
	public void popup_window_handle() {
		try
		   {
			   ds.time_complexity_click_run();
			   Thread.sleep(1000);
			   driver.switchTo().alert().accept();
			   Assert.assertTrue(false);	
		   }
		  catch(Exception e)
		   {
			      
		   }
	}
	
	
	@After("@DataStructure")
	public void tearDown() {
	    driver.close();
	}
}
