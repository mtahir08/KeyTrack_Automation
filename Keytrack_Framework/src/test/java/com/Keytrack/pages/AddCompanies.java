package com.Keytrack.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class AddCompanies {

	
WebDriver driver;
	
	public AddCompanies(WebDriver ndriver)
	{
		this.driver=ndriver;
	}
	
	@FindBy(xpath  = "/html/body/div[1]/div/div/div/div/ul[1]/div[6]") WebElement Add_Companies_Button;
	@FindBy(id  = "free-solo-2-demo") WebElement Companies_Searchbox;
	@FindBy(xpath = "//body/div[@id='root']/div/main/div/div/div/div/div/button/span[1]") WebElement Add_Button;
	@FindBy(xpath = "//*[contains(text(),'Company successfully created!')]") WebElement Toast_Message;
	@FindBy(xpath  = "//span[contains(text(),'Companies')]") WebElement Companies_dropdown;
	
	public void AddingCompany() throws InterruptedException
	{
	  Add_Companies_Button.click();
	  
	  Companies_Searchbox.sendKeys("Zoom");
	  
	  Thread.sleep(3000);
	  
	  List<WebElement> items = driver.findElements(By.xpath("/html/body/div[6]/div/ul/li[1]"));	
  	
  	  for (int i=0;i<items.size();i++)
  	  {
  		
  	  WebElement options = items.get(i);
  	
  	  String innerhtml = options.getText();
  	
      System.out.println(innerhtml);
      
      if (innerhtml.contentEquals("Zoom"))
		{
			options.click();
			Thread.sleep(4000);
		}

  	 }
  	  
  	  Add_Button.click();
  	  Thread.sleep(2000);
  	//  String actual_message = Toast_Message.getText();
  	  
  	  Thread.sleep(3000);
  	  
  	//  String expected_message = "Company successfully created!";
  	  
  	 // Assert.assertEquals(expected_message, actual_message);
  	  
	}
	
	public void Verify_Company_In_SideBar() throws InterruptedException
	{
		
		List<WebElement> items = driver.findElements(By.xpath("//body/div[@id='root']/div/div/div/div/ul[2]/div"));
		
		for (int a=0;a<items.size();a++)
	  	  {
			
			// int b = items.size();
			
			 WebElement options = items.get(a);
			 
			 // For scrolling companies in side bar.
			 Actions action = new Actions(driver); 
			 action. moveToElement(options). perform();
			 
		  	  String innerhtml = options.getText();
		  	  		  	  
		  	  // Verifying the last company of the side menu
		  	  if (a == items.size()-1 && innerhtml.contentEquals("Zoom"))
		  	  {
		  		  Thread.sleep(2000);
		  		  String Actual_Result = innerhtml;
		  		  String Expected_Result = "Zoom";
		  		  
		  		Assert.assertEquals(Expected_Result, Actual_Result);
		  	  }
	  	  }
		
	}
	
	public void Verify_Company_In_Company_Dropdown() throws InterruptedException
	{
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Companies_dropdown);
		
		List <WebElement> items = driver.findElements(By.xpath("/html[1]/body[1]/div[3]/div[3]/ul[1]/li"));
		 
		 for (int i =0 ; i<items.size() ;i++)
		 {
		
			 WebElement options = items.get(i);
		
		  // For scrolling companies in company drop down.
		     Actions action = new Actions(driver); 
		     action. moveToElement(options). perform();
			  	
		  	 String innerhtml = options.getText();
		  	 
		  	 if (i == items.size()-1 && innerhtml.contentEquals("Zoom"))
		  	  {
		  		  Thread.sleep(2000);
		  		  String Actual_Result = innerhtml;
		  		  String Expected_Result = "Zoom";
		  		  
		  		Assert.assertEquals(Expected_Result, Actual_Result);
		  	  }
		 }
		 //To close companies drop down
		 Actions action = new Actions(driver);
	     action.moveToElement(Companies_dropdown).click().perform();
	}
}
