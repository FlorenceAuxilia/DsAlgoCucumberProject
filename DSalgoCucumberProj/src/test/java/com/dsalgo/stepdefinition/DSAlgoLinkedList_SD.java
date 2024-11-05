package com.dsalgo.stepdefinition;

import java.util.LinkedList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.dsalgo.pom.DSAlgoGetStartedPom;
import com.dsalgo.pom.DSAlgoHomePom;
import com.dsalgo.pom.DSAlgoLinkedListPom;
import com.dsalgo.pom.DSAlgoSignInPom;
import com.dsalgo.pom.DSAlgoStackPom;
import com.dsalgo.pom.DataStructure_IntroductionPom;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;

public class DSAlgoLinkedList_SD {

	Actions act;
	WebDriver driver;
	DSAlgoGetStartedPom getstartedpage_obj;
	DSAlgoSignInPom signinpage_obj;
	DSAlgoHomePom homepage_obj;
	DSAlgoStackPom st;
	DSAlgoLinkedListPom linkedList_obj;

	@Before("@LinkedList")
	public void setUP1() {
		driver = new ChromeDriver();
		driver.get("https://dsportalapp.herokuapp.com/");
		driver.manage().window().maximize();

		act = new Actions(driver);

		getstartedpage_obj = new DSAlgoGetStartedPom(driver);
		getstartedpage_obj.clickGetStarted();
		homepage_obj = new DSAlgoHomePom(driver);
		homepage_obj.click_Signin();
		signinpage_obj = new DSAlgoSignInPom(driver);
		signinpage_obj.setUserName("ninja4");
		signinpage_obj.setPassword("Tiger123@");
		signinpage_obj.clickLogin();
		linkedList_obj = new DSAlgoLinkedListPom(driver);

		{

			String LinkedListPageTitle = ("LinkedList");
		}
		// String pracQuesTitle ="practice Question"

	}

	@Given("The userin in homepage")
	public void the_user_is_in_homepage() {
		{

			if (driver.getClass().equals("NumpyNinja")) {
			}
			AssertJUnit.assertTrue(true);

		}

	}

	@When("the user gives proper loginId, password")
	public void the_user_gives_proper_login_id_password() {

		homepage_obj.click_select_Linked_List();
	}

	@Then("The user should be directed to LinkedList Page")
	public void the_user_should_be_directed_to_LinkedList_page() {

		if (driver.getTitle().equals("LinkedListPageTitle")) {
			Assert.assertTrue(true);

		}

	}

	@When("user clicks on Get Started button")
	public void user_clicks_on_get_started_button() {
		setUP1();
		homepage_obj.click_select_Arrays();
		// driver.findElement(By.xpath("//html/body/div[2]/div[2]/div/div/a")).click();
	}

	@Then("user be directed to {string} page")
	public void user_be_directed_to_page(String string) throws InterruptedException {
		if (driver.getTitle().equals("arrayPageTitle")) {
			Assert.assertTrue(true);
		}
		Thread.sleep(20);

	}

	{

		driver.navigate().to("https://dsportalapp.herokuapp.com/LinedList/");
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (driver.getTitle().equals("Introduction")) {
			Assert.assertTrue(true);
		}

	}

	@Given("The user is on  introduction page")
	public void the_user_is_on_Introduction_page() {
		setUP1();
		driver.navigate().to("https://dsportalapp.herokuapp.com/introduction/");
	}

	@When("The user clicks introduction")
	public void the_user_clicks_aintroduction_link() {
		linkedList_obj.ClickIntroductio();
	}

