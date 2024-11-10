package com.dsalgo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DSAlgoArraypom extends DSAlgoCommonPom {
	public DSAlgoArraypom(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	@FindBy(linkText = "Arrays in Python")
	WebElement ArraysInPython;
	@FindBy(linkText = "Arrays Using List")
	WebElement ArraysUsingList;
	@FindBy(linkText = "Basic Operations in Lists")
	WebElement BasicOperationsInLists;
	@FindBy(linkText = "Applications of Array")
	WebElement ApplicationsOfArray;
	@FindBy(xpath = "//html/body/div[2]/div/div[2]/a") // tryHere
	WebElement tryHere;
	@FindBy(xpath = "//button[text()='Run']") // xpath- //*[@id="answer_form"]/button
	WebElement runButton;
	@FindBy(xpath = "//*[@id='output']")
	WebElement txt_output1;
	@FindBy(xpath = "//a[text()='Practice Questions']")
	WebElement practiceQuestions;
	@FindBy(linkText = "Search the array")
	WebElement practiceQuestion1;
	@FindBy(linkText = "Max Consecutive Ones")
	WebElement MaxConsecutiveOnesLink;
	@FindBy(linkText = "Find Numbers with Even Number of Digits")
	WebElement EvenNumbersOfDigitsLink;
	@FindBy(xpath = "//html/body/div[5]/a")
	WebElement SquaresOfSortedArrayLink;
	@FindBy(xpath = "//*[@id='answer_form']/input[2]")
	WebElement submit;
	@FindBy(xpath = "//pre[@id='output']")
	WebElement submitError;
	//@FindBy(xpath = "//*[@id='answer_form']/button")
	//WebElement runBtn1;
	@FindBy(xpath = "//*[@id='answer_form']/button")
	WebElement runPracticeQueCode;
	@FindBy(xpath = "//*[@id='output']")
	WebElement que_output;
	@FindBy(xpath = "//button[text()='Run']")
	WebElement runBtn1;
	String actualTitle;

	public Object getPageTitle() {
		return (driver.getTitle());
	}

	public void click_tryHere() {
		js.executeScript("arguments[0].scrollIntoView();", tryHere);
		tryHere.click();

	}

	public void ClickArraysInPython() {
		ArraysInPython.click();
	}

	public void ClickArrayUsingListLink() {

		driver.findElement(By.linkText("Arrays Using List")).click();

	}

	public void ClickArrayBasicOperation() {
		BasicOperationsInLists.click();
	}

	public void clickApplicationOfArray() {
		ApplicationsOfArray.click();
	}

	public void arrayPageLogin(String uid, String password) {
		driver.navigate().to("https://dsportalapp.herokuapp.com/home");

	}

	public void navigateToArrBasicOperation() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/array/basic-operations-in-lists/");

	}

	public void navigateToApplicationOfArray() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/array/applications-of-array/");

	}

	public void click_run() {
		runButton.click();

	}

	public String text_output1() {

		return txt_output1.getText();
	}

	public void clickrunValidCode() {
		try {
			click_run1();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
		} catch (Exception e) {

		}

	}

	private void click_run1() {
		runButton.click();

	}

	public void clickrunInvalidCode() {
		try {
			click_run();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
		} catch (Exception e) {

		}

	}

	public void clickPracticeQuestions() {
		practiceQuestions.click();
	}

	public void clickSearchTheArrayLink() {
		practiceQuestion1.click();

	}

	public void clickMaxConsecutiveOnesLink() {
		MaxConsecutiveOnesLink.click();

	}

	public void clickEvenNumbersOfDigitsLink() {
		EvenNumbersOfDigitsLink.click();

	}

	public void clickSquaresOfSortedArrayLink() {
		SquaresOfSortedArrayLink.click();

	}

//practice que editor run button
	public void clickRunBtn1() {
		
		//try {
		runBtn1.click();
			/*Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Assert.assertTrue(false);
		} catch (Exception e) {

		}
*/
	}

	public void practiceQueOutput() {
		try {
			click_run1();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
		} catch (Exception e) {

		}

	}

	public void clickSubmit() {
		submit.click();

	}

	public void getError() {
		submitError.click();

	}

	public void clickLinkFromList(String linkname) {
		que_output.click();

	}

	public void click_PraticeQueCodeRun() {
		runBtn1.click();

	}

	public void tryHerePythonEditor() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/tryEditor");

	}

	public String que_output() {
		return que_output.getText();
	}

}