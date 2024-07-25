package com.project.salesforce.testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.salesforce.ProjectSpecificMethod;
import com.project.salesforce.pages.OpportunityPage;

public class TC002_EditOpportunity extends ProjectSpecificMethod {
	
	@Test(dataProvider = "loginCredentials")
	public void editOpportunity(String uname, String pwd) throws InterruptedException
	{
		String oppName="Salesforce Automation by Ramya A";
		
		String stageupdate="Perception Analysis";
		
		String dlStatus="In progress";
		
		OpportunityPage op=new OpportunityPage(driver);
		
		op.clickOpportunity()
		
		.SearchOpportunity(oppName)
		
		.clickRowActionBtn(op.findRowByName(oppName))
		
		.clickRowActionBtnEdit()
		
		.clearDateField()
		
		.setClosedDate(op.getDate(1))
		
		.setStage(stageupdate)
		
		.scrollDown()
		
		.setDeliveryStatus(dlStatus)
		
		.setDescription()
		
		.saveOpportunity()
		
		.verifyTheEditedOpportunityStageName(op.getStageName(op.findRowByName(oppName)));
		
		// Expected Result:The Oppurtunity is Edited Successfully

		System.out.println("The Opportunity is edited Successfully");
	}

}