	@Then("The user redirected to {string} page")
	public void the_user_redirected_to_page(String string) throws InterruptedException {
		if (linkedList_obj.getPageTitle().equals(string)) {
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);
		}
		Thread.sleep(30);

	}

	@Given("The user is on the Introduction")
	public void the_user_is_on_the_introduction_page() {
		setUP1();
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/introduction/");
	}

	@When("The user clicks Try Here button of introduction")
	public void the_user_clicks_try_here_button_of_Introduction_page() {
		linkedList_obj.click_tryHere();
	}

	@Then("The user should be redirected to a page having an Python Editor with a url {string}")
	public void the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String string) {
		driver.navigate().to("https://dsportalapp.herokuapp.com/tryEditor");
		linkedList_obj.pythonEditor();

	}

	@Given("The user is on LinkedList page")
	public void the_user_is_on_LinkedList_page() throws InterruptedException {
		setUP1();
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/");
	}

	@When("The user clicks Introduction")
	public void the_user_clicks_Introduction_button(String string) {
		linkedList_obj.ClickIntroductio();

	}

	@Then("The user should be redirected to {string}")
	public void the_user_should_be_redirected_to(String string) throws InterruptedException {
		if (linkedList_obj.getPageTitle().equals(string)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		Thread.sleep(30);

	}

	@Given("The user is on the introduction Page")
	public void the_user_is_on_the_Introduction_page() {
		//
		linkedList_obj.regClickIntrodcution();
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/introduction/");

	}

	@When("The user clicks Try Here button of LinkedList page")
	public void t_the_user_clicks_try_here_button_of_Introduction_page() {
		linkedList_obj.click_tryHere();
	}

	@Then("The user should be redirected to a page having an LinkedList with a url {string}")
	public void the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url1(String string) { //
		driver.navigate().to("https://dsportalapp.herokuapp.com/tryEditor");
		linkedList_obj.pythonEditor();

	}

	@When("The user click Array using list link")
	public void the_user_click_Introduction_link() {
		setUP1();
		linkedList_obj.ClickIntroductio();
	}

	@Then("The user should be redirected to {string} page")
	public void the_user_should_be_redirected_to_page(String string) throws InterruptedException {
		if (linkedList_obj.getPageTitle().equals(string)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		Thread.sleep(30);

	}

	@Given("The user is on the Creating Linked LIst")
	public void the_user_is_on_the_Creating_Linked_Listpage() {
		setUP1();
		driver.navigate().to("hhttps://dsportalapp.herokuapp.com/linked-list/creating-linked-list/");
	}

	@When("The user clicks Try Here button of ArCreating Linked LIst")
	public void the_user_clicks_try_here_button_of_creating_Linked_List_page() {
		linkedList_obj.click_tryHere();
	}

	@Given("The user is on the Linked List")
	public void the_user_is_on_the_Linked_List_page() {
		setUP1();
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/");
	}

	@When("The user click Types of Linked Lists")
	public void the_user_click_array_basic_operation_in_lists() {
		linkedList_obj.ClickTypesofLinkedLists();
	}

	@Then("The user should be redirected to {string} page")
	public void the_user_should_be_redirected_to_page1(String string) {
		linkedList_obj.ClickTypesofLinkedLists();

	}

	@Given("The user is on the Implement Linked List in Python")
	public void the_user_is_on_the_Implement_Linked_List_in_python_page() {
		setUP1();
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/implement-linked-list-in-python/");
	}

	@When("The user clicks Try Here button of Implement Linked List in python")
	public void the_user_clicks_try_here_button_of_Implement_Linked__List_in_python() {
		linkedList_obj.click_tryHere();

	}

	@When("The user click Traversal")
	public void the_user_click_Traversal_link() {
		linkedList_obj.ClickTraversal();
	}

	@Then("The user should be redirected to {string} page")

	public void the_user_should_be_redirected_to_page() {
		linkedList_obj.navigateToTraversal();

	}

	@When("The user click the Deletion page")
	public void the_user_click_Deletion_link() {
		linkedList_obj.ClickDeletiontion();

	}

	@Given("The user is on the Python Editor")
	public void the_user_is_on_the_python_editor() {
		setUP1();
		driver.navigate().to("https://dsportalapp.herokuapp.com/tryEditor");
		linkedList_obj.pythonEditor();
	}

	@When("The user write the valid python code in Editor and Click the Run button")
	public void the_user_write_the_valid_python_code_in_editor_and_click_the_run_button(String string) {
		act.sendKeys("print('" + string + "')").build().perform();
	}

	@Then("The user should able to see output in the console")
	public void the_user_should_able_to_see_output_in_the_console(String string) {
		Assert.assertEquals(linkedList_obj.text_output(), string);

	}

	@When("The user write the invalid code in Editor")
	public void the_user_write_the_invalid_code_in_editor(CharSequence string) {
		act.sendKeys(string).build().perform();
	}

	{
	}

	@Then("The user should able to see an error message in alert window")
	public void the_user_should_able_to_see_an_error_message_in_alert_window1() {
		{
			try {
				linkedList_obj.click_run();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				Assert.assertTrue(true);
			} catch (Exception e) {
			}
		}

	}

	private void the_user_should_able_to_see_an_error_message_in_alert_window() {
		// TODO Auto-generated method stub

	}

}
