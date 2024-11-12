package com.dsalgo.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.dsalgo.DriverManager.DriverFactory;
import com.dsalgo.pom.DSAlgoArraypom;
import com.dsalgo.pom.DSAlgoGetStartedPom;
import com.dsalgo.pom.DSAlgoHomePom;
import com.dsalgo.pom.DSAlgoLoginPom;
import com.dsalgo.pom.DSAlgoRegisterPom;
import com.dsalgo.pom.DSAlgoSignInPom;
import com.dsalgo.utility.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSAlgoRegister_SD extends DSAlgoCommon_SD {
	String homepageTitle = "NumpyNinja";
	String loginTitle = "Login";
	String displayExpectedMessage = "Please fill out this field";
	WebDriver driver;
	ConfigReader config = new ConfigReader();
	Actions act;

	public DSAlgoRegisterPom dataSet(String username, String password, String confirmPassword) {
		registerpage_obj.enterUsername(username);
		registerpage_obj.enterPassword(password);
		registerpage_obj.confirmPassword(confirmPassword);

		return registerpage_obj;
	}

	@Before("@registration_successful")
	public void setUP() throws Throwable {
		//config.loadProperties();
		//String browser = config.getBrowserType();
		//DriverFactory.launchBrowser(browser);
		//ConfigReader.initElements();
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		act = new Actions(driver);
		getstartedpage_obj = new DSAlgoGetStartedPom(DriverFactory.getDriver());
		driver.get(config.getUrl());
		getstartedpage_obj.clickGetStarted();
		homepage_obj = new DSAlgoHomePom(driver);
		homepage_obj.click_Signin();
		signinpage_obj = new DSAlgoSignInPom(driver);
		signinpage_obj.setUserName(config.getUsername());
		signinpage_obj.setPassword(config.getPassword());
		signinpage_obj.clickLogin();
		registerpage_obj = new DSAlgoRegisterPom(driver);

	}

	@Before
	public void preCondition() {
		driver = new ChromeDriver();
		driver.get("https://dsportalapp.herokuapp.com/");
		driver.manage().window().maximize();
		getstartedpage_obj = new DSAlgoGetStartedPom(driver);
		getstartedpage_obj.clickGetStarted();
		homepage_obj = new DSAlgoHomePom(driver);
		homepage_obj.click_Signin();
		signinpage_obj = new DSAlgoSignInPom(driver);
		registerpage_obj = new DSAlgoRegisterPom(driver);
	}


	@Given("The user is on the new user registration page")
	public void the_user_is_on_the_new_user_registration_page() throws InterruptedException {
		driver.navigate().to("https://dsportalapp.herokuapp.com/register");
		registerpage_obj = new DSAlgoRegisterPom(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}


@When("The user clicks Register button after entering  with valid {string} and {string} and {string} in related textbox")
public void the_user_clicks_register_button_after_entering_with_valid_and_and_in_related_textbox(String username,
		String password, String confirmPassword) {
    // Write code here that turns the phrase above into concrete actions
	registerpage_obj = dataSet(username, password, confirmPassword);
	registerpage_obj.clickRegister();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
	

	@Then("The user should be redirected to Home Page of DS Algo with new use account")
	public void the_user_should_be_redirected_to_home_page_of_ds_algo_with_new_use_account() {
		if (registerpage_obj.getPageTitle().equals(homepageTitle)) {
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}

	}
	
	/*
	@When("User clicked register button with trying to enter more than difined limit characters  in sprintssnkanxklajwdoqwijsoiwswqdkqwdqdkdqdwqqwqwdqwqwdwqdqwdkwqhdqdqdwqdqwdwqdsprintssnkanxklajwdoqwijsoiwswqdkqwdqdkdqdwqqwqwdqwqwdwqdqwdkwqhdqdqdwqd")
	public void user_clicked_register_button_with_trying_to_enter_more_than_difined_limit_characters_in_sprintssnkanxklajwdoqwijsoiwswqdkqwdqdkdqdwqqwqwdqwqwdwqdqwdkwqhdqdqdwqdqwdwqdsprintssnkanxklajwdoqwijsoiwswqdkqwdqdkdqdwqqwqwdqwqwdwqdqwdkwqhdqdqdwqd(String username) {
	    // Write code here that turns the phrase above into concrete actions
		registerpage_obj = dataSet(username, "", "");
		registerpage_obj.clickRegister();
		registerpage_obj.checkLimitForUsername();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	} */
	
	@When("User clicked register button with trying to enter more than difined limit characters  in {string}")
	public void user_clicked_register_button_with_trying_to_enter_more_than_difined_limit_characters_in(String username) {
	    // Write code here that turns the phrase above into concrete actions
		registerpage_obj = dataSet(username, "", "");
		registerpage_obj.clickRegister();
		registerpage_obj.checkLimitForUsername();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("user not able to see Error message after the character limit reached in username_field")
	public void user_not_able_to_see_error_message_after_the_character_limit_reached_in_username_field() {
		if (registerpage_obj.getPageTitle().equals(homepageTitle)) {
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}
	}


	@When("User clicked register button")
	public void user_clicked_register_button() {
		registerpage_obj.registerClick();

	}

	@Then("Error popup should display")
	public void error_popup_should_display() {
		if (registerpage_obj.checkErrorpopup().equalsIgnoreCase(displayExpectedMessage)) {
			Assert.assertTrue(true);
		}
	}

	@When("User clicks Register button with invalid spacechar in {string} and valid {string} and {string}")
	public void user_clicks_register_button_with_invalid_spacechar_in_and_valid_and(String username, String password,
			String confirmPassword) throws InterruptedException {
		registerpage_obj = dataSet(username, password, confirmPassword);
		registerpage_obj.clickRegister();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("The user is not able to see error msg after entering invalid data and user redirected to empty password textbox")
	public void the_user_is_not_able_to_see_error_msg_after_entering_invalid_data_and_user_redirected_to_empty_password_textbox() {
		registerpage_obj.chkError();
	}

	@When("The user clicks Register button after entering valid {string} and numeric {string} and {string}")
	public void the_user_clicks_register_button_after_entering_valid_and_numeric_and(String username, String password,
			String confirmPassword) throws InterruptedException {
		registerpage_obj = dataSet(username, password, confirmPassword);
		registerpage_obj.clickRegister();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("User can see warning message")
	public void user_can_see_warning_message() {
		registerpage_obj.warningMsgWithNumericPassword();
	}

	@When("The user clicks Register button after entering a valid {string} and less than Eight characters {string} and {string}")
	public void the_user_clicks_register_button_after_entering_a_valid_and_less_than_eight_characters_and(
			String username, String password, String confirmPassword) throws InterruptedException {
		registerpage_obj = dataSet(username, password, confirmPassword);
		registerpage_obj.clickRegister();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Then("User can see warning message1")
	public void user_can_see_warning_message1() {
		registerpage_obj.warningMsgWithInvalidPassword();
	}

	@When("The user clicks Register button after entering valid {string} and different passwords in {string} and {string}")
	public void the_user_clicks_register_button_after_entering_valid_and_different_passwords_in_and(String username,
			String password, String confirmPassword) {
		registerpage_obj = dataSet(username, password, confirmPassword);
		registerpage_obj.clickRegister();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	

	@Then("The user should able to see an password warning message")
	public void the_user_should_able_to_see_an_password_warning_message() {
		registerpage_obj.warningMassege();
	}

	@Given("The user is on registration page")
	public void the_user_is_on_registration_page() throws InterruptedException {
		driver.navigate().to("https://dsportalapp.herokuapp.com/register");
		registerpage_obj = new DSAlgoRegisterPom(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@When("Click login")
	public void click_login() {
		registerpage_obj.clickLogin();
	}

	@Then("login page should be displayed")
	public void login_page_should_be_displayed() {
		if (registerpage_obj.getPageTitle().equals(loginTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@When("User try to enter invalid value in {string} and  {string} and {string}")
	public void user_try_to_enter_invalid_value_in_and_and(String username, String password, String confirmPassword) {
		registerpage_obj = dataSet(username, password, confirmPassword);
		registerpage_obj.clickRegister();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Then("user is not getting Error message after inputing invalid value in respective field")
	public void user_is_not_getting_error_message_after_inputing_invalid_value_in_respective_field() {
		if (registerpage_obj.getPageTitle().equals(" Registration ")) {
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}
	}

	//@After
	//public void postCondition() {
		//driver.close();
	//}

}
