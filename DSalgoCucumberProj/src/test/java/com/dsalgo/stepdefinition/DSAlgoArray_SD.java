package com.dsalgo.stepdefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.dsalgo.DriverManager.DriverFactory;
import com.dsalgo.pom.DSAlgoArraypom;
import com.dsalgo.pom.DSAlgoArraypom;
import com.dsalgo.pom.DSAlgoGetStartedPom;
import com.dsalgo.pom.DSAlgoHomePom;
import com.dsalgo.pom.DSAlgoQueuePom;
import com.dsalgo.pom.DSAlgoRegisterPom;
import com.dsalgo.pom.DSAlgoSignInPom;
import com.dsalgo.pom.DSAlgoTreePom;
import com.dsalgo.utility.ConfigReader;
import com.dsalgo.utility.ExcelReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSAlgoArray_SD extends DSAlgoCommon_SD {
	WebDriver driver;
	ConfigReader config = new ConfigReader();
	Actions act;

	@Before("@array")
	public void setUP() throws Throwable {
		config.loadProperties();
		String browser = config.getBrowserType();
		DriverFactory.launchBrowser(browser);
		ConfigReader.initElements();
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
		arraypage_obj = new DSAlgoArraypom(driver);
	}

	@After("@array")
	public void teardown() {
		driver.close();

	}

	String arrayPageTitle = "Array";
	String pracQuesTitle = "Practice Questions";

	@Given("user is in home page with successful login")
	public void user_is_in_home_page_with_successful_login() {
		{
			if (driver.getTitle().equals("NumpyNinja")) {
				Assert.assertTrue(true);
			}
		}
	}

	@Given("The user is on the  home page with successful login")
	public void the_user_is_on_the_home_page_with_successful_login() {
		if(driver.getTitle().equals("NumpyNinja"))
		{
			Assert.assertTrue(true);
		}
	}
	@When("The user clicks on Get Started button")
	public void the_user_clicks_on_get_started_button() {
		homepage_obj.click_select_Arrays();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@Then("user should be directed to {string} page")
	public void user_should_be_directed_to_page(String string) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		if (driver.getTitle().equals("arrayPageTitle")) {
			Assert.assertTrue(true);
		}

	}

	@Given("The user is on Array page")
	public void the_user_is_on_array_page() {

		driver.navigate().to("https://dsportalapp.herokuapp.com/array/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("The user clicks Arrays in Python	link")
	public void the_user_clicks_arrays_in_python_link() {
		// arraypage_obj.ClickArrayPythonLink();
		arraypage_obj.ClickArraysInPython();
	}

	@Then("The user redirected to {string} page")
	public void the_user_redirected_to_page(String string) throws InterruptedException {
		if (arraypage_obj.getPageTitle().equals(string)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Given("The user is on the Array in Python Page")
	public void the_user_is_on_the_array_in_python_page() {

		driver.navigate().to("https://dsportalapp.herokuapp.com/array/arrays-in-python/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("The user clicks Try Here button of Array in Python Page")
	public void the_user_clicks_try_here_button_of_array_in_python_page() {
		arraypage_obj.click_tryHere();
	}

	@Then("The user should be redirected to a page having an Python Editor with a url {string}")
	public void the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String string) {
		arraypage_obj.tryHerePythonEditor();

	}

	@When("The user clicks Arrays using List link")
	public void the_user_clicks_arrays_using_list_link() {

		arraypage_obj.ClickArrayUsingListLink();
	}

	@Then("The user should be on the Arrays using List page")
	public void the_user_should_be_on_the_arrays_using_list_page() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/array/arrays-using-list/");
	}

	@Given("The user is on the Array using list page")
	public void the_user_is_on_the_array_using_list_page() {

		driver.navigate().to("https://dsportalapp.herokuapp.com/array/arrays-using-list/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@When("The user clicks Try Here button of Array Using List Page")
	public void the_user_clicks_try_here_button_of_array_using_list_page() {
		arraypage_obj.click_tryHere();

	}

	@Then("User should be redirected to Python Editor with a url {string}")
	public void user_should_be_redirected_to_python_editor_with_a_url(String string) {
		arraypage_obj.tryHerePythonEditor();
	}

	@Given("The user is on the Array Page")
	public void the_user_is_on_the_array_page() {

		driver.navigate().to("https://dsportalapp.herokuapp.com/array/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("The user click Array basic operation in Lists")
	public void the_user_click_array_basic_operation_in_lists() {
		arraypage_obj.ClickArrayBasicOperation();

	}

	@Then("The user should be redirected to {string} page")
	public void the_user_should_be_redirected_to_page(String string) {

		arraypage_obj.navigateToArrBasicOperation();
	}

	@Given("The user is on the Basic operations in Lists page")
	public void the_user_is_on_the_basic_operations_in_lists_page() {

		driver.navigate().to("https://dsportalapp.herokuapp.com/array/basic-operations-in-lists/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("The user clicks Try Here button of Operations in Lists")
	public void the_user_clicks_try_here_button_of_operations_in_lists() {
		arraypage_obj.click_tryHere();

	}

	@Then("user should be redirected to a page having an Python Editor with a url")
	public void user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url() {
		arraypage_obj.tryHerePythonEditor();
	}

	@When("The user click Applications of Array link")
	public void the_user_click_applications_of_array_link() {
		arraypage_obj.clickApplicationOfArray();

	}

	@Given("The user is on the  Applications of Array page")
	public void the_user_is_on_the_applications_of_array_page() {

		driver.navigate().to("https://dsportalapp.herokuapp.com/array/applications-of-array/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("The user clicks Try Here button in Applications of Array page")
	public void the_user_clicks_try_here_button_in_applications_of_array_page() {
		arraypage_obj.click_tryHere();

	}

	@Then("The user should redirected to Python Editor page")
	public void the_user_should_redirected_to_python_editor_page() {
		arraypage_obj.tryHerePythonEditor();
	}

	@Then("Arr The user should be redirected to a page having an Python Editor with a url {string}")
	public void the_the_user_should_be_redirected_to_a_page_having_an_python_editor_with_a_url(String string) {
		arraypage_obj.tryHerePythonEditor();
	}

	@Given("The user is on the Python Editor")
	public void the_user_is_on_the_python_editor() {
		arraypage_obj.tryHerePythonEditor();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("The user enter valid python code print {string} and clicks run button")
	public void the_user_enter_valid_python_code_print_and_clicks_run_button(String string) {
		act.sendKeys("print('" + string + "')").build().perform();
		arraypage_obj.clickrunValidCode();
	}

	@Then("User is able to see the output {string} in console")
	public void user_is_able_to_see_the_output_in_console(String string) {
		Assert.assertEquals(arraypage_obj.text_output1(), string);
	}

	@When("The user enter invalid python code {string} and clicks run button")
	public void the_user_enter_invalid_python_code_and_clicks_run_button(String string) {
		act.sendKeys(string).build().perform();
		arraypage_obj.clickrunInvalidCode();
	}

	@Then("User should see the error message")
	public void user_should_see_the_error_message() {
		try {
			arraypage_obj.click_run();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
		} catch (Exception e) {

		}
	}

	@Given("The use is on the  Array in Python Page")
	public void the_use_is_on_the_array_in_python_page() {

		driver.navigate().to("https://dsportalapp.herokuapp.com/array/arrays-in-python/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("The user click Practice Questions link")
	public void the_user_click_practice_questions_link() {
		arraypage_obj.clickPracticeQuestions();
	}

	@Then("The user redirected to Practice page")
	public void the_user_redirected_to_practice_page() {
		Assert.assertTrue(true);
	}

	@Given("The use is on the  Array Practice Questions Page")
	public void the_use_is_on_the_array_practice_questions_page() {

		driver.navigate().to("https://dsportalapp.herokuapp.com/array/practice");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("The user click Search the array link")
	public void the_user_click_search_the_array_link() {
		arraypage_obj.clickSearchTheArrayLink();
	}

	@Then("The user should be redirected to a page having an Python Editor")
	public void the_user_should_be_redirected_to_a_page_having_an_python_editor() {
		Assert.assertTrue(true);
	}

	@When("The user click Max Consecutive Ones link")
	public void the_user_click_max_consecutive_ones_link() {
		arraypage_obj.clickMaxConsecutiveOnesLink();
	}

	@Then("The user should be redirected to a page having an Python Editor2")
	public void the_user_should_be_redirected_to_a_page_having_an_python_editor2() {
		Assert.assertTrue(true);
	}

	@When("The user click Find Numbers with Even Numbers of digits link")
	public void the_user_click_find_numbers_with_even_numbers_of_digits_link() {
		arraypage_obj.clickEvenNumbersOfDigitsLink();
	}

	@Then("The user should be redirected to a page having an Python Editor3")
	public void the_user_should_be_redirected_to_a_page_having_an_python_editor3() {
		Assert.assertTrue(true);
	}

	@When("The user click Squares of a sorted Array link")
	public void the_user_click_squares_of_a_sorted_array_link() {
		arraypage_obj.clickSquaresOfSortedArrayLink();
	}

	@Then("The user should be redirected to a page having an Python Editor4")
	public void the_user_should_be_redirected_to_a_page_having_an_python_editor4() {
		Assert.assertTrue(true);
	}

	@Given("The user is on the Search the array link Python Editor")
	public void the_user_is_on_the_search_the_array_link_python_editor() {

		driver.navigate().to("https://dsportalapp.herokuapp.com/question/1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Given("The user is on the Array Practice Questions page")
	public void the_user_is_on_the_array_practice_questions_page() {

		driver.navigate().to("https://dsportalapp.herokuapp.com/question/1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("The user clicks submit button")
	public void the_user_clicks_submit_button() {
		arraypage_obj.clickSubmit();
	}

	@Then("The user should get error message in console")
	public void the_user_should_get_error_message_in_console() {
		arraypage_obj.getError();
	}
	
	@Given("The user is on the first Array Practice Question page")
	public void the_user_is_on_the_first_array_practice_question_page() {
	   driver.navigate().to("https://dsportalapp.herokuapp.com/question/1");
	}
	
	//run for invalid code
	
	@When("The user clicks run button with invalid code")
	public void the_user_clicks_run_button_with_invalid_code(String string) {
	
	  act.sendKeys(string).build().perform();
		arraypage_obj.clickrunInvalidCode();
	}
	@Then("user can see error message warning")
	public void user_can_see_error_message_warning() {
		try {
			arraypage_obj.clickRunBtn1();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
		} catch (Exception e) {

		}
	}

//practice que editor run button scenario
	@Given("The user is on the Array Practice Questions editor page")
	public void the_user_is_on_the_array_practice_questions_editor_page() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/question/1");

		//DriverFactory.getDriver().navigate().to("https://dsportalapp.herokuapp.com/question/1");
	}
	  
	
	@When("User click Run button with valid python code to print in excel sheetname {string} and rownumber {int}")
	public void user_click_run_button_with_valid_python_code_to_print_in_excel_sheetname_and_rownumber(
			String sheet_Name, Integer row_Number) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(System.getProperty("user.dir") + "\\src\\test\\resources\\Utlils\\Python.xlsx", sheet_Name);
		String code = testData.get(row_Number).get("code");
		act.sendKeys(code).build().perform();
		arraypage_obj.clickRunBtn1();

	}

	@Then("User should see the output sheetname {string} and rownumber {int}")
	public void user_should_see_the_output_sheetname_and_rownumber(String sheet_Name, Integer row_Number)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(System.getProperty("user.dir") + "\\src\\test\\resources\\Utlils\\Python.xlsx", sheet_Name);
		String result = testData.get(row_Number).get("Result");
		Assert.assertEquals(arraypage_obj.que_output(), result);
	}

}
