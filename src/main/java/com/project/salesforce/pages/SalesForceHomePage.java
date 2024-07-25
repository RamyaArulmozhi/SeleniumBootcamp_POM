package com.project.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.salesforce.ProjectSpecificMethod;

public class SalesForceHomePage extends ProjectSpecificMethod {
	
	public SalesForceHomePage(WebDriver driverObj)
	{
		driver=driverObj;
	}
	
	public SalesForceHomePage clickToggleBtn()
	{
		WebElement toggleElement= getElementByXPath("//div[@class='slds-icon-waffle']");
		
		click(toggleElement);
		
		WebElement viewAllElement = getElementByXPath("//button[@aria-label='View All Applications']");
		
		click(viewAllElement);
		
		return this;
	}
	
	public OpportunityPage startAppLauncher()
	{
		WebElement applaunchElement = getElementByXPath("//input[@placeholder='Search apps or items...']");
		
		sendKeys(applaunchElement, "Sales");
		
		WebElement salesElement = getElementByXPath("//p[text()='Manage your sales process with accounts, leads, opportunities, and more']");
		
		click(salesElement);
		
		OpportunityPage op=new OpportunityPage(driver);
		
		return op;
		
	}

}
