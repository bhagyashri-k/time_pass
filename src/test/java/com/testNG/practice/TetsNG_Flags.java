package com.testNG.practice;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TetsNG_Flags {
	
	@Test(priority=0)
	public void loginMe() {
		System.out.println("SuccessFully Logged in");
	}
	
	@Test(dependsOnMethods = "loginMe")
	public void createAccount()
	{
		System.out.println("Account is created");
//		Assert.assertFalse(true);
//		throw new SkipException("Skipped");
	}
	
	@Test(dependsOnMethods = "createAccount")
	public void buyNow()
	{
		System.out.println("Click on buy Now");
	}
	
	@Test(invocationCount = 2, dependsOnMethods = "buyNow")
	public void addToCart() {
		System.out.println("Added to the cart");
	}
	
	@Test(dependsOnMethods = "addToCart", enabled = false)
	public void logOut() {
		System.out.println("Back to login page");
	}

	
}
