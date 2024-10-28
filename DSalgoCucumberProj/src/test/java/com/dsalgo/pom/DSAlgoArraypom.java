package com.dsalgo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DSAlgoArraypom {
	WebDriver driver1;
	public DSAlgoArraypom (WebDriver driver)
	{
		this.driver1 =driver;
		PageFactory.initElements(driver, this);
	}

}
