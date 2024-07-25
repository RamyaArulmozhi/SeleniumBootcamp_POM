package com.project.salesforce.testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.salesforce.ProjectSpecificMethod;
import com.project.salesforce.pages.OpportunityPage;

public class TC003_DeleteOpportunity extends ProjectSpecificMethod  {
	
	@Test(dataProvider="loginCredentials")
	public void deleteOpportunity(String uname, String pwd) throws InterruptedException
	{
		String oppName="Salesforce Automation by Ramya A";
		
		OpportunityPage op= new OpportunityPage(driver);
		
		op.clickOpportunity()
		
		.SearchOpportunity(oppName)
		
		.clickRowActionBtn(op.findRowByName(oppName))
		
		.clickRowActionBtnDelete()
		
		.confirmActionDelete()
		
		.verifyTheDeletedOpportunity(op.extractOppNameFromToastMsg(op.getToastMessage()));
		
		// Expected Result: Oppurtunity should be Successfully deleted

		System.out.println("Opportunity is Deleted Successfully");
	}

}
