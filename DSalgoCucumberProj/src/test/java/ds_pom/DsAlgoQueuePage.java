package ds_pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class DsAlgoQueuePage extends DsAlgoBasePage{
	
	//private WebDriver driver;
	
	public DsAlgoQueuePage(WebDriver driver){
		super(driver);
	}
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	 By implementation_in_Python =By.linkText("Implementation of Queue in Python");
	 By implementation_using_collections =By.linkText("Implementation using collections.deque");
	 By imp_array=By.linkText("Implementation using array");
	 By queue_operations =By.linkText("Queue Operations");
	 //By tryHere =By.xpath("//a[text()='Try here>>>']");
	 @FindBy(xpath="//a[text()='Try here>>>']")
		WebElement tryHere;
	By runButton=By.xpath("//button[text()='Run']");
	
	String actualTitle;
	
	
	
	public void ClickImpQueuePython()
	{
		driver.findElement(implementation_in_Python).click();
	}
	
	public void ClickImpCollections()
	{
		driver.findElement(implementation_using_collections).click();
	}
	
	public void ClickImpArray()
	{
		driver.findElement(imp_array).click();
	}
	
	public void ClickImpQueueOperations()
	{
		driver.findElement(queue_operations).click();
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
	
	public void click_tryHere()
	{
		js.executeScript("arguments[0].scrollIntoView();", tryHere);
		tryHere.click();
		
	}
	
	
	public String runButtonText()
	{
		driver.findElement(runButton).click();
		return (driver.findElement(runButton).getText());
	}
	
	
	

}
