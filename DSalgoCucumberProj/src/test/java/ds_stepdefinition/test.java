package ds_stepdefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import ds_pom.DataStructure_Introduction;
import ds_pom.home;
import ds_pom.main;
import ds_pom.DsAlgoLoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class test extends DsAlgoBaseSteps {
	Actions act;	
	
//	@Before("@Data")
//	public void setUP()
//	{
//		driver=new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	    act=new Actions(driver);
//	    mp=new main(driver);
//	    driver.get("https://dsportalapp.herokuapp.com/");
//	    mp.clickGetStarted();
//	    hp=new home(driver);
//	    hp.click_Signin();   
//	    sp=new DsAlgoLoginPage(driver);
//	    sp.setUserName("ninja4");
//	    sp.setPassword("Tiger123@");
//	    sp.clickLogin();
//	   ds=new DataStructure_Introduction(driver);
//	   
//	}
	
	@When("The user clicks  Data Structures-Introduction panel")
	public void the_user_clicks_the_getting_started_button_in_data_structures_introduction_panel() {
	    hp.click_data_structures_introduction();
	}
	
	@When( "clicks Time Complexity link")
	public void clicks_time_complexity_link() {
	   ds.click_time_complexity();
	}
	@When("clicks on time complexity Try here button")
	public void clicks_on_time_complexity_try_here_button() {
	   
	    ds.tc_click_tryhere();
	}
	
	@When("enter a python code to print {string}")
	public void enter_a_python_code_to_print(String string) {
		
		act.sendKeys("print('"+ string +"')").build().perform();
	}
	
	@When("clicks on run button valid scenario")
	public void clicks_on_run_button_valid_scenario() {
		ds.time_complexity_click_run();
	}

	@Then("output in console {string}")
	public void output_in_console(String string) {
		Assert.assertEquals(ds.tc_text_output(),string);
	}
	
	@After("@Data")
	public void tearDown() {
	    driver.close();
	}
}
