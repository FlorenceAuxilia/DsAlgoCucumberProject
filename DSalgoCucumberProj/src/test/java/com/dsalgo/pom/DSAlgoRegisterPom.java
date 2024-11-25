package com.dsalgo.pom;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.dsalgo.stepdefinition.DSAlgoCommon_SD;
import com.dsalgo.utility.ExcelReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DSAlgoRegisterPom extends DSAlgoCommonPom {

	//static WebDriver driver;
	

	By username = By.xpath("//*[@id='id_username']");
	By password = By.xpath("//*[@id='id_password1']");
	By confirmPassword = By.xpath("//*[@id='id_password2']");
	By registerButton = By.xpath("//html/body/div[2]/div/div[2]/form/input[5]");
	By loginLink = By.xpath("//html/body/div[2]/div/div[2]/a");
	String actualTitle;
	String alertMessage;

	public DSAlgoRegisterPom(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterUsername(String uname) {

		driver.findElement(username).sendKeys(uname);

	}

	public void enterPassword(String password1) {
		driver.findElement(password).sendKeys(password1);

	}

	public void enterConfirmPassword(String password2) {
		driver.findElement(confirmPassword).sendKeys(password2);

	}

	public void clickRegister() {
		driver.findElement(registerButton).click();

	}


	public void verifyPage(String title) {
		actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, title);

	}

	public String getPageTitle() {
		return (driver.getTitle());
	}
	

	public void registerClick() {
		driver.findElement(registerButton).click();

	}

	public boolean checkForErrorMessage1() throws InterruptedException {
		return (driver.findElement(By.xpath(" ")).isDisplayed());

	}

	public void registerWithUsername(String uname) {
		driver.findElement(registerButton).click();

	}

	public void checkErrorMsgInPaswrdField() {
		driver.switchTo().alert().getText();// switch to alert
		alertMessage = driver.switchTo().alert().getText(); // capture alert message
	}

	public void registerWithUnamePassword(String uname, String pass) {
		driver.findElement(registerButton);
	}

	public void checkErrorMsgInConfirmPaswrdField() {
		driver.switchTo().alert().getText();// switch to alert
		alertMessage = driver.switchTo().alert().getText(); // capture alert message

	}

	public void registerWithSpecialcharUname(String username, String password2, String confirmPassword2) {
		// @/./+/-/_

		driver.findElement(registerButton).click();
		String validations = "@,.,+,-,_";
		String[] validationChar = validations.split(",");
		String uValidation = username;
		for (String s : validationChar) {
			if (!uValidation.contains(s)) {
				chkError();
			}
		}
	}

	public void chkError() {
		driver.findElement(By.xpath("/html/body/div[3]"));

	}

	public void registerWithNumericPassword(String username, String password2, String confirmPassword2) {
		driver.findElement(registerButton).click();
		// String storePassword = driver.findElement(password).getText();
		String storePassword = password2;
		isNumeric(storePassword);
	}

	public void isNumeric(String storePassword) {
		for (char c : storePassword.toCharArray()) {
			if (Character.isDigit(c)) {
				warningMsgWithNumericPassword();
			}
		}
	}

	public void warningMsgWithNumericPassword() {
		driver.findElement(By.xpath("//html/body/div[3]"));
	}

	public void registerWithInvalidSizePassword(String username, String password2, String confirmPassword2) {
		driver.findElement(registerButton).click();
		driver.findElement(password).sendKeys(password2);

		checkPasswordLength(password2);

	}

	private void checkPasswordLength(String password) {
		if (password.length() < 8) {
			warningMassege();
		}

	}

	public void passwordMismatch(String username2, String password2, String confirmPassword2) {
		driver.findElement(registerButton).click();

	}

	public void warningMassege() {
		driver.findElement(By.xpath("//html/body/div[3]"));

	}

	public void clickLogin() {
		driver.findElement(loginLink).click();

	}

	public void warningMsgWithInvalidPassword() {
		driver.findElement(By.xpath("//html/body/div[3]"));

	}


	private boolean checkErrorMsg() {
		return true;
	}

	public String checkErrorpopup() {
		WebElement activeElement = driver.switchTo().activeElement();
		String messageStr = activeElement.getAttribute("validationMessage");
		System.out.println("Actual message appeared on screen: " + messageStr);
		return messageStr;
	}

	public void checkLimitForUsername() {
		
		  String user_name = driver.findElement(username).getText();
		  checkUsernameLength(user_name);
		 
			
		}

	private boolean checkUsernameLength(String user_name) {
		if (user_name.length() >150) {
			return true;
		}
		return false;
		
	}

	public void registerWithInputData(String sheetName, int row_Number) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		//System.out.println("excelReader is :: " + reader + " Sheet name :: " + sheetName);
		List<Map<String, String>> testData = reader.getData(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Utlils\\NewPython.xlsx",sheetName);
		String username = testData.get(row_Number).get("username");
		String password =testData.get(row_Number).get("password");
		String confirmPassword=testData.get(row_Number).get("confirmPassword");
		System.out.println("Username--- "+ username+ "passwd--- " +password + "Confirmpasswd--- "+ confirmPassword);
		enterUsername(username);
		enterPassword(password);
		enterConfirmPassword(confirmPassword);
		
	}

	

	

}







