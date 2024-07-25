package com.project.salesforce.testcases;

import org.testng.annotations.Test;

import com.project.salesforce.ProjectSpecificMethod;
import com.project.salesforce.pages.OpportunityPage;

public class TC004_CreateOpportunityWithoutMandatoryFields extends ProjectSpecificMethod  {
	
	@Test(dataProvider="loginCredentials")
	public void createWithoutMandatoryFields(String uname, String pwd)
	{
		OpportunityPage op = new OpportunityPage(driver);
		
		op.clickOpportunity()
		
		.clickNewBtn()
		
		.setClosedDate(op.getDate(1))
		
		.saveOpportunity()
		
		.verifyErrorPopUp()
		
		.verifyMandatoryFieldHeaderMsg()
		
		.closeNewWindow();
		
	System.out.println("Complete this field message is displayed for Name and Stage");
		
		
		}

}
