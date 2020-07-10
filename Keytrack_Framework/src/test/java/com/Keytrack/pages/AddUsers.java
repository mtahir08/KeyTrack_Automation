package com.Keytrack.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class AddUsers {
	
WebDriver driver;
	
	public AddUsers(WebDriver ndriver)
	{
		this.driver=ndriver;
	}
	
	@FindBy(xpath  = "/html/body/div[1]/div/div/div/div/ul[1]/div[5]") WebElement AddUsers_Sidebar_Button;
	@FindBy(xpath  = "/html/body/div[1]/div/main/div[2]/div[2]/button") WebElement AddUsers_button;
	@FindBy(xpath = "//div[2]//div[1]//div[1]//div[1]//div[1]//input[1]") WebElement Email_Textbox;
	@FindBy(xpath = "//div//div//div[3]//div[1]//div[1]//div[1]//div[1]//input[1]") WebElement FirstName_Textbox;
	@FindBy(xpath = "//div[4]//div[1]//div[1]//div[1]//div[1]//input[1]") WebElement LastName_Textbox;
	@FindBy(xpath = "//body/div/div/div/div/div[7]") WebElement Add_button; 
	@FindBy(xpath = "//*[contains(text(),'User successfully added!')]") WebElement Toast_Message;

	
	public void AddingUser() throws InterruptedException
	{
	  AddUsers_Sidebar_Button.click();
	  
	  AddUsers_button.click();
	  
	  Email_Textbox.sendKeys("tahir@gmail.com");
	  FirstName_Textbox.sendKeys("Tahir");
	  LastName_Textbox.sendKeys("geek");
  	  Add_button.click();
  	
  	 // String actual_message = Toast_Message.getText();
  	 // String expected_message = "User successfully added!";
  	  
  	 // Assert.assertEquals(expected_message, actual_message);
  	  
	}
}
