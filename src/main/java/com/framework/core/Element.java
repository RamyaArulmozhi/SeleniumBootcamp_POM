package com.framework.core;


import java.util.List;

import org.openqa.selenium.WebElement;

public interface Element {
	
	WebElement getElementById(String idValue);
	
	WebElement getElementByXPath(String xpathValue);
	
	List<WebElement> getElementsByXPath(String xpathValue);
	
	List<WebElement> getElementsByXPath(WebElement ele,String xpathValue);
	
	WebElement getElementByXpath(WebElement ele, String xpathValue);
	
	void sendKeys(WebElement element, String textValue);
	
	void pressEnter(WebElement element);
	
	void click(WebElement element);
	
	void clear(WebElement element);
	
	void jsClick(WebElement element);
	
	void jsScrollDown(WebElement element);
	
	String elementgetText(WebElement element);
	
	String getValueFromInput(WebElement element);
}
