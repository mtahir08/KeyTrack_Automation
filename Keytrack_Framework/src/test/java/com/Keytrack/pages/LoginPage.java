package com.Keytrack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(id  = "1-email") WebElement uname;
	@FindBy(name = "password") WebElement pass;
	@FindBy(name = "submit") WebElement Login_button;
	
	
	public void logintoKeyTrack(String username, String password) throws InterruptedException
	{
		
		uname.sendKeys(username);
		
		pass.sendKeys(password);
		
		Login_button.click();
		
		String expected_title = "Keytrack";
		
		Thread.sleep(3000);
		
		String actual_title = driver.getTitle();
				
		Assert.assertEquals(expected_title, actual_title);
		
		driver.findElement(By.xpath("//div[@class='jss33']//*[local-name()='svg']")).click();

		
	}

}
