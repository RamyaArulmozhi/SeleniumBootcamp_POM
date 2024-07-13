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
		
		browserInstantiate();
		
		browserMaximize();
		
		implicitWait(20);
		
		goToUrl("https://login.salesforce.com/");
	}

	
	@BeforeMethod
    public void preCondition(Object[] testArgs) throws InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		
        
        String uname = (String) testArgs[0];
        String pwd = (String) testArgs[1];
        
       lp.enterUsername(uname);
       
       lp.enterPassword(pwd);
       
       SalesForceHomePage salesforceHome = lp.clickLogin();
       
       salesforceHome.clickToggleBtn();
       
       salesforceHome.startAppLauncher();
       
       
	}
	
	@AfterMethod
	public void postCondition()
	{
		LogoutPage logOut=new LogoutPage(driver);
		
		logOut.logoutOfThePage();
	}
	
	
	
	@AfterClass
	public void closeApp()
	{
		closeWindow();
	}

}
