package ds_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class DsAlgoBasePage {
	
	
	
	String actualTitle;
	WebDriver driver;
	public DsAlgoBasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
}


