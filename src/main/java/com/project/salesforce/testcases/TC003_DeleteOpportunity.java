package com.project.salesforce.testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.salesforce.pages.OpportunityPage;

public class TC003_DeleteOpportunity extends OpportunityPage  {
	
	@Test(dataProvider="loginCredentials")
	public void deleteOpportunity(String uname, String pwd) throws InterruptedException
	{
		String oppName="Salesforce Automation by Ramya A";
		
		clickOpportunity();
		
		SearchOpportunity(oppName);
		
		WebElement rowName = findRowByName(oppName);
		
		clickRowActionBtn(rowName);
		
		clickRowActionBtnDelete();
		
		confirmActionDelete();
		
		String toastMsgText = getToastMessage();
		
		String extractOppNameFromToastMsgValue = extractOppNameFromToastMsg(toastMsgText);
		
		Assert.assertEquals(extractOppNameFromToastMsgValue, oppName);
		
		// Expected Result: Oppurtunity should be Successfully deleted

		System.out.println("Opportunity is Deleted Successfully");
	}

}
