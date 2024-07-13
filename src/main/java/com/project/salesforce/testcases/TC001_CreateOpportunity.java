package com.project.salesforce.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.project.salesforce.pages.OpportunityPage;

public class TC001_CreateOpportunity extends OpportunityPage {
	
	
	@Test(dataProvider = "loginCredentials")
	public void createOpportunity(String uname, String pwd)
	{
		
		clickOpportunity();
		
		clickNewBtn();
		
		enterOpportunityName("Salesforce Automation by Ramya A");
		
		String oppName= getOpportunityName();
		
		String todayDate = getDate(0);
		
		setClosedDate(todayDate);
		
		setStage("Needs Analysis");
		
		saveOpportunity();
		
		String toastMessageText = getToastMessage();
		
		String extractOppNameFromToastMsgValue= extractOppNameFromToastMsg(toastMessageText);
		
		Assert.assertEquals(extractOppNameFromToastMsgValue, oppName);
		
		System.out.println("Verified Opportunity Name, Opportunity Name matches with the Toast created");
				
		//Expected Result:New Opportunity should be created with name as  'Salesforce Automation by Your Name'
				
		System.out.println("New Opportunity is created as "+toastMessageText+ " "+"as expected");
		
		
	}

}
