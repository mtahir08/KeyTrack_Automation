package com.Keytrack.testcases;

import java.io.IOException;


import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Keytrack.pages.AddCompanies;
import com.Keytrack.pages.AddUsers;
import com.Keytrack.pages.BaseClass;
import com.Keytrack.pages.HomePage;
import com.Keytrack.pages.LoginPage;


public class SmokeTestKeytrack extends BaseClass {
			
	@Test(priority = 1)
	public void loginApp() throws IOException, ParseException, InterruptedException 
	{	
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		//Entering username & password from excel file
		loginpage.logintoKeyTrack(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
        Thread.sleep(10000);
     }
      
	@Test(priority = 2)
	public void VerifyingDropdowns() throws IOException, ParseException, InterruptedException 
	{	
		
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		
		homepage.Checking_items_of_Organizationsettingdropdown();
		homepage.Checking_items_of_Companiesdropdown();
		homepage.Checking_items_of_Portfoliosdropdown();
        	    
     }
       
	@Test(priority = 3)
	public void CreateCompanies() throws IOException, ParseException, InterruptedException 
	{	
		
		AddCompanies addcompany = PageFactory.initElements(driver, AddCompanies.class);
		
		addcompany.AddingCompany();
		addcompany.Verify_Company_In_SideBar();
		addcompany.Verify_Company_In_Company_Dropdown();
        	    
     }
	
	@Test(priority = 4)
	public void CreateUsers() throws IOException, ParseException, InterruptedException 
	{	
		
		AddUsers adduser = PageFactory.initElements(driver, AddUsers.class);
		
		adduser.AddingUser();
        	    
     }
	
	}

