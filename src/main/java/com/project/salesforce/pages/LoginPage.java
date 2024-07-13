package com.project.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.salesforce.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod {
	
	public LoginPage(WebDriver driverObj)
	{
		driver=driverObj;
	}
	
	public void enterUsername(String uname)
	{
		WebElement usernameEle = getElementById("username");
		
		sendKeys(usernameEle,uname);
	}
	
	public void enterPassword(String pwd)
	{
		WebElement passwordEle = getElementById("password");
		
		sendKeys(passwordEle,pwd);
	}
	
	public SalesForceHomePage clickLogin()
	{
		WebElement loginEle = getElementById("Login");
		
		click(loginEle);
		
		SalesForceHomePage sfhp=new SalesForceHomePage(driver);
		
		return sfhp;
	}

}
