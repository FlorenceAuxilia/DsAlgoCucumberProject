package com.dsalgo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DSAlgoCommonPom {
	public WebDriver driver;
	public DSAlgoCommonPom(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}


