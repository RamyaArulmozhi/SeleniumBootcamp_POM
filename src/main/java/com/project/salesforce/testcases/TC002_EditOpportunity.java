package com.project.salesforce.testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.salesforce.pages.OpportunityPage;

public class TC002_EditOpportunity extends OpportunityPage {
	
	@Test(dataProvider = "loginCredentials")
	public void editOpportunity(String uname, String pwd) throws InterruptedException
	{
		String oppName="Salesforce Automation by Ramya A";
		
		String stageupdate="Perception Analysis";
		
		clickOpportunity();
		
		SearchOpportunity(oppName);
		
		
		WebElement rowName = findRowByName(oppName);
		
		clickRowActionBtn(rowName);
		
		getStageName(rowName);
		
		clickRowActionBtnEdit();
		
		clearDateField();
		
		String tomDate=getDate(1);
		
		setClosedDate(tomDate);
		
		setStage(stageupdate);
		
		scrollDown();
		
		setDeliveryStatus("In progress");
		
		setDescription();
		
		saveOpportunity();
		
		getToastMessage ();
		
		WebElement rowName2 = findRowByName(oppName);
		
		String stageName = getStageName(rowName2);
		
		Assert.assertEquals(stageName, stageupdate);
		
		System.out.println("The Stage value Perception Analysis is displayed after updating");
		
		// Expected Result:The Oppurtunity is Edited Successfully

		System.out.println("The Opportunity is edited Successfully");
	}

}
