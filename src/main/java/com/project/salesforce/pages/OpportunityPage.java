package com.project.salesforce.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.project.salesforce.ProjectSpecificMethod;

public class OpportunityPage extends ProjectSpecificMethod {
	
	String opportunityName;
	
	String opportunityStage;
	
	public OpportunityPage(WebDriver driverObj)
	{
		driver=driverObj;
	}
	
	
	
	public OpportunityPage clickOpportunity()
	{
		WebElement opportunity = getElementByXPath("//span[text()='Opportunities']");
		
		jsClick(opportunity);
		
		return this;	
		
	}
	
	public OpportunityPage clickNewBtn()
	{
		WebElement newBtnElement = getElementByXPath("//a[@title='New']");
		
		click(newBtnElement);
		
		return this;
		
	}
	
	public OpportunityPage enterOpportunityName(String opportunityName)
	{
		WebElement oppElement = getElementByXPath("//input[@name='Name']");
		
		sendKeys(oppElement, opportunityName);
		
		this.opportunityName = opportunityName;
		
		return this;
		
	}
	
	/*
	 * public OpportunityPage getOpportunityName() {
	 * 
	 * WebElement oppElement = getElementByXPath("//input[@name='Name']");
	 * 
	 * //Get the Opportunity Name Text and store it
	 * 
	 * String oppText = getValueFromInput(oppElement);
	 * 
	 * System.out.println("The expected text is " + oppText);
	 * 
	 * opportunityName=oppText;
	 * 
	 * return this; }
	 */
	
	public String getDate(int addDays)
	{
		SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar instance = Calendar.getInstance();
		
		instance.add(Calendar.DATE, addDays);
		
		String dateValue = format.format(instance.getTime());
		
		return dateValue;
		
	}
	
	public OpportunityPage setClosedDate(String date)
	{
				
		WebElement closedateEle = getElementByXPath("//input[@name='CloseDate']");
				
		sendKeys(closedateEle, date);
		
		return this;
				
	}
	
	public OpportunityPage setStage(String stageName)
	{
		//Select Stage as "Need Analysis"
		
		WebElement stageElement = getElementByXPath("//label[text()='Stage']/following-sibling::div//button");
				
		click(stageElement);
				
		WebElement ddStageElement = getElementByXPath("//span[@title='"+stageName+"']");
				
		click(ddStageElement);
		
		this.opportunityStage = stageName;
		
		return this;
	}
	
	public OpportunityPage saveOpportunity()
	{
		//Save the Opportunity created
		
		WebElement saveElement = getElementByXPath("//button[@name='SaveEdit']");
				
		click(saveElement);
		
		return this;
	}
	
	public String getToastMessage ()
	{
		//Verify the printed Toast Message
		
		//New Opportunity should be created with name as  'Salesforce Automation by Your Name'
				
		WebElement toastmsgElement = getElementByXPath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
				
		String toastText=elementgetText(toastmsgElement);
				
		System.out.println("The created message is as follows " + toastText);
		
		return toastText;
	}
	
	public String extractOppNameFromToastMsg(String toastText)
	{
	
			//Extracting the Opportunity name from the ToastMessage
	
			int beginIndex= toastText.indexOf('"') +1;
		
			int endIndex= toastText.indexOf('"', beginIndex);
		
			String subStringOppName=toastText.substring(beginIndex, endIndex);
		
			System.out.println(subStringOppName);
			
			return subStringOppName;
			
	}
	
	public OpportunityPage verifyTheOpportunityCreated(String oppName)
	{
		Assert.assertEquals(oppName, opportunityName);
		
		System.out.println("Verified Opportunity Name, Opportunity Name matches with the Toast created");
		
		return this;
				
	}
	
	public OpportunityPage SearchOpportunity(String opportunityName)
	{
		WebElement editOpp = getElementByXPath("//input[@aria-label='Search Recently Viewed list view.']");
		
		sendKeys(editOpp,opportunityName);
		
		pressEnter(editOpp);
		
		pressEnter(editOpp);
		
		return this;
		
		
	}
	
	public WebElement findRowByName(String OppName) throws InterruptedException
	{
		
		Thread.sleep(3000);
		List<WebElement> ddSearch = getElementsByXPath("//table[@aria-label='Recently Viewed']/tbody/tr");
		
		for (WebElement row : ddSearch)
		{
			WebElement rowElementName = getElementByXpath(row, "th//a");
			
			String textRowElement= elementgetText(rowElementName);
			
			if(OppName.equals(textRowElement))
			{
				return row;
			}
			
		}
		return null;
	}
	
	public OpportunityPage clickRowActionBtn(WebElement row)
	{
		List<WebElement> ddcols = getElementsByXPath(row,"td");
		
		System.out.println(ddcols.size());
		
		WebElement eleIcon = ddcols.get(ddcols.size() - 1);
		
		WebElement eleClick=getElementByXpath(eleIcon, ".//a");
		
		click(eleClick);
		
		return this;
	}
	
	public String getStageName(WebElement row)
	{
		List<WebElement> cols = getElementsByXPath(row, "td");
		
		WebElement colStage = cols.get(4);
		
		WebElement updatedStageDisp = getElementByXpath(colStage, ".//span[@class='slds-truncate']");
		
		String stageEleText = elementgetText(updatedStageDisp);
		
		return stageEleText;
		
		
	}
	
	public OpportunityPage clickRowActionBtnEdit()
	{
		WebElement editIcon = getElementByXPath("//a[@data-target-selection-name='sfdc:StandardButton.Opportunity.Edit']");
		
		click(editIcon);
		
		return this;
	}
	
