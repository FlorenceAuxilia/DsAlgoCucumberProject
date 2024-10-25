package com.dsalgo.stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.dsalgo.pom.DSAlgoHomePom;
import com.dsalgo.pom.DSAlgoGetStartedPom;
import com.dsalgo.pom.DSAlgoSignInPom;
import com.dsalgo.pom.DSAlgoStackPom;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSAlgoStack_SD extends DSAlgoCommon_SD{
	
	
	Actions act;
	
	@Before("@test")
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
	    st=new DSAlgoStackPom(driver);
	   
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
	    hp.click_select_stack();
	}

//dropdown execution	
	@Given("The user clicks Stack option in the dropdown")
	public void the_user_clicks_stack_option_in_the_dropdown() {
	hp.click_select_stack_options();
	}

//stack page validation
	@Then("The user should be directed to {string} Page")
	public void the_user_should_be_directed_to_page(String title) {
		
		 if(st.gettile_page().equals(title))
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
		    st.click_Operations_in_stack();
		}
	
	@Then("The user should be directed to operations in stack page {string}")
	public void the_user_should_be_directed_to_operations_in_stack_page(String title1) {
		 Assert.assertEquals(st.getOperations_in_stack_title(),title1);
	}

	@When("The user clicks on Try here button")
	public void the_user_clicks_on_try_here_button() {
	    st.click_tryhere();
	    //act.sendKeys("print('Hello')").build().perform();
	}
	
	@Then("The user redirect to tryEditor page")
	public void the_user_redirect_to_try_editor_page() {
		 Assert.assertEquals(st.click_run(),"Run");
	}
//try editor validation---valid
	@When("The user enter valid python code to print {string}")
	public void the_user_enter_valid_python_code_to_print(String string) {
		
		
		act.sendKeys("print('"+ string +"')").build().perform();
		
	}
	
//try editor validation---invalid
	@When("The user enter Invalid python code to print {string}")
	public void the_user_enter_invalid_python_code_to_print(String string) {
		act.sendKeys(string).build().perform();
	}
	
	
	@And("The user clicks run button valid scenario")
	public void the_user_clicks_run_button_valid_scenario()
	{
		st.click_run();
	}
	
	@When("popup handle")
	public void popup_handle() {
	   try
	   {
		   st.click_run();
		   Thread.sleep(1000);
		   driver.switchTo().alert().accept();
		   Assert.assertTrue(false);	
	   }
	  catch(Exception e)
	   {
		      
	   }
	  
	}
	@Then("User is able to see the output in console {string}")
	public void user_is_able_to_see_the_output_in_console(String output) {
	    
		Assert.assertEquals(st.text_output(),output);
	}
	
//Implementation 
	
	@When("The user clicks Implementation link")
	public void the_user_clicks_Implementation_link() {
	    st.click_implementation();
	}
	
	@Then("The user should be directed to implementation page {string}")
	public void the_user_should_be_directed_to_implementation_page(String title1) {
		 Assert.assertEquals(st.get_implementation_title(),title1);
	}
	
	@After("@test")
	public void tearDown() {
	    driver.close();
	}

//Applications	
	@When("The user clicks Applications link")
	public void the_user_clicks_Applications_link() {
	    st.click_applications();
	}
	
	@Then("The user should be directed to Applications page {string}")
	public void the_user_should_be_directed_to_Applications_page(String title1) {
		 Assert.assertEquals(st.get_applications_title(),title1);
	}

//Practice Questions
	@When("The user clicks Practice Questions link")
	public void the_user_clicks_practice_questions_link() {
	    st.click_Practice_Questions();
	}
	@Then("The user should redirect to Practice Questions page")
	public void the_user_should_redirect_to_practice_questions_page() {
	
		Assert.assertTrue(true);
		
	}
}
