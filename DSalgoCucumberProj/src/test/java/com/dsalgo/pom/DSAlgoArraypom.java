package com.dsalgo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DSAlgoArraypom {
	WebDriver driver;
	public DSAlgoArraypom (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
