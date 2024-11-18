package com.dsalgo.stepdefinition;

import java.time.Duration;
import java.util.LinkedList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
import io.cucumber.java.en.And;
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

	@Given("LinkedList The user in homepage after succesful login")
	public void the_user_in_homepage_after_succesful_login() {
		if (driver.getTitle().equals("NumpyNinja")) {
			Assert.assertTrue(true);
		}
	}

	@When("The user clicks the getting started button in LinkedList panel")
	public void the_user_clicks_the_getting_started_button_in_linked_list_panel() {
		homepage_obj.click_select_Linked_List();

	}

	@Then("The user should be directed to LinkedList page")
	public void the_user_should_be_directed_to_Linked_List_page() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("Title is" + driver.getTitle());
		if (driver.getTitle().equals(linkedlistpageTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Given("The user in the LinkedList page after logged in")
	public void the_user_in_the_linkedlist_page_after_logged_in() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/");

	}

	@Then("The user to be directed to linked list {string} page")
	public void the_user_to_be_directed_link_name_page(String linkname) {
		if (linkedlist_obj.getPageTitle().equals(linkname)) {
			Assert.assertTrue(true);
		} else {

		}
	}

	@Then("^user is redirected to a page having TryEditor with a Run button$")
	public void user_is_redirected_to_a_page_having_try_editor_with_a_run_button() throws InterruptedException {

		System.out.println("user is navigated to Linked List page");
		driver.getPageSource().contains("Run");
		Thread.sleep(3000);

	}

	@When("^user sendkeys$")
	public void user_sendkeys() throws Throwable {
		driver.findElement(By.xpath("//form[@id='answer_form']/div/div/div/textarea")).sendKeys("linkedlist");
		Thread.sleep(3000);
	}

	@And("^user clicks on Run button$")
	public void user_clicks_on_Run_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"answer_form\"]/button")).click();
		Thread.sleep(3000);

	}

	@Then("^An alert pops up")
	public void An_alert_pops_up() {
		String expectedAlertMessage = "NameError: name 'linkedlist' is not defined on line 1";
		String actualAlertMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
		driver.switchTo().alert().accept();
	}

	@Given("user is on the Linked List page")
	public void user_is_on_the_linked_list_page() throws InterruptedException {
		linkedlist_obj.navigateLinkedListPage();

	}

	@When("user clicks on Introduction link")
	public void user_clicks_on_introduction_link() {
		linkedlist_obj.ClickIntroduction();

	}

	@Then("^user is navigated to the Introduction page$")
	public void user_is_navigated_to_the_introduction_page() throws InterruptedException {
		linkedlist_obj.PageIntroduction();

	}

	@Given("user is on the introduction page")
	public void user_is_on_the_introduction_page() {
		linkedlist_obj.PageIntroduction();

	}

	@When("user clicks on button Try here button")
	public void user_clicks_on_button_try_here_button() {
		linkedlist_obj.click_tryHere();

	}

	@Then("user is navigated to a page having TryEditor with a Run button")
	public void user_is_navigated_to_a_page_having_try_editor_with_a_run_button() {
		linkedlist_obj.navigateEditorPage();

	}

	@Given("user is on the Creating Linked List page")
	public void user_is_on_the_creating_linked_list_page() throws InterruptedException {
		linkedlist_obj.navigateLinkedListPage();
	}

	@When("user clicks on Creating Linked List link")
	public void user_clicks_on_creating_linked_list_link() {
		linkedlist_obj.ClickCreatingLinkedList();
	}

	@Then("user is navigated to the Creating Linked List page")
	public void user_is_navigated_to_the_creating_linked_list_page() {
		linkedlist_obj.ClickCreatingLinkedList();

	}	
	
	@Given("user click is on the Creating Linked List page")
	public void user_click_is_on_the_creating_linked_list_page() {
		linkedlist_obj.ClickCreatingLinkedList();
	}
	
	@When("user click on button Try here button")
	public void user_click_on_button_try_here_button() {
		linkedlist_obj.click_tryHere();
	}
	
	@Then("user is validate to a page having Try Editor with a Run button")
	public void user_is_validate_to_a_page_having_try_editor_with_a_run_button() {
		linkedlist_obj.navigateEditorPage();
	}
	
	// this is for typesofLL s- start		
	@Given("user is on the Linked List page for Types")
	public void user_is_on_the_Linked_List_page_for_Types() {
		linkedlist_obj.navigateLinkedListPage();
	}	
	@When("user clicks on Types of Linked List link")
	public void user_clicks_on_Types_of_Linked_List_link() {
		linkedlist_obj.clickTypesOfLinkedList(); 
	}
	@Then("user is navigated to the Types of Linked List page")
	public void user_is_navigated_to_the_Types_of_Linked_List_page() {
		linkedlist_obj.navigateTypesOfLinkedListPage();
	}	
	@Given("user click is on the Types of Linked List page")
	public void user_click_is_on_the_Types_of_Linked_List_page() {
		linkedlist_obj.clickTypesOfLinkedList();
	}
	@When("user click on button the Try here button")
	public void user_clicks_the_button_try_here_button() {
		linkedlist_obj.click_tryHere();
	}	
	@Then("user is navigated to a page having TryEditor with a Run button for Types")
	public void user_is_navigated_to_a_page_having_TryEditor_with_a_run_button_for_Types() {
		linkedlist_obj.navigateEditorPage();
	}
	// this is for typesofLL s- end
	
	// this is for Implement - start		
	@Given("User is on the Linked List page for Implement")
	public void user_is_on_the_Linked_List_page_for_Implement() {
		linkedlist_obj.navigateLinkedListPage();
	}	
	@When("User clicks on Implement of Linked List link")
	public void user_clicks_on_Implement_of_Linked_List_link() {
		linkedlist_obj.clickImplementOfLinkedList(); 
	}
	@Then("User is navigated to the Implement of Linked List page")
	public void user_is_navigated_to_the_Implement_of_Linked_List_page() {
		linkedlist_obj.navigateImplementOfLinkedListPage();
	}	
	@Given("User click is on the Implement of Linked List page")
	public void user_click_is_on_the_Implement_of_Linked_List_page() {
		linkedlist_obj.clickImplementOfLinkedList();
	}
	@When("User click on button the Try here button for Implement")
	public void user_click_on_button_the_Try_here_button_for_Implement() {
		linkedlist_obj.click_tryHere();
	}	
	@Then("User is navigated to a page having TryEditor with a Run button for Implement")
	public void user_is_navigated_to_a_page_having_TryEditor_with_a_Run_button_for_Implement() {
		linkedlist_obj.navigateEditorPage();
	}
	// this is for Implement- end

	// this is for Traversal - start		
	@Given("User is on the Linked List page for Traversal")
	public void user_is_on_the_Linked_List_page_for_Traversal() {
		linkedlist_obj.navigateLinkedListPage();
	}	
	@When("User clicks on Traversal of Linked List link")
	public void user_clicks_on_Traversal_of_Linked_List_link() {
		linkedlist_obj.clickTraversalOfLinkedList(); 
	}
	@Then("User is navigated to the Traversal of Linked List page")
	public void user_is_navigated_to_the_Traversal_of_Linked_List_page() {
		linkedlist_obj.navigateTraversalOfLinkedListPage();
	}	
	@Given("User click is on the Traversal of Linked List page")
	public void user_click_is_on_the_Traversal_of_Linked_List_page() {
		linkedlist_obj.clickTraversalOfLinkedList();
	}
	@When("User click on button the Try here button for Traversal")
	public void user_click_on_button_the_Try_here_button_for_Traversal() {
		linkedlist_obj.click_tryHere();
	}	
	@Then("User is navigated to a page having TryEditor with a Run button for Traversal")
	public void user_is_navigated_to_a_page_having_TryEditor_with_a_Run_button_for_Traversal() {
		linkedlist_obj.navigateEditorPage();
	}
	// this is for Traversal- end
	
	// this is for Insertion - start		
	@Given("User is on the Linked List page for Insertion")
	public void user_is_on_the_Linked_List_page_for_Insertion() {
		linkedlist_obj.navigateLinkedListPage();
	}	
	@When("User clicks on Insertion of Linked List link")
	public void user_clicks_on_Insertion_of_Linked_List_link() {
		linkedlist_obj.clickInsertionOfLinkedList(); 
	}
	@Then("User is navigated to the Insertion of Linked List page")
	public void user_is_navigated_to_the_Insertion_of_Linked_List_page() {
		linkedlist_obj.navigateInsertionOfLinkedListPage();
	}	
	@Given("User click is on the Insertion of Linked List page")
	public void user_click_is_on_the_Insertion_of_Linked_List_page() {
		linkedlist_obj.clickInsertionOfLinkedList();
	}
	@When("User click on button the Try here button for Insertion")
	public void user_click_on_button_the_Try_here_button_for_Insertion() {
		linkedlist_obj.click_tryHere();
	}	
	@Then("User is navigated to a page having TryEditor with a Run button for Insertion")
	public void user_is_navigated_to_a_page_having_TryEditor_with_a_Run_button_for_Insertion() {
		linkedlist_obj.navigateEditorPage();
	}
	// this is for Insertion- end
	
	// this is for Deletion - start		
	@Given("User is on the Linked List page for Deletion")
	public void user_is_on_the_Linked_List_page_for_Deletion() {
		linkedlist_obj.navigateLinkedListPage();
	}	
	@When("User clicks on Deletion of Linked List link")
	public void user_clicks_on_Deletion_of_Linked_List_link() {
		linkedlist_obj.clickDeletionOfLinkedList(); 
	}
	@Then("User is navigated to the Deletion of Linked List page")
	public void user_is_navigated_to_the_Deletion_of_Linked_List_page() {
		linkedlist_obj.navigateDeletionOfLinkedListPage();
	}	
	@Given("User click is on the Deletion of Linked List page")
	public void user_click_is_on_the_Deletion_of_Linked_List_page() {
		linkedlist_obj.clickDeletionOfLinkedList();
	}
	@When("User click on button the Try here button for Deletion")
	public void user_click_on_button_the_Try_here_button_for_Deletion() {
		linkedlist_obj.click_tryHere();
	}	
	@Then("User is navigated to a page having TryEditor with a Run button for Deletion")
	public void user_is_navigated_to_a_page_having_TryEditor_with_a_Run_button_for_Deletion() {
		linkedlist_obj.navigateEditorPage();
	}
	


	

	
	
}


	

	
	
}

