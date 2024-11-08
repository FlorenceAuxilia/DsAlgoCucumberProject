package com.dsalgo.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.When;

public class DSAlgoGraphPom extends DSAlgoCommonPom{
	
	
	public DSAlgoGraphPom(WebDriver driver){
		super(driver);
	}
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	 @FindBy(linkText="Graph")
		WebElement graph;
	 @FindBy(linkText="Graph Representations")
		WebElement graph_representations;
	 @FindBy(xpath="//a[text()='Try here>>>']")
		WebElement tryHere;
	@FindBy(xpath="//button[text()='Run']")
		WebElement runButton;
	 
	 public void ClickGraphLink(String linkName)
		{
			driver.findElement(By.linkText(linkName)).click();
		}
	 
	 public String getPageTitle() {
			// TODO Auto-generated method stub
			return (driver.getTitle());
			
			
		}
	 public void click_tryHere()
		{
			js.executeScript("arguments[0].scrollIntoView();", tryHere);
			tryHere.click();
			
		}
	 public String runButtonText()
		{
			runButton.click();
			return (runButton.getText());
		}
	 public void click_run()
		{
			runButton.click();
			
		}
	
		

}
