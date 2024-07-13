package com.project.salesforce.testcases;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.project.salesforce.pages.OpportunityPage;

public class TC005_SortOrderByCloseDateOpportunity extends OpportunityPage {
	
	@Test(dataProvider = "loginCredentials")
	public void sortOrderByCloseDate(String uname, String pwd) throws ParseException
	{
		clickOpportunity();
		
		verifyTableView();
		
		sortCloseDate();
		
		List<Date> closeDateList = getCloseDateList();
		
		boolean sortedCloseDate = verifySortedCloseDate(closeDateList);
		
		Assert.assertTrue(sortedCloseDate);
	}

}
