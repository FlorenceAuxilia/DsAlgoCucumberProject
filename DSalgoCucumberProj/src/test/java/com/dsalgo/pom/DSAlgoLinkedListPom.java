package com.dsalgo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class DSAlgoLinkedListPom  extends DSAlgoCommonPom{

	public DSAlgoLinkedListPom(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	// By Introduction=By.LinkText("Introduction");
	@FindBy(linkText="Introdution")
	 WebElement Introduction;
	
	// By Creating_Linked_LIst =By.linkText("creating-linked-list");
			 @FindBy(linkText="creating-linked-list")
				WebElement creating_Linked_List;
			 
			 //By Types_of_Linked_List=By.linkText("types-of-linked-list");
			 @FindBy(linkText="types-of-linked-list")
				WebElement Types_of_linked_inked_List;
			 
			 
			 //By Implement_Linked_List_in-python("implement-linked-list-in-python");
			 @FindBy(linkText="implement-linked-list-in-python")
				WebElement Implement_Linked_List_in_Python;
			  
			 
			 	// By Traversal =By.linkText("Traversal");
				 @FindBy(linkText="Traversal")
					WebElement Traversal;
				 
					WebElement Insertion;
					// By Insertion =By.linkText("Insertion");
					 @FindBy(linkText="insertion-in-linked-list")
						WebElement insertion;
					 
						WebElement Deletion;
						// By Deletion=By.linkText("deletion-in-linked-list")
						@FindBy(linkText="deletion-in-linked-list")
							WebElement deletion;
						
						//By tryHere =By.xpath("//a[text()='Try here>>>']");
						 @FindBy(xpath="//a[text()='Try here>>>']")
							WebElement tryHere;
						 
						//By runButton=By.xpath("//button[text()='Run']");
							@FindBy(xpath="//button[text()='Run']")
							WebElement runButton;
							
							@FindBy(xpath="//*[@id='output']")
							WebElement txt_output;
							String actualTitle;

							public Object Click_LinkedListLink;

							public Object click_Deletion_link;
							
							
							public void ClickIntroductio()
							{
								Introduction.click();
							}
				
							
							public void ClickImpCollections()
							{
								creating_Linked_List.click();
							}
							
							

							public void ClickimplementLinkedListinpython()
							{
								Implement_Linked_List_in_Python.click();
							}
							

							public void ClickTraversal()
							{
								Traversal.click();
								
								
							}
							
							

							public void ClickInsertion()
							{
								Insertion.click();
								
								
								
							}
							
							public void ClickDeletiontion()
							{
								Deletion.click();
								
								
								
							}

							public void ClickQueueLink(String string)
							{
								driver.findElement(By.linkText(string)).click();
							}
							
							public void verifyQPage(String title) {
								// TODO Auto-generated method stub
								actualTitle=driver.getTitle();
								Assert.assertEquals(actualTitle, title);
								
							}
							public String getPageTitle() {
								// TODO Auto-generated method stub
								return (driver.getTitle());
								
								
							}
							
							public void click_tryHere()
							{
							runButton.click();
							}
							
							
							public void click_run()
							{
								runButton.click();
								
							}
							
							public String runButtonText()
							{
								runButton.click();
								return (runButton.getText());
							}
							
							public String text_output()
							{
								
								return txt_output.getText();
							}


							public void pythonEditor() {
								// TODO Auto-generated method stub
								
							}


							public void Click_introductionLink1(String string) {
								// TODO Auto-generated method stub
								
							}


							void Click_introductionLink(String string) {
								// TODO Auto-generated method stub
								
							}


							void Click_LinkedListLink() {
								// TODO Auto-generated method stub
								
							}


							public void regClickIntrodcution() {
								// TODO Auto-generated method stub
								
							}


							public void ClickTypesofLinkedList() {
								// TODO Auto-generated method stub
								
							}


							public void ClickTypesofLinkedLists() {
								// TODO Auto-generated method stub
								
							}

							public void navigateToTypesLinkedLists() {

								// TODO Auto-generated method stub
								
							}



							public void navigateToTraversal() {
								// TODO Auto-generated method stub
								
							}


							public void navigateToTraversal1() {
								// TODO Auto-generated method stub
								
							}


							




							public String text_output1() {
								// TODO Auto-generated method stub
								return null;
							}


							public void click_Deletion_link() {
								// TODO Auto-generated method stub
								
							}
							

					}

							
						
					 
					 
				
			 
			 
	
			 
			 
			 
			 
			 


