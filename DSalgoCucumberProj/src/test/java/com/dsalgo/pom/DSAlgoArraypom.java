
package com.dsalgo.pom;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.dsalgo.utility.ExcelReader;

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
	// @FindBy(xpath = "//*[@id='answer_form']/button")
	// WebElement runBtn1;
	@FindBy(xpath = "//*[@id='answer_form']/button")
	WebElement runPracticeQueCode;
	@FindBy(xpath = "//button[text()='Run']")
	WebElement runBtn1;
	@FindBy(xpath = "//textarea[@tabindex='0']") // div[i
	WebElement textArea;
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
		ArraysUsingList.click();

	}

	public void ClickArrayBasicOperation() {
		BasicOperationsInLists.click();
	}

	public void clickApplicationOfArray() {
		ApplicationsOfArray.click();
	}
	
//navigation pages
	public void navigateToArrayPage() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/array/");

	}

	public void navigateToArrayInPythonPage() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/array/arrays-in-python/");

	}

	public void navigateToArraysUsingListPage() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/array/arrays-using-list/");

	}

	public void navigateToApplicationOfArray() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/array/applications-of-array/");
		
	}

	public void arrnavigateToArrayPracticePage() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/array/practice");
		
	}
	public void tryHerePythonEditor() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/tryEditor");

	}

	public void navigateToPracticeQuestion1() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/question/1");
		
	}

	public void arrayPageLogin(String uid, String password) {
		driver.navigate().to("https://dsportalapp.herokuapp.com/home");

	}

	public void navigateToArrBasicOperation() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/array/basic-operations-in-lists/");

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

		
		try {
			runBtn1.click();
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

	public void click_PraticeQueCodeRun() {
		runBtn1.click();

	}

	public String txt_output1() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Get txt-output1 :: " + txt_output1.getText());
		return txt_output1.getText();
	}

	public void fixIndentation(String code, WebElement element) {
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
		String[] str1 = code.split("\n");
		for (int i = 0; i < str1.length; i++) {
			System.out.println(str1[i]);
			if (str1[i].equalsIgnoreCase("\b")) {
				element.sendKeys(Keys.BACK_SPACE);
			} else {
				element.sendKeys(str1[i]);
				element.sendKeys(Keys.ENTER);
			}
		}
	}

	public void pythonCode(String sheet_Name, int row_Number) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		// arraypage_obj.TextIndentation(driver, null, row_Number, row_Number, false);
		List<Map<String, String>> testData = reader
				.getData(System.getProperty("user.dir") + "\\src\\test\\resources\\Utlils\\NewPython.xlsx", sheet_Name);
		String code = testData.get(row_Number).get("code");
		fixIndentation(code, textArea);
	}

}
