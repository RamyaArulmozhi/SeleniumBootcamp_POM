package com.project.salesforce.testcases;


import org.testng.annotations.Test;

import com.project.salesforce.ProjectSpecificMethod;
import com.project.salesforce.pages.OpportunityPage;

public class TC001_CreateOpportunity extends ProjectSpecificMethod {
	
	
	@Test(dataProvider = "loginCredentials")
	public void createOpportunity(String uname, String pwd)
	{
		String oppName="Salesforce Automation by Ramya A";
		
		String stageName="Needs Analysis";
		
		OpportunityPage op=new OpportunityPage(driver);
		
		op.clickOpportunity()
		
		.clickNewBtn()
		
		.enterOpportunityName(oppName)
		
		 .setClosedDate(op.getDate(0))
		
		.setStage(stageName)
		
		.saveOpportunity()
		
		.verifyTheOpportunityCreated(op.extractOppNameFromToastMsg(op.getToastMessage()));
		
		//Expected Result:New Opportunity should be created with name as  'Salesforce Automation by Your Name'
				
		System.out.println("New Opportunity is created as expected");
		
		
	}

}
