package com.project.salesforce.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.salesforce.pages.OpportunityPage;

public class TC004_CreateOpportunityWithoutMandatoryFields extends OpportunityPage {
	
	@Test(dataProvider="loginCredentials")
	public void createWithoutMandatoryFields(String uname, String pwd)
	{
		clickOpportunity();
		
		clickNewBtn();
		
		String tomoDate = getDate(1);
		
		setClosedDate(tomoDate);
		
		saveOpportunity();
		
		boolean verifyErrorPopUp = verifyErrorPopUp();
		
		Assert.assertTrue(verifyErrorPopUp);
		
		boolean verifyMandatoryFieldHeaderMsg = verifyMandatoryFieldHeaderMsg();
		
		Assert.assertTrue(verifyMandatoryFieldHeaderMsg);
		
		boolean verifyMandatoryFieldErrorMessge = verifyMandatoryFieldErrorMessge();
		
		Assert.assertTrue(verifyMandatoryFieldErrorMessge);
		
		System.out.println("Complete this field message is displayed for Name and Stage");
		
		closeNewWindow();
		
		
	}

}
