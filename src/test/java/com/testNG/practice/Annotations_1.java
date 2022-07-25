package com.testNG.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Annotations_1 extends Annotations{
	WebDriver driver;
	@Parameters("browser")
	@Test(groups= {"smoke","regression"})
	public void annotations1_test1(String BROWSER) {
		if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		}
		else{
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver=new FirefoxDriver();
			}
		
		System.out.println(BROWSER);
		System.out.println("@test executing annotations1 test1");
	}
	@Test(groups="smoke")
	public void annotations1_test2() {
	System.out.println("@test executing annotations1 test2");
}
}