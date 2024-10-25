package ds_pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class DsAlgoLoginPage extends DsAlgoBasePage {
	
	public DsAlgoLoginPage(WebDriver driver) {
			super(driver);
			}

	

	
	By username=By.id("id_username");
	By password=By.id("id_password");
	By loginButton =By.xpath("//input[@value='Login']");
	By registerButton =By.xpath("//a[text()='Register!']");
	
	
		
	
	
	public DsAlgoLoginPage enterUsername(String uname) {
		
	driver.findElement(username).sendKeys(uname);
	return this;
	}
	
	
	public void enterPassword(String pasword) {
		driver.findElement(password).sendKeys(pasword);
		
		}
	public void Clciklogin() {
		driver.findElement(loginButton).click();
		
		}
	
	
	public void loginValidUser(String uname ,String passwd)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(passwd);
		driver.findElement(loginButton).click();
	}


	public DsAlgoLoginPage verifyPage(String title) {
		// TODO Auto-generated method stub
		actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, title);
		return this;
	}
	



	public void clickRegister() {
		// TODO Auto-generated method stub
		driver.findElement(registerButton).click();
	}



	
//
//	@FindBy(xpath="//input[@id='id_username']")
//	WebElement txt_username;
//	
//	@FindBy(xpath="//input[@id='id_password']")
//	WebElement txt_password;
//	
//	@FindBy(xpath="//input[@value='Login']")
//	WebElement btn_login;
//	
//	@FindBy(xpath="//a[text()='Register!']")
//	WebElement lnk_Register;
//	
//			
//	public void setUserName(String name) {
//		txt_username.sendKeys(name);
//	}
//	public void setPassword(String pwd) {
//		txt_password.sendKeys(pwd);
//	}
//	public void clickLogin() {
//		btn_login.click();
//	}
}
