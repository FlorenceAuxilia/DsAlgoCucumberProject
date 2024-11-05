package com.dsalgo.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.dsalgo.DriverManager.DriverFactory;
import com.dsalgo.pom.DSAlgoGetStartedPom;
import com.dsalgo.pom.DSAlgoHomePom;
import com.dsalgo.pom.DSAlgoQueuePom;
import com.dsalgo.pom.DSAlgoSignInPom;
import com.dsalgo.pom.DSAlgoTreePom;
import com.dsalgo.utility.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class DSAlgoTree_SD extends DSAlgoCommon_SD{
	
	
	WebDriver driver;
	ConfigReader config =new ConfigReader();
	Actions act;
	String treepageTitle="Tree";
	
	@Before ("@tree")
	public void setUP() throws Throwable
	{
		config.loadProperties();
		String browser=config.getBrowserType();
		DriverFactory.launchBrowser(browser);
		ConfigReader.initElements();

		driver=DriverFactory.getDriver();
		//DriverFactory.getDriver().get("https://dsportalapp.herokuapp.com/");
		//driver=new ChromeDriver();
		
	   //driver.manage().window().maximize();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
	    treePage_obj = new DSAlgoTreePom(driver);
	    
	    
	    }
	

@When("The user clicks the Getting Started button in Tree Panel")
public void the_user_clicks_the_getting_started_button_in_tree_panel() {
	homepage_obj.click_select_Tree();
}

@Then("The user should be directed to Tree Page")
public void the_user_should_be_directed_to_tree_page() throws InterruptedException {
	Thread.sleep(2000);
	System.out.println("Ttile is " +driver.getTitle());
	if(driver.getTitle().equals(treepageTitle))
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
}

	@Given ("The user  in home page after successful login")
	public void the_user_is_in_home_page_with_sucessful_login()
	{
		if(driver.getTitle().equals("NumpyNinja"))
		{
			Assert.assertTrue(true);
		}
	}

	
	
	
	
	
	
	
	@Given("The user in the Tree page after logged in")
	public void the_user_in_the_tree_page_after_logged_in() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/tree");
	}

	
	@When("The user clicks {string} Link in treepage")
	public void the_user_clicks_link_in_treepage(String string) {
		treePage_obj.ClickLink(string);
	}
	
	
	@Then("The user to be directed to  {string} page")
	public void the_user_to_be_directed_to_page(String string) {
		if(treePage_obj.getPageTitle().equals(string))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	@When("The user clicks <link name> Link in treepage")
	public void the_user_clicks_link_name_link(String linkname) {
		treePage_obj.ClickLink(linkname);
	}

@Then("The user to be directed to  <link name> page")
public void the_user_should_be_directed_to_link_name_page(String linkname) {
	if(treePage_obj.getPageTitle().equals(linkname))
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
}


@When("The user clicks Tree page Try here button")
public void the_user_clicks_try_here_button( ) {
	treePage_obj.click_tryHere();
}

@Then("The user is redirect to Tree page tryEditor page")
public void the_user_redirect_to_try_editor_page() {
	 Assert.assertEquals(treePage_obj.runButtonText(),"Run");
}


@After ("@tree")
public void teardown()
{
	driver.close();
   
}

}
