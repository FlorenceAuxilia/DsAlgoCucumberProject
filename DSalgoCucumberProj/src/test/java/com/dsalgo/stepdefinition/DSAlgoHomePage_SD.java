package com.dsalgo.stepdefinition;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.dsalgo.pom.DSAlgoHomePom;
import com.dsalgo.DriverManager.DriverFactory;
import com.dsalgo.pom.DSAlgoGetStartedPom;
import com.dsalgo.pom.DSAlgoSignInPom;
import com.dsalgo.pom.DSAlgoStackPom;
import com.dsalgo.utility.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSAlgoHomePage_SD extends DSAlgoCommon_SD{

	WebDriver driver;
	ConfigReader config =new ConfigReader();
	Actions act;	
	@Before("@Home_sucesslogin")
	public void setUP() throws Throwable
	{
		config.loadProperties();
		String browser=config.getBrowserType();
		DriverFactory.launchBrowser(browser);
		ConfigReader.initElements();

		driver=DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    act=new Actions(driver);
	    getstartedpage_obj=new DSAlgoGetStartedPom(DriverFactory.getDriver());
	    driver.get(config.getUrl());
	    getstartedpage_obj.clickGetStarted();
	    homepage_obj=new DSAlgoHomePom(driver);
	    homepage_obj.click_Signin();   
	    signinpage_obj=new DSAlgoSignInPom(driver);
	    signinpage_obj.setUserName(config.getUsername());
	    signinpage_obj.setPassword(config.getPassword());
	    signinpage_obj.clickLogin();
	    stakpage_obj=new DSAlgoStackPom(driver);
	   
	}
	
	
	@Given("The user enters home page")
	public void the_user_enters_home_page() {
		if(driver.getTitle().equals("NumpyNinja"))
		{
			Assert.assertTrue(true);
		}
	}
	
	
	@When("The user selects the Getting Started button in Stack Panel")
	public void the_user_selects_the_getting_started_button_in_stack_panel() {
		homepage_obj.click_select_stack();
	}
	
	
	@Then("The user will be directed to {string} Page")
	public void the_user_will_be_directed_to_page(String string) {
		Assert.assertEquals(driver.getTitle(), string);
	}
	
	@When("The user selects Stack option in the dropdown")
	public void the_user_selects_stack_option_in_the_dropdown() {
		homepage_obj.click_select_stack_options();
	}
	
	@When("The user selects Getting Started button in Data Structures-Introduction panel")
	public void the_user_selects_getting_started_button_in_data_structures_introduction_panel() {
		homepage_obj.click_data_structures_introduction();
	}
	
	@When("The user selects the Getting Started button in Array Panel")
	public void the_user_selects_the_getting_started_button_in_array_panel() {
		homepage_obj.click_select_Arrays();
	}

	@When("The user selects Array option in the dropdown")
	public void the_user_selects_array_option_in_the_dropdown() {
		homepage_obj.click_select_Arrays_options();
	}
	
	
	@When("The user selects the Getting Started button in Linked List Panel")
	public void the_user_selects_the_getting_started_button_in_linked_list_panel() {
		homepage_obj.click_select_Linked_List();
	}

	@When("The user selects Linked List option in the dropdown")
	public void the_user_selects_linked_list_option_in_the_dropdown() {
		homepage_obj.click_select_Linked_List_options();
	}

	@When("The user selects the Getting Started button in Graph Panel")
	public void the_user_selects_the_getting_started_button_in_graph_panel() {
		homepage_obj.click_select_Graph();
	}

	@When("The user selects Graph option in the dropdown")
	public void the_user_selects_graph_option_in_the_dropdown() {
		homepage_obj.click_select_Graph_options();
	}

	@When("The user selects the Getting Started button in Tree Panel")
	public void the_user_selects_the_getting_started_button_in_tree_panel() {
		homepage_obj.click_select_Tree();
	}

	@When("The user selects Tree option in the dropdown")
	public void the_user_selects_tree_option_in_the_dropdown() {
		homepage_obj.click_select_Tree_options();
	}

	@When("The user selects the Getting Started button in Queue Panel")
	public void the_user_selects_the_getting_started_button_in_queue_panel() {
		homepage_obj.click_select_Queue();
	}

	@When("The user selects Queue option in the dropdown")
	public void the_user_selects_queue_option_in_the_dropdown() {
		homepage_obj.click_select_Queue_options();
	}
	
	@After("@Home_sucesslogin")
	public void tearDown() {
	    driver.close();
	}
	
	@Before("@Home_unsucesslogin")
	public void setup() throws Throwable
	{
		config.loadProperties();
		String browser=config.getBrowserType();
		DriverFactory.launchBrowser(browser);
		ConfigReader.initElements();

		driver=DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    act=new Actions(driver);
	    getstartedpage_obj=new DSAlgoGetStartedPom(DriverFactory.getDriver());
	    driver.get(config.getUrl());
	    getstartedpage_obj.clickGetStarted();
	    homepage_obj=new DSAlgoHomePom(driver);
	   
	}
	
	@Then("The user will be get popup to login")
	public void the_user_will_be_get_popup_to_login() {
	    if(homepage_obj.get_popup_not_logged().equals("You are not logged in"))
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }

	}
	@After("@Home_unsucesslogin")
	public void teardown() {
	    driver.close();
	}
	
//datastructure dropdown
	

@When("The user clicks Data structure drop down at top")
public void the_user_clicks_data_structure_drop_down_at_top() {
	homepage_obj.click_select_dropdown();
}

@Then("The user will get six options")
public void the_user_will_get_six_options() {
	String expoptions[]= {"Arrays","Linked List","Stack","Queue","Tree","Graph"};
    List <WebElement> op=homepage_obj.get_dropdown_options();
    for(int i=0;i<op.size();i++)
    {
    	
    	Assert.assertEquals(op.get(i).getText(), expoptions[i]);//actual options
    }
}

//register signin validation

@When("The user clicks Sign in link")
public void the_user_clicks_sign_in_link() {
	homepage_obj.click_Signin();
}

@Then("The user will be directed to login page")
public void the_user_will_be_directed_to_login_page() {
    String s=driver.getTitle();
    String title = "";
    
    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        // Checking whether is white space or not
        if (!Character.isWhitespace(ch)) {
        	title += ch;
        }
    }
    
    Assert.assertEquals(title,"Login");
}

@Then("The user will be directed to register page")
public void the_user_will_be_directed_to_register_page() {
	String s=driver.getTitle();
    String title = "";
    
    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        // Checking whether is white space or not
        if (!Character.isWhitespace(ch)) {
        	title += ch;
        }
    }
    
    Assert.assertEquals(title,"Registration");
}

@When("The user clicks Register in link")
public void the_user_clicks_register_in_link() {
	homepage_obj.click_Register();
}

//sign out
@When("The user clicks Sign out link")
public void the_user_clicks_sign_out_link() {
	homepage_obj.click_Signout();    
}

@Then("The user will be get popup logged out")
public void the_user_will_be_get_popup_logged_out() {
	if(homepage_obj.LogoutMsg().equals("Logged out successfully"))
    {
    	Assert.assertTrue(true);
    }
    else
    {
    	Assert.assertTrue(false);
    }
}
	
}
