package com.Keytrack.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;


public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver ndriver)
	{
		this.driver=ndriver;
	}
	
	@FindBy(xpath  = "//span[contains(text(),'Organisation Settings')]") WebElement Organization_setting_dropdown;
	@FindBy(xpath  = "//span[contains(text(),'Companies')]") WebElement Companies_dropdown;
	@FindBy(xpath = "//span[contains(text(),'Portfolios')]") WebElement Portfolios_dropdown;

	
	public void Checking_items_of_Organizationsettingdropdown() throws InterruptedException
	{
		//Actions act =  new Actions(driver);
		//act.moveToElement(Organization_setting_dropdown).click().perform();
		
		Organization_setting_dropdown.click();
		System.out.println("Successfuly clicked on organization setting dropdown");
		Thread.sleep(3000);
		
		List<WebElement> items = driver.findElements(By.xpath("/html[1]/body[1]/div[2]/div[3]/ul[1]/li"));	
    	
    	for (int i=0;i<items.size();i++)
    	{
    		
    	WebElement options = items.get(i);
    	
    	String innerhtml = options.getText();
    	
		System.out.println(innerhtml);

		
		if (innerhtml.contentEquals("Users & Access"))
		{
			String actual_item1 = innerhtml;
			String expected_item1 = "Users & Access";
			Assert.assertEquals(expected_item1, actual_item1);
		}
		else if (innerhtml.contentEquals("Add Organization"))
		{
			String actual_item2 = innerhtml;
            String expected_item2 = "Add Organization";
			
			Assert.assertEquals(expected_item2, actual_item2);
		}
    
		else if (innerhtml.contentEquals("Organisation Settings"))
		{
			String actual_item3 = innerhtml;
            String expected_item3 = "Organisation Settings";
			
			Assert.assertEquals(expected_item3, actual_item3);
		}
    	}
    	
    	//To close Organization_setting_dropdown
    	Actions action = new Actions(driver);
    	action.moveToElement(Organization_setting_dropdown).click().perform();
	}

	
	public void Checking_items_of_Companiesdropdown() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Companies_dropdown);
		
		System.out.println("Successfuly clicked on companies dropdown");
		Thread.sleep(3000);
		
		List<WebElement> items = driver.findElements(By.xpath("/html[1]/body[1]/div[3]/div[3]/ul[1]/li/div[1]"));
    	
    	for (int i=0;i<items.size();i++)
    	{
    	WebElement options = items.get(i);
    	
    	String innerhtml = options.getText();
    	
		System.out.println(innerhtml);
		
		if (innerhtml.contentEquals("Add Companies"))
		{
			String actual_item1 = innerhtml;
			String expected_item1 = "Add Companies";
			
			Assert.assertEquals(expected_item1, actual_item1);
		}
		else if (innerhtml.contentEquals("Manage Companies"))
		{
			String actual_item2 = innerhtml;
            String expected_item2 = "Manage Companies";
			
			Assert.assertEquals(expected_item2, actual_item2);
		}
    
    	}
    	//to close companies dropdown
		
    	Actions action = new Actions(driver);
    	action.moveToElement(Companies_dropdown).click().perform();	
	}

	
	public void Checking_items_of_Portfoliosdropdown() throws InterruptedException
	{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Portfolios_dropdown);
		
		System.out.println("Successfuly clicked on portfolios dropdown");
		Thread.sleep(3000);
		
		List<WebElement> items = driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[3]/ul[1]/li/div[1]"));
    	
    	for (int i=0;i<items.size();i++)
    	{
    	WebElement options = items.get(i);
    	
    	String innerhtml = options.getText();
    	
		System.out.println(innerhtml);

		if (innerhtml.contentEquals("Manage Portfolios"))
		{
			String actual_item1 = innerhtml;
			String expected_item1 = "Manage Portfolios";
			
			Assert.assertEquals(expected_item1, actual_item1);
		}
    
    	}
    	//to close portfolios dropdown
    	Actions action = new Actions(driver);
    	action.moveToElement(Portfolios_dropdown).click().perform();	

	}
	
	
}
