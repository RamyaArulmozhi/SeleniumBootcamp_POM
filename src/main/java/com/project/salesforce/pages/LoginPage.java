package com.project.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.salesforce.ProjectSpecificMethod;

public class LoginPage extends ProjectSpecificMethod {
	
	public LoginPage(WebDriver driverObj)
	{
		driver=driverObj;
	}
	
	public LoginPage enterUsername(String uname)
	{
		WebElement usernameEle = getElementById("username");
		
		sendKeys(usernameEle,uname);
		
		return this;
	}
	
	public LoginPage enterPassword(String pwd)
	{
		WebElement passwordEle = getElementById("password");
		
		sendKeys(passwordEle,pwd);
		
		return this;
	}
	
	public SalesForceHomePage clickLogin()
	{
		WebElement loginEle = getElementById("Login");
		
		click(loginEle);
		
		return new SalesForceHomePage(driver);
	}

}
