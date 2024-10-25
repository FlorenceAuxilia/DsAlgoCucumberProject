package ds_stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import ds_pom.DsAlgoLoginPage;
import ds_pom.home;
import ds_pom.main;
import ds_pom.DsAlgoLoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DsAlgoLoginSteps extends DsAlgoBaseSteps{
	
	String homepageTitle="NumpyNinja";
	String loginpageTitle="Login";
	String registrationPageTitile="Registration";
	
	@Before("login")
	public void preCondition () {
		driver= new ChromeDriver();
		driver.get("https://dsportalapp.herokuapp.com/");
		driver.manage().window().maximize();
		//lp.loginValidUser("ninja4", "Tiger123@");
	}

	@Given("The user is in login page")
	public void the_user_is_in_login_page() throws InterruptedException  {
		driver=new ChromeDriver();
		driver.navigate().to("https://dsportalapp.herokuapp.com/login");
		lp = new DsAlgoLoginPage(driver);
		//driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		Thread.sleep(2000);
	}
	
	@When("^Enter the (.*) and (.*) as$")
	public void enter_the_username_and_password_as(String username,String password) {
		//lp = new loginPage(driver);

		System.out.println("inside username method");
		lp.enterUsername(username);
		lp.enterPassword(password);
	}




	@When("Click on Login")
	public void click_on_login() {
		lp.Clciklogin();

	}

	@Then("Homepage should be displayed")
	public void homepage_should_be_displayed() {
		lp.verifyPage(homepageTitle);
	
	}


	@Then("Homepage should not be displayed")
	public void homepage_should_not_be_displayed() {
		lp.verifyPage(loginpageTitle);
	
	}
	
	@When("Click register Button")
	public void click_register_button() {
		
		lp.clickRegister();
	}

	@Then("Registartion page should be displayed")
	public void registartion_page_should_not_be_displayed() {
		lp.verifyPage(registrationPageTitile);
	}
	
	@After
	public void postCondition()
	{
		driver.close();
	}
	
//	@Given("User is on signin page url")
//	public void user_is_on_signin_page_url() {
//		
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
//	    mp=new main(driver);
//	    driver.get("https://dsportalapp.herokuapp.com/");
//	    mp.clickGetStarted();
//	    hp=new home(driver);
//	    hp.click_Signin();   
//	    sp=new sign(driver);
//	}
//	
//	@When("User enters valid username {string} into username field")
//	public void user_enters_valid_username_into_username_field(String name) {
//	    sp.setUserName(name);
//	}
//
//	@When("User enters valid password {string} into password field")
//	public void user_enters_valid_password_into_password_field(String pwd) {
//	    sp.setPassword(pwd);
//	}
//	
//	@When("User clicks on Login button")
//	public void user_clicks_on_login_button() {
//		sp.clickLogin();
//	}
//
//	@Then("The user should successfully land in Data Structure Home Page")
//	public void the_user_should_successfully_land_in_data_structure_home_page() {
//		if(driver.getPageSource().contains(hp.LoginMsg()))
//		{
//			
//		    	Assert.assertTrue(true);
//		}
//		else
//	    {
//		    	Assert.assertTrue(false);
//		}
//		driver.quit();
//	}
}
