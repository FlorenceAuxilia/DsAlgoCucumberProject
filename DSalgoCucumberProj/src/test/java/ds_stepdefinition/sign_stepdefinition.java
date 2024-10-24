package ds_stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import ds_pom.home;
import ds_pom.main;
import ds_pom.sign;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sign_stepdefinition extends common_definition{

	@Given("User is on signin page url")
	public void user_is_on_signin_page_url() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	    mp=new main(driver);
	    driver.get("https://dsportalapp.herokuapp.com/");
	    mp.clickGetStarted();
	    hp=new home(driver);
	    hp.click_Signin();   
	    sp=new sign(driver);
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
