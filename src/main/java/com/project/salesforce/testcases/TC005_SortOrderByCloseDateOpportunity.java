package com.project.salesforce.testcases;

import java.text.ParseException;
import org.testng.annotations.Test;

import com.project.salesforce.ProjectSpecificMethod;
import com.project.salesforce.pages.OpportunityPage;

public class TC005_SortOrderByCloseDateOpportunity extends ProjectSpecificMethod  {
	
	@Test(dataProvider = "loginCredentials")
	
	public void sortOrderByCloseDate(String uname, String pwd) throws ParseException
	{
		OpportunityPage op=new OpportunityPage(driver);
		
		op.clickOpportunity()
		
		.verifyTableView()
		
		.sortCloseDate()
		
		.verifySortedCloseDate(op.getCloseDateList());
		
		
	}

}