	public OpportunityPage clickRowActionBtnDelete()
	{
		WebElement deleteICon = getElementByXPath("//a[@data-target-selection-name='sfdc:StandardButton.Opportunity.Delete']");
		
		click(deleteICon);
		
		return this;
		
	}
	
	public OpportunityPage confirmActionDelete()
	{
		// Delete DialogBox
		
		WebElement alertDelete = getElementByXPath("//span[text()='Delete']/parent::button");
				
		click(alertDelete);
		
		return this;
	}
	
	public OpportunityPage clearDateField()
	{
		WebElement clearDate = getElementByXPath("//input[@name='CloseDate']");
		
		clear(clearDate);
		
		return this;
	}
	
	public OpportunityPage scrollDown()
	{
		WebElement btnDel = getElementByXPath("//label[text()='Delivery/Installation Status']/following-sibling::div//button");
		
		jsScrollDown(btnDel);
		
		click(btnDel);
		
		return this;
	}
	
	public OpportunityPage setDeliveryStatus(String dlStatusName)
	{
		//Select Delivery Status In Progress //In progress
				
		WebElement dlStatus = getElementByXPath("//span[@title='"+dlStatusName+"']/ancestor::lightning-base-combobox-item");
				
		click(dlStatus);
		
		return this;
	}
	
	public OpportunityPage setDescription()
	{
		WebElement descElement = getElementByXPath("//label[text()='Description']/following-sibling::div/textarea");
		
		clear(descElement);
		
		sendKeys(descElement, "Salesforce11");
		
		return this;
	}
	
	public OpportunityPage closeNewWindow()
	{
		WebElement closeWindowElement = getElementByXPath("//span[text()='Close this window']/parent::button");
		
		click(closeWindowElement);
		
		return this;
	}
	
	public OpportunityPage verifyTheEditedOpportunityStageName(String stageName)
	{
		Assert.assertEquals(stageName, opportunityStage);
		
		System.out.println("The Stage value Perception Analysis is displayed after updating");
		
		return this;
		
	}
	
	public OpportunityPage verifyTheDeletedOpportunity(String oppName)
	{
		Assert.assertEquals(oppName, opportunityName);
		
		return this;
	}
	
	public OpportunityPage verifyErrorPopUp()
	{
		WebElement text = getElementByXPath("//header[@class='pageErrorHeader slds-popover__header']//h2");
		
		String text1 = elementgetText(text);
		
		System.out.println(text1);
		
		boolean equals1 = text1.equals("We hit a snag.");
		
		Assert.assertTrue(equals1);
		
		return this;
		
	}
	
	public OpportunityPage verifyMandatoryFieldHeaderMsg()
	{
		// Review Alert message
		
		WebElement msg1 = getElementByXPath("//div[@class='fieldLevelErrors']/div");
				
		String msgTxt = elementgetText(msg1);
				
		System.out.println(msgTxt);
		
		boolean headermsg = msgTxt.equals("Review the following fields");
		
		Assert.assertTrue(headermsg);
		
		return this;
				
	}
	
	public OpportunityPage verifyMandatoryFieldErrorMessge()
	{
		//Review Mandatory field's missing message
		
		List<WebElement> mandatorymsg = getElementsByXPath("//div[@class='fieldLevelErrors']/ul/li/a");
		
		int size = mandatorymsg.size();
		
		System.out.println(size);
		
		boolean var=true;
		
		if(size==2) {	
			
			for(WebElement ele: mandatorymsg)
			{
				
				String mandatoryFieldText = elementgetText(ele);
				
				System.out.println(mandatoryFieldText);
				
				if(!(mandatoryFieldText.equals("Opportunity Name")||mandatoryFieldText.equals("Stage")))
				{
					var=false;
				}
			}
		}
		
		else
		{
			var = false;
		}
		Assert.assertTrue(var);	
		
		
		return this;
		
}
	
	public OpportunityPage verifyTableView()
	{
		WebElement tableDisp = getElementByXPath("//button[@title='Select list display']");
		
		click(tableDisp);
		
		WebElement tableDisp2 = getElementByXPath("//a[@role='menuitemcheckbox']//span[text()='Table']");
		
		click(tableDisp2);
		
		return this;
	}
	
	public OpportunityPage sortCloseDate()
	{
		WebElement sortCD = getElementByXPath("//span[text()='Close Date']/parent::a");
		
		click(sortCD);
		
		click(sortCD);
		
		return this;
		
	}
	
	public List<Date> getCloseDateList() throws ParseException
	{
		
		List<WebElement> closeDateList = getElementsByXPath("//span[@data-aura-class='sfaOpportunityDealMotionCloseDate']/span[@class='uiOutputDate']");
		
		List<Date> cdl= new ArrayList<Date>();
		
		for(WebElement ele: closeDateList)
		{
			String elementgetText = elementgetText(ele);
			
			Date parseDate = getParseDate(elementgetText);
			
			 cdl.add(parseDate);
		}
		
		return cdl;
		
	}
	
	public Date getParseDate(String dateVal) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date parseDate = sdf.parse(dateVal);
		
		return parseDate;
	}
	
	public OpportunityPage verifySortedCloseDate(List<Date> dates)
	{
		boolean datesortcheck=true;
		   if (dates == null || dates.isEmpty()) 
		   
		   { // Empty list or null list is considered sorted
			   return this;
	        }

	        for (int i = 0; i < dates.size() - 1; i++)
	        {
	            if (dates.get(i).compareTo(dates.get(i + 1)) > 0) 
	            {
	            	System.out.println(dates.get(i));
	            	datesortcheck= false; // If any date is greater than the next, not sorted
	            	break;
	            }
	        }
	        // All dates are in sorted order
	    	Assert.assertTrue(datesortcheck);
	    	return this;
		
	}
	

	
	
}


