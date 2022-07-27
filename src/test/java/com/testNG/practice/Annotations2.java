package com.testNG.practice;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(ListenerImpliments.class)
public class Annotations2 extends Annotations {
	public 	static WebDriver driver;

	@Test(retryAnalyzer=RetryAnalyzer.class,groups = "regression")
	public void facebook() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://facebook.com");
		String actualURL=driver.getCurrentUrl();
		assertEquals(actualURL, "https://facebook.com");


	}

	@Test(retryAnalyzer=RetryAnalyzer.class,groups= {"smoke","regression"})
	public void amazon() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://amazon.in");
		String actualURL=driver.getCurrentUrl();
		assertEquals(actualURL, "https://www.amazon.in/");

	}

}
