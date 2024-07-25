package com.framework.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.core.Browser;
import com.framework.core.Element;


public class SeleniumBase implements Browser, Element {
	
	protected WebDriver driver;
	
	ChromeOptions option;
		
	WebDriverWait wait;
	
	Actions action;
	
	protected Properties config;
	 

	public void disableNotifications() {
		
		option=new ChromeOptions();
		
		option.addArguments("--disable-notifications");
		
	}
	
	public void loadProperties()
	{
		config=new Properties();
		
		try {
			FileInputStream fis=new FileInputStream("src/main/resources/properties/Config.properties");
			
			config.load(fis);
			
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void browserInstantiate() {
		
		String browserProperty = config.getProperty("browser");
		
		if(browserProperty.equals("chrome"))
		{
			driver= new ChromeDriver(option);
		}
		else if(browserProperty.equals("edge"))
		{
			driver=new EdgeDriver();
		}

	}

	public void browserMaximize() {
		
		driver.manage().window().maximize();
	}
   
	public void implicitWait(int seconds) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public void goToUrl(String url) {
		
		//driver.get("https://login.salesforce.com/");
		
		driver.get(url);
		
	}

	public WebElement getElementById(String idValue) {
		
		return driver.findElement(By.id(idValue));
		
	}

	public WebElement getElementByXPath(String xpathValue) {
		
		return driver.findElement(By.xpath(xpathValue));
		
		
	}

	public void sendKeys(WebElement element, String textValue) {
		
		element.sendKeys(textValue);
		
	}

	public void click(WebElement element) {
		
		element.click();
		
	}

	public void clear(WebElement element) {
		
		element.clear();
		
		
	}

	public void closeWindow() {
		
		driver.close();
		
	}

	public void quitBrowser() {
		
		driver.quit();
		
	}

	public void jsClick(WebElement element) {
		
	
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
		
	}

	public String elementgetText(WebElement element) {
		
		return element.getText();
		
	}

	public String getValueFromInput(WebElement element) {
		
		return element.getAttribute("value");
	}

	public void pressEnter(WebElement element) {
		
		element.sendKeys(Keys.ENTER);
		
	}

	public List<WebElement> getElementsByXPath(String xpathValue) {
		
		return driver.findElements(By.xpath(xpathValue));
	}

	public WebElement getElementByXpath(WebElement ele, String xpathValue) {
		
		return ele.findElement(By.xpath(xpathValue));
	}

	public List<WebElement> getElementsByXPath(WebElement ele, String xpathValue) {
		
		return ele.findElements(By.xpath(xpathValue));
	}

	public void jsScrollDown(WebElement element) {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		
	}
	
	

	
	

	
	

}
