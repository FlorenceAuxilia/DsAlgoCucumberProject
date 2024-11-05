package com.dsalgo.utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.dsalgo.DriverManager.DriverFactory;
import com.dsalgo.pom.DSAlgoCommonPom;
import com.dsalgo.stepdefinition.DSAlgoStack_SD;
import com.dsalgo.stepdefinition.DSAlgoQueue_SD;


public class ConfigReader {
	public static final Logger LOGGER = LogManager.getLogger(ConfigReader.class);
	public static DriverFactory driverfactory;
	private static String browserType = null;
	private static WebDriver driver;

	public static void setBrowserType(String browser) {

		browserType = browser;

	}

	public static String getBrowserType() throws Throwable {

		if (DSAlgoCommonPom.BROWSER!= null)

			return DSAlgoCommonPom.BROWSER;

		else

			throw new RuntimeException("browser not specified in the testng.xml");

	}
	
	public static String getUsername() throws Throwable {

		if (DSAlgoCommonPom.USERNAME!= null)

			return DSAlgoCommonPom.USERNAME;

		else

			throw new RuntimeException("browser not specified in the testng.xml");

	}
	public static String getPassword() throws Throwable {

		if (DSAlgoCommonPom.PASSWORD!= null)

			return DSAlgoCommonPom.PASSWORD;

		else

			throw new RuntimeException("browser not specified in the testng.xml");

	}
	public static String getUrl() throws Throwable {

		if (DSAlgoCommonPom.APP_URL!= null)

			return DSAlgoCommonPom.APP_URL;

		else

			throw new RuntimeException("browser not specified in the testng.xml");

	}
	
	public  void loadProperties()
	{
		System.out.println("I am inside load properties of Propertiesconfig");
		Properties properties = new Properties();
		FileInputStream fis =null;
		try {

			//properties.load(getClass().getResourceAsStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Utlils\\config.properties"));
			fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Utlils\\config.properties");
			properties=new Properties();
			properties.load(fis);
			fis.close();
			
			String browser=properties.getProperty("browser");
			System.out.println("Browser "+browser);
			LOGGER.info ("get Property Browser");
			driverfactory = new DriverFactory();
			driverfactory.launchBrowser(browser);
			driver=driverfactory.getDriver();
			LOGGER.info ("initializeDrivers for " + browser);
			DSAlgoCommonPom.BROWSER=properties.getProperty("browser"); // set values of browser from cross browser test runner
			DSAlgoCommonPom.APP_URL=properties.getProperty("appURL");
			DSAlgoCommonPom.USERNAME=properties.getProperty("username");
			DSAlgoCommonPom.PASSWORD=properties.getProperty("password");
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		
		DSAlgoCommonPom.EXECUTION_ENVIRONMENT=properties.getProperty("execution_env");
		DSAlgoCommonPom.OS_TYPE=properties.getProperty("os");

	}

	public void setPropertiesforCrossbrowsertesting(String browser) {
		
		System.out.println("I am inside cross browser testing load properties of Propertiesconfig");
		Properties properties = new Properties();
		FileInputStream fis =null;
		try {

			//properties.load(getClass().getResourceAsStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Utlils\\config.properties"));
			fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Utlils\\config.properties");
			properties=new Properties();
			properties.load(fis);
			fis.close();
			
			String browser1=properties.getProperty("browser");
			System.out.println("Browser "+browser1);
			LOGGER.info ("get Property Browser");
			driverfactory = new DriverFactory();
			driverfactory.launchBrowser(browser);
			driver=driverfactory.getDriver();
			LOGGER.info ("initializeDrivers for " + browser1);
			DSAlgoCommonPom.BROWSER=properties.getProperty("browser"); // set values of browser from cross browser test runner
			DSAlgoCommonPom.APP_URL=properties.getProperty("appURL");
			DSAlgoCommonPom.USERNAME=properties.getProperty("username");
			DSAlgoCommonPom.PASSWORD=properties.getProperty("password");
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		
		
		DSAlgoCommonPom.EXECUTION_ENVIRONMENT=properties.getProperty("execution_env");
		DSAlgoCommonPom.OS_TYPE=properties.getProperty("os");
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		ConfigReader.driver = driver;
	}
	
	public static void initElements() {

		PageFactory.initElements(DriverFactory.getDriver(), DSAlgoStack_SD.class);
}

