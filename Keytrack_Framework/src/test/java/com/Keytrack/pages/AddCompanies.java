package com.Keytrack.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	public void AddingCompany() throws InterruptedException
	{
	  Add_Companies_Button.click();
	  
	  Companies_Searchbox.sendKeys("Microsoft");
	  
	  Thread.sleep(3000);
	  
	  List<WebElement> items = driver.findElements(By.xpath("/html/body/div[6]/div/ul/li[1]"));	
  	
  	  for (int i=0;i<items.size();i++)
  	  {
  		
  	  WebElement options = items.get(i);
  	
  	  String innerhtml = options.getText();
  	
      System.out.println(innerhtml);
      
      if (innerhtml.contentEquals("Microsoft"))
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
}
