package com.dsalgo.stepdefinition;

import java.time.Duration;
import java.util.LinkedList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.dsalgo.DriverManager.DriverFactory;
import com.dsalgo.pom.DSAlgoGetStartedPom;
import com.dsalgo.pom.DSAlgoHomePom;
import com.dsalgo.pom.DSAlgoLinkedListPom;
import com.dsalgo.pom.DSAlgoSignInPom;
import com.dsalgo.pom.DSAlgoStackPom;
import com.dsalgo.utility.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSAlgoLinkedList_SD extends DSAlgoCommon_SD {

	Actions act;
	WebDriver driver;
	ConfigReader config = new ConfigReader();
	String linkedlistpageTitle = "Linked List";
	String pracQuesTitle = "Practice Questions";

	@Before("@linkedList")
	public void setUP() throws Throwable {
		config.loadProperties();
		driver = DriverFactory.getDriver();

		String browser = config.getBrowserType();
		DriverFactory.launchBrowser(browser);
		ConfigReader.initElements();
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		act = new Actions(driver);
		getstartedpage_obj = new DSAlgoGetStartedPom(DriverFactory.getDriver());
		driver.get(config.getUrl());
		getstartedpage_obj.clickGetStarted();
		homepage_obj = new DSAlgoHomePom(DriverFactory.getDriver());
		homepage_obj.click_Signin();
		signinpage_obj = new DSAlgoSignInPom(driver);
		signinpage_obj.setUserName(config.getUsername());
		signinpage_obj.setPassword(config.getPassword());
		signinpage_obj.clickLogin();
		linkedlist_obj = new DSAlgoLinkedListPom(DriverFactory.getDriver());

	}

	@When("The user clicks the geting started button in Linked List panel")
	public void the_user_clicks_the_getting_started_button_in_linked_list_panel() {
		homepage_obj.click_select_Linked_List();

	}

	@Then("The user should be directed to Linked List page")
	public void the_user_should_be_directed_to_Linked_List_page() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Title is" + driver.getTitle());
		if (driver.getTitle().equals(linkedlistpageTitle)) {
			Assert.assertTrue(true);
		}

		else {
			Assert.assertTrue(false);
		}
	}

	@Given("The user in homepage after succesful login")
	public void the_user_in_homepage_after_succesful_login() {

		if (driver.getTitle().equals("NumpyNinja")) {
			Assert.assertTrue(true);
		}
	}

	@Given("The user in the linkedlist page after logged in")
	public void the_user_in_the_linkedlist_page_after_logged_in() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/");

	}

	@When("The user clicks {string} Link in linkedListpage")
	public void the_user_clicks_link_in_linkedlistpage(String string) {
		linkedlist_obj.ClickLink(string);
	}

	@Then("The user connect to {string} Link ")
	public void the_user_connect_to_link(String string) {
		if (linkedlist_obj.getPageTitle().equals(string)) {

			Assert.assertTrue(true);
		}

		else {
			Assert.assertTrue(false);
		}
	}

	@When("The user clicks <link name> Link in LinkedListpage")
	public void the_user_clicks_link_name_link(String linkname) {
		linkedlist_obj.ClickLink(linkname);
	}

	@Then("The user to be directed  <link name> page")
	public void the_user_to_be_directed_link_name_page(String linkname) {
		if (linkedlist_obj.getPageTitle().equals(linkname)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@When("The user clicks Linkedlist page Try here button")
	public void the_user_clicks_try_here_button() {
		linkedlist_obj.click_tryHere();
	}

	@Then("The user is redirect to Linkedlist page tryEditor page")
	public void the_user_is_redirect_to_try_editor_page() {
		Assert.assertEquals(linkedlist_obj.runButtonText(), "Run");

	}

	@Then("The pratice question for LinkedList page should be displayed")
	public void the_pratice_question_page_should_be_displayed() {

		if (driver.getTitle().equals("pracQuesTitle")) {
			Assert.assertTrue(false);
		}
	}

	@After("linkedList")
	public void teardown() {
		driver.close();

	}

}
