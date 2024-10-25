package ds_stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import ds_pom.DsAlgoLoginPage;
import ds_pom.DsAlgoQueuePage;
import ds_pom.home;
import ds_pom.main;
import ds_pom.stack;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DsAlgoQueueSteps extends DsAlgoBaseSteps{
	
	Actions act;
	
	@Before
	public void setUP()
	{
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    act=new Actions(driver);
	    driver.get("https://dsportalapp.herokuapp.com/login");
	    lp=new DsAlgoLoginPage(driver);
	    //lp.loginValidUser("ninja4","Tiger123@");
	    lp.enterUsername("ninja4");
		lp.enterPassword("Tiger123@");
		lp.Clciklogin();
	   // sp.setPassword();
	    //sp.clickLogin();
	    
	   
	}
	
	String queuepageTitle="Queue";
	
	
	@Given("The user is in the home page after logged in")
	public void the_user_is_in_the_home_page_after_logged_in() {
		//driver=new ChromeDriver();
		driver.navigate().to("https://dsportalapp.herokuapp.com/home");
	}

	@When("The user clicks the Getting Started button in Queue Panel")
	public void the_user_clicks_the_getting_started_button_in_queue_panel() {
		hp = new home(driver);
		hp.click_select_Queue();
	}
	@Then("The user should be directed to Queue Page")
	public void the_user_should_be_directed_to_queue_page() {
		DsAlgoQueuePage = new DsAlgoQueuePage(driver);
		DsAlgoQueuePage.verifyQPage(queuepageTitle);
	}
	
	
	@Given("The user is in the Queue page after logged in")
	public void the_user_is_in_the_queue_page_after_logged_in() {
		//driver=new ChromeDriver();
		driver.navigate().to("https://dsportalapp.herokuapp.com/queue");

	}
	@When("The user clicks {string} Link")
	public void the_user_clicks_implementation_of_queue_in_python_link(String string) {
		DsAlgoQueuePage = new DsAlgoQueuePage(driver);
		DsAlgoQueuePage.ClickQueueLink(string);
	}
	@Then("The user should be directed to  {string} page")
	public void the_user_should_be_directed_to_page(String string) {
		DsAlgoQueuePage.verifyQPage(string);
	}


	@Then("The user is redirect to tryEditor page")
	public void the_user_redirect_to_try_editor_page() {
		 Assert.assertEquals(DsAlgoQueuePage.runButtonText(),"Run");
	}



	@When("The user clicks  Try here button")
	public void the_user_clicks_try_here_button() {
		DsAlgoQueuePage.click_tryHere();
	}

//	@When("The user enter valid python code to print {string}")
//	public void the_user_enter_valid_python_code_to_print(String string) {
//		
//		act.sendKeys("print('"+ string +"')").build().perform();
//		
//	}


	

}
