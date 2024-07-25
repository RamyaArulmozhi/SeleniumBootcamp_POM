package com.project.salesforce;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.framework.selenium.SeleniumBase;
import com.framework.utils.DataLibrary;
import com.project.salesforce.pages.LoginPage;
import com.project.salesforce.pages.LogoutPage;
import com.project.salesforce.pages.SalesForceHomePage;



public class ProjectSpecificMethod extends SeleniumBase {
	
	@DataProvider(name="loginCredentials")
	public Object[][] getLoginCredentialsData() throws IOException
	
	{
		return DataLibrary.readData("SalesforceCredentials");
	}
	
	
	@BeforeClass
	public void launchBrowser()
	{
		disableNotifications();
		
		loadProperties();
		
		browserInstantiate();
		
		browserMaximize();
		
		implicitWait(20);
		
		goToUrl(config.getProperty("testsiteurl"));
	}

	
	@BeforeMethod
    public void preCondition(Object[] testArgs) throws InterruptedException {
		
		String uname = (String) testArgs[0];
        String pwd = (String) testArgs[1];
        
        new LoginPage(driver)
        
       .enterUsername(uname)
       
       .enterPassword(pwd)
       
       .clickLogin()
       
      .clickToggleBtn()
       
       .startAppLauncher();
       
       
	}
	
	@AfterMethod
	public void postCondition()
	{
		new LogoutPage(driver)
		
		.logoutOfThePage();
		
	}
	
	
	
	@AfterClass
	public void closeApp()
	{
		closeWindow();
	}

}
