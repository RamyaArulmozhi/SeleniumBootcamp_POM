package com.project.salesforce.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.project.salesforce.ProjectSpecificMethod;

public class OpportunityPage extends ProjectSpecificMethod {
	
	public OpportunityPage()
	{
		
	}
	
	public OpportunityPage(WebDriver driverObj)
	{
		driver=driverObj;
	}
	
	
	
	public void clickOpportunity()
	{
		WebElement opportunity = getElementByXPath("//span[text()='Opportunities']");
		
		jsClick(opportunity);	
		
	}
	
	public void clickNewBtn()
	{
		WebElement newBtnElement = getElementByXPath("//a[@title='New']");
		
		click(newBtnElement);
		
	}
	
	public void enterOpportunityName(String opportunityName)
	{
		WebElement oppElement = getElementByXPath("//input[@name='Name']");
		
		sendKeys(oppElement, opportunityName);
		
	}
	
	public String getOpportunityName()
	{
		WebElement oppElement = getElementByXPath("//input[@name='Name']");
		
		//Get the Opportunity Name Text and store it
		
		String oppText = getValueFromInput(oppElement);
				
		System.out.println("The expected text is " + oppText);
		
		return oppText;
	}
	
	public String getDate(int addDays)
	{
		SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar instance = Calendar.getInstance();
		
		instance.add(Calendar.DATE, addDays);
		
		String dateValue = format.format(instance.getTime());
		
		return dateValue;
		
	}
	
	public void setClosedDate(String date)
	{
				
		WebElement closedateEle = getElementByXPath("//input[@name='CloseDate']");
				
		sendKeys(closedateEle, date);
				
	}
	
	public void setStage(String stageName)
	{
		//Select Stage as "Need Analysis"
		
		WebElement stageElement = getElementByXPath("//label[text()='Stage']/following-sibling::div//button");
				
		click(stageElement);
				
		WebElement ddStageElement = getElementByXPath("//span[@title='"+stageName+"']");
				
		click(ddStageElement);
	}
	
	public void saveOpportunity()
	{
		//Save the Opportunity created
		
		WebElement saveElement = getElementByXPath("//button[@name='SaveEdit']");
				
		click(saveElement);
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
	
	public void SearchOpportunity(String opportunityName)
	{
		WebElement editOpp = getElementByXPath("//input[@aria-label='Search Recently Viewed list view.']");
		
		sendKeys(editOpp,opportunityName);
		
		pressEnter(editOpp);
		
		pressEnter(editOpp);
		
		
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
	
	public void clickRowActionBtn(WebElement row)
	{
		List<WebElement> ddcols = getElementsByXPath(row,"td");
		
		System.out.println(ddcols.size());
		
		WebElement eleIcon = ddcols.get(ddcols.size() - 1);
		
		WebElement eleClick=getElementByXpath(eleIcon, ".//a");
		
		click(eleClick);
	}
	
	public String getStageName(WebElement row)
	{
		List<WebElement> cols = getElementsByXPath(row, "td");
		
		WebElement colStage = cols.get(4);
		
		WebElement updatedStageDisp = getElementByXpath(colStage, ".//span[@class='slds-truncate']");
		
		String stageEleText = elementgetText(updatedStageDisp);
		
		return stageEleText;
		
		
	}
	
	public void clickRowActionBtnEdit()
	{
		WebElement editIcon = getElementByXPath("//a[@data-target-selection-name='sfdc:StandardButton.Opportunity.Edit']");
		
		click(editIcon);
	}
	
	public void clickRowActionBtnDelete()
	{
		WebElement deleteICon = getElementByXPath("//a[@data-target-selection-name='sfdc:StandardButton.Opportunity.Delete']");
		
		click(deleteICon);
		
	}
	
	public void confirmActionDelete()
	{
		// Delete DialogBox
		
		WebElement alertDelete = getElementByXPath("//span[text()='Delete']/parent::button");
				
		click(alertDelete);
	}
	
	public void clearDateField()
	{
		WebElement clearDate = getElementByXPath("//input[@name='CloseDate']");
		
		clear(clearDate);
	}
	
	public void scrollDown()
	{
		WebElement btnDel = getElementByXPath("//label[text()='Delivery/Installation Status']/following-sibling::div//button");
		
		jsScrollDown(btnDel);
		
		click(btnDel);
	}
	
	public void setDeliveryStatus(String dlStatusName)
	{
		//Select Delivery Status In Progress //In progress
				
		WebElement dlStatus = getElementByXPath("//span[@title='"+dlStatusName+"']/ancestor::lightning-base-combobox-item");
				
		click(dlStatus);
	}
	
	public void setDescription()
	{
		WebElement descElement = getElementByXPath("//label[text()='Description']/following-sibling::div/textarea");
		
		clear(descElement);
		
		sendKeys(descElement, "Salesforce11");
	}
	
	public void closeNewWindow()
	{
		WebElement closeWindowElement = getElementByXPath("//span[text()='Close this window']/parent::button");
		
		click(closeWindowElement);
	}
	
	public boolean verifyErrorPopUp()
	{
		WebElement text = getElementByXPath("//header[@class='pageErrorHeader slds-popover__header']//h2");
		
		String text1 = elementgetText(text);
		
		System.out.println(text1);
		
		boolean equals1 = text1.equals("We hit a snag.");
		
		return equals1;
		
	}
	
	public boolean verifyMandatoryFieldHeaderMsg()
	{
		// Review Alert message
		
		WebElement msg1 = getElementByXPath("//div[@class='fieldLevelErrors']/div");
				
		String msgTxt = elementgetText(msg1);
				
		System.out.println(msgTxt);
		
		boolean headermsg = msgTxt.equals("Review the following fields");
		
		return headermsg;
				
	}
	
	public boolean verifyMandatoryFieldErrorMessge()
	{
		//Review Mandatory field's missing message
		
		List<WebElement> mandatorymsg = getElementsByXPath("//div[@class='fieldLevelErrors']/ul/li/a");
		
		int size = mandatorymsg.size();
		
		System.out.println(size);
		
		if(size==2) {
			
			boolean var=true;
			
			for(WebElement ele: mandatorymsg)
			{
				
				String mandatoryFieldText = elementgetText(ele);
				
				if(!(mandatoryFieldText.equals("Opportunity Name")||mandatoryFieldText.equals("Stage")))
				{
					var=false;
				}
				
			} return var;
			
		}
		
		else
		{
			return false;
		}
		
}
	
	public void verifyTableView()
	{
		WebElement tableDisp = getElementByXPath("//button[@title='Select list display']");
		
		click(tableDisp);
		
		WebElement tableDisp2 = getElementByXPath("//a[@role='menuitemcheckbox']//span[text()='Table']");
		
		click(tableDisp2);
	}
	
	public void sortCloseDate()
	{
		WebElement sortCD = getElementByXPath("//span[text()='Close Date']/parent::a");
		
		click(sortCD);
		
		click(sortCD);
		
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
	
	public boolean verifySortedCloseDate(List<Date> dates)
	{
		   if (dates == null || dates.isEmpty()) {
	            return true; // Empty list or null list is considered sorted
	        }

	        for (int i = 0; i < dates.size() - 1; i++) {
	            if (dates.get(i).compareTo(dates.get(i + 1)) > 0) {
	                return false; // If any date is greater than the next, not sorted
	            }
	        }
	        return true; // All dates are in sorted order
		
	}
	
	
}


