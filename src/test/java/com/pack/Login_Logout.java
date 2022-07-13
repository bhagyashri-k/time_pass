package com.pack;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger_tc.Prop_File;

public class Login_Logout {
	public static WebDriver driver;
	
	public void login1() throws InterruptedException, IOException {
		
		Prop_File file = Prop_File.getObj();
		
		String Browser = file.propdataRead("browser");
		String url = file.propdataRead("url");
		String uname = file.propdataRead("username");
		String pwd = file.propdataRead("password");
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(uname,Keys.TAB,pwd,Keys.ENTER);
		
	}
	public void logout2() throws InterruptedException {
		WebElement sout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(sout).perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
