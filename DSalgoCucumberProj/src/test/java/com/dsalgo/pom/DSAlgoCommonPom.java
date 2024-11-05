package com.dsalgo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DSAlgoCommonPom {
	public WebDriver driver;
	
	public static String APP_URL;
	public static String BROWSER;
	public static String OS_TYPE;
	public static String EXECUTION_ENVIRONMENT;
	
	//Values assigned from  Excel reader class
	
	public static String USERNAME;
	public static String PASSWORD;
	public static String PYTHON_EDITOR_INPUT;
	public static String PYTHON_EDITOR_OUTPUT;
	
	public DSAlgoCommonPom(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}