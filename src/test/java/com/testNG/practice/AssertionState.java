package com.testNG.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionState {
	
	@Test
	public void aaserCheck()
	{
		System.out.println("Open the browser");
		System.out.println("ENter the URL");
		System.out.println("Open the application");
		System.out.println("Enter username");
		
		SoftAssert softast = new SoftAssert();
		
		System.out.println("click on login button");
		System.out.println("Home page must be displayed");
		String actualTitle ="get title";
		String expectedTitle = "get title";
		
		
		String act = "myname";
		String fake = "mynae";
		softast.assertEquals(actualTitle, expectedTitle);
		softast.assertAll();
		
		
		Assert.assertEquals(act, fake);
//		System.out.println("Enter password");
 	}

}
