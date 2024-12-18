
package com.dsalgo.DriverManager;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.*;

import com.dsalgo.pom.DSAlgoCommonPom;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {
	
	public static   ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	//public static WebDriver driver1;
	private static final Logger LOGGER = LogManager.getLogger(DriverFactory.class);
	public static ChromeOptions co = new ChromeOptions();
	public static EdgeOptions eo=new EdgeOptions();


	@BeforeTest
	public static void launchBrowser(String browser)
	{
		try {
			switch(DSAlgoCommonPom.BROWSER) {
			case"chrome":	
				System.out.println("I am inside chrome driver switch case");
				LOGGER.info("Launching "+ DSAlgoCommonPom.BROWSER);
				co.setPageLoadStrategy(PageLoadStrategy.EAGER);
				driver.set(new ChromeDriver(co));
				break;
			case"firefox":
				LOGGER.info("Launching "+ DSAlgoCommonPom.BROWSER);
				driver.set(ThreadGuard.protect(new FirefoxDriver()));
				break;
			case"edge":
				System.out.println("I am inside edge switch case");
				LOGGER.info("Launching "+ DSAlgoCommonPom.BROWSER);
				eo.setPageLoadStrategy(PageLoadStrategy.EAGER);
				driver.set(ThreadGuard.protect(new EdgeDriver(eo)));
				System.out.println("I have set driver value");
				break;
			case"ie":
				LOGGER.info("Launching "+ DSAlgoCommonPom.BROWSER);
				driver.set(ThreadGuard.protect(new InternetExplorerDriver()));
				break;
			default:
				LOGGER.info("Launching "+ DSAlgoCommonPom.BROWSER);
				driver.set(ThreadGuard.protect(new ChromeDriver()));
				break;
				}
			
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
	}

	public static WebDriver getDriver() {
		//System.out.println("I am insidegetdrivermethod");
		return driver.get();
	}

	@AfterTest
	public void  CloseBrowser() {
		//System.out.println("I am CloseBrowser");
		 driver.get().close();
		 driver.remove();
	}
}
