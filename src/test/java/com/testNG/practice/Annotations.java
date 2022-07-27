package com.testNG.practice;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class Annotations {
	
    WebDriver driver;
	@BeforeSuite(groups={"smoke","regression"})
	public void beforesuite() {
		System.out.println("before suite");
	}
	@BeforeTest
	public void beforetest() {
		System.out.println("before test");	
	}
	@Parameters("password")
	@BeforeClass
	public void beforeclass(String pwd) {
		System.out.println("before class");
		System.out.println(pwd);
	}
	@BeforeMethod(groups="smoke")
	public void beforemethod() {
		System.out.println("before method");
	}
	@AfterMethod(groups="regression")
	public void aftermethod() {
		System.out.println("after method");
	}
	@AfterClass
	public void afterclass() {
		System.out.println("after class"); 
	}
	@AfterTest(groups= {"smoke","regression"})
	public void aftertest() {
		System.out.println("after test");
	}
	@AfterSuite
	public void aftersuite() {
		System.out.println("after suite");
	}
}
