package ds_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class common {
	WebDriver driver;
	public common(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}


