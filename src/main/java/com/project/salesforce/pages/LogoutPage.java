package com.project.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.salesforce.ProjectSpecificMethod;

public class LogoutPage extends ProjectSpecificMethod {
	
	public LogoutPage(WebDriver driverObj)
	{
		driver=driverObj;
	}
	
	public void logoutOfThePage()
	{
		WebElement previouslogoutElement = getElementByXPath("//button[@class='slds-button branding-userProfile-button slds-button slds-global-actions__avatar slds-global-actions__item-action']");
		
		click(previouslogoutElement);
		
		WebElement logoutElement = getElementByXPath("//a[text()='Log Out']");
		
		click(logoutElement);
	}

}
