package com.dsalgo.stepdefinition;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.dsalgo.DriverManager.DriverFactory;
import com.dsalgo.pom.DSAlgoGetStartedPom;
import com.dsalgo.pom.DSAlgoGraphPom;
import com.dsalgo.pom.DSAlgoHomePom;
import com.dsalgo.pom.DSAlgoQueuePom;
import com.dsalgo.pom.DSAlgoSignInPom;
import com.dsalgo.pom.DSAlgoTreePom;
import com.dsalgo.utility.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

public class DSAlgoGraph_SD extends DSAlgoCommon_SD{

WebDriver driver;
ConfigReader config =new ConfigReader();
Actions act;
String graphpageTitle="Graph";
String pracQuesTitle="Practice Questions";

@Before ("@graph")
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
    homepage_obj=new DSAlgoHomePom(DriverFactory.getDriver());
    homepage_obj.click_Signin();   
    signinpage_obj=new DSAlgoSignInPom(driver);
    signinpage_obj.setUserName(config.getUsername());
    signinpage_obj.setPassword(config.getPassword());
    signinpage_obj.clickLogin();
     queuepage_obj = new DSAlgoQueuePom(driver);
    graphPage_obj =new DSAlgoGraphPom(DriverFactory.getDriver());
    
    }

@Given ("GP The user is in home page after successful login")
public void the_user_is_in_home_page_with_sucessful_login()
{
	if(driver.getTitle().equals("NumpyNinja"))
	{
		Assert.assertTrue(true);
	}
}

@When("The user clicks the Getting Started button in Graph Panel")
public void the_user_clicks_the_getting_started_button_in_Graph_panel() {
	 	
	homepage_obj.click_select_Graph();;
}
@Then("The user should be directed to Graph Page")
public void the_user_should_be_directed_to_Graph_page() {
	 
	
	if(driver.getTitle().equals("graphpageTitle"))
	{
		Assert.assertTrue(true);
	}
}

@When("The user is in the Graph page after logged in")
public void the_user_is_in_the_Graph_page_after_logged_in() {
	
	DriverFactory.getDriver().navigate().to("https://dsportalapp.herokuapp.com/graph");

}

@When("The user click {string} Link")
public void the_user_clicks_implementation_of_queue_in_python_link(String string) {
	//DsAlgoQueuePage = new DsAlgoQueuePage(driver);
	graphPage_obj.ClickGraphLink(string);
}
@Then("The user should be directed to gp {string} page")
public void the_user_should_be_directed_to_gp_page(String string) {
	if(graphPage_obj.getPageTitle().equals(string))
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
}


@Then("The GP Practice question page should be displayed")
public void the_practice_question_page_should_be_displayed() {
	
	if(driver.getTitle().equals("pracQuesTitle"))
	{
		Assert.assertTrue(true);
	}
	
}


@When("The user clicks  Graph page Try here button")
public void the_user_clicks_graph_page_try_here_button() {
	graphPage_obj.click_tryHere();
}

@Then("The user is redirect to  Graph tryEditor page")
public void the_user_is_redirect_to_graph_try_editor_page() {
	 Assert.assertEquals(graphPage_obj.runButtonText(),"Run");
}

@When("The GPuser enter valid python code print {string}")
public void the_user_enter_valid_python_code_print(String string) {
	act.sendKeys("print('"+ string +"')").build().perform();
}

@When("The GPuser enter invalid python code {string}")
public void the_user_enter_invalid_python_code(String string) {
	act.sendKeys(string).build().perform();
}

@When("The GPuser clicks run button valid scenario")
public void the_user_clicks_run_button_valid_scenario() {
	//popup handling		
	try
	   {
		graphPage_obj.click_run();
		   Thread.sleep(1000);
		   driver.switchTo().alert().accept();
		   Assert.assertTrue(false);	
	   }
	  catch(Exception e)
	   {
		      
	   }
}

@Then("GPUser is able to see the output in console {string}")
public void user_is_able_to_see_the_output_in_console(String string) {
	Assert.assertEquals(queuepage_obj.text_output(),string);
}


@And("The GPuser clicks run button and sees an alert")
public void the_user_clicks_run_button_invlid_scenario() {
	//popup handling		
	try
	   {
		graphPage_obj.click_run();
		   Thread.sleep(1000);
		   driver.switchTo().alert().accept();
		   Assert.assertTrue(true);	
	   }
	  catch(Exception e)
	   {
		      
	   }
}

@After ("@graph")
public void teardown()
{
	driver.close();
   
}

}

