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

	@FindBy(linkText ="Introduction")
	WebElement introduction;
	
     @FindBy(linkText="creating-linked-list")
	WebElement creating_linked_List;

	@FindBy(linkText = "types-of linked-list")
	WebElement types_of_linked__List;

	@FindBy(linkText ="implement linked list in python")
	WebElement implement_linked_List_in_Python;

	@FindBy(linkText ="Traversal")
	WebElement traversal;

	@FindBy(linkText ="Insertion")
	WebElement insertion;

	@FindBy(linkText ="Deletion")
	WebElement deletion;

	@FindBy(xpath="//a[text()='Try here>>>']")
	WebElement tryHere;
	
	@FindBy(xpath ="//button[text()='Run']")
	WebElement runButton;

	@FindBy(xpath = "//*[@id='output']")
	WebElement txt_output;
	String actualTitle;
  
	
	
	
	public Object navigateLinkedListPage;

	
	public void ClickLinkedListLink(String linkName) {
		driver.findElement(By.linkText(linkName)).click();
	}
	
	public void ClickIntroduction() {
		introduction.click();
	}

	public void ClickCreatinLinkedList() {
		creating_linked_List.click();
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

	public String RunButtonText() {
		runButton.click();
		return (runButton.getText());
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

	public void navigateLinkedListPage() {
		// TODO Auto-generated method stub
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/");
	}

	public void PageIntroduction() {
		
		// TODO Auto-generated method stub
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/introduction/");
		
	}

	public void navigateEditorPage() {
		// TODO Auto-generated method stub
		driver.navigate().to("https://dsportalapp.herokuapp.com/tryEditor/");
	}


	public void ClickCreatingLinkedList() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/creating-linked-list/");
	}

	public void clickTypesOfLinkedList() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/types-of-linked-list/");			
	}	
	
	public void navigateTypesOfLinkedListPage() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/types-of-linked-list/");			
	}
		
	public void clickImplementOfLinkedList() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/implement-linked-list-in-python/");			
	}	
	
	public void navigateImplementOfLinkedListPage() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/implement-linked-list-in-python/");			
	}	
	
	public void clickTraversalOfLinkedList() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/traversal/");			
	}
	
	public void navigateTraversalOfLinkedListPage() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/traversal/");			
	}	
	
	public void clickInsertionOfLinkedList() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/insertion-in-linked-list/");			
	}	
	public void navigateInsertionOfLinkedListPage() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/insertion-in-linked-list/");			
	}
	
	public void clickDeletionOfLinkedList() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/deletion-in-linked-list/");			
	}	
	public void navigateDeletionOfLinkedListPage() {
		driver.navigate().to("https://dsportalapp.herokuapp.com/linked-list/deletion-in-linked-list/");			
	}
	
	
	
	
	
	
	
	
		
	}

