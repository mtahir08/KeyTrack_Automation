package com.Keytrack.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.Keytrack.utility.BrowserFactory;
import com.Keytrack.utility.ConfigDataProvider;
import com.Keytrack.utility.ExcelDataProvider;


public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;

	@BeforeSuite
	public void setUpSuite()
	{
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
	}
	
	@BeforeClass
	public void setup() 
	{
		driver = BrowserFactory.startApplication(driver,config.getBrowser(),config.getqaURL());
	}
	
	@AfterClass
	public void teardown()
	{
		
	BrowserFactory.quitBrowser(driver);
	
	}
	
}
