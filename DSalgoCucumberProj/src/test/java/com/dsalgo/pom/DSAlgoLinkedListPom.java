package com.dsalgo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DSAlgoLinkedListPom extends DSAlgoCommonPom {

	public DSAlgoLinkedListPom(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(linkText ="linked-list")
	WebElement linkedlist;

	@FindBy(linkText ="introduction")
	WebElement introduction;
	
     @FindBy(linkText="creating-linked-list")
	WebElement creating_Linked_List;

	@FindBy(linkText = "types-of linked-list")
	WebElement types_of_linked_inked_List;

	@FindBy(linkText ="implement linked list in python")
	WebElement implement_Linked_List_in_Python;

	@FindBy(linkText ="Traversal")
	WebElement traversal;

	@FindBy(linkText ="insertion")
	WebElement insertion;

	@FindBy(linkText ="deletion")
	WebElement deletion;

	@FindBy(xpath ="//a[text()='Try here>>>']")
	WebElement tryHere;

	@FindBy(xpath ="//button[text()='Run']")
	WebElement runButton;

	@FindBy(xpath = "//*[@id='output']")
	WebElement txt_output;
	String actualTitle;

	public void ClickLinks(String linkName) {
		driver.findElement(By.linkText(linkName)).click();
	}

	public void ClickIntroduction() {
		introduction.click();
	}

	public void ClickCreatinLinkedList() {
		creating_Linked_List.click();
	}

	public void verifyQPage(String title) {
		// TODO Auto-generated method stub
		actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, title);
	}

	public String getPageTitle1() {
		// TODO Auto-generated method stub
		return (driver.getTitle());

	}

	public void Click_tryHere() {
		js.executeScript("arguments[0].scrollIntoView();", tryHere);
		tryHere.click();

	}

	public void click_run() {
		runButton.click();

	}

	public String runButtonText() {
		runButton.click();
		return (runButton.getText());
	}

	public String text_output() {

		return txt_output.getText();
	}

	public void click_tryHere() {
		js.executeScript("arguments[0].scrollIntoView();", tryHere);
		tryHere.click();

	}

	public void Click_run() {
		runButton.click();

	}

	public String RunButtonText() {
		runButton.click();
		return (runButton.getText());
	}

	public void ClickLink(String linkname) {
		// TODO Auto-generated method stub

	}

	public String Text_output() {

		return (txt_output.getText());

	}

	public String getPageTitle() {
		// TODO Auto-generated method stub
		return (driver.getTitle());

	}

	public String ClickLinkedlistLink(String string) {
		// TODO Auto-generated method stub
		return (driver.getTitle());		
	}
}
