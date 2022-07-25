package com.genericlib;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.vtiger.generic.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom_Repo.CreateOrgPage;
import pom_Repo.HomePage;
import pom_Repo.LoginPage;
public class BaseClass {

	public  WebDriver driver;
	WebDriverUtility driverUtil;
	Prop_File file = Prop_File.getObj();
	@BeforeSuite
	public void connectDB() throws IOException
	{
		System.out.println("Connecting to database");	
	}
	@AfterSuite
	public void closeDB()
	{
		System.out.println("Close DataBase");
	}
	@BeforeClass
	public void lounchBrowser() throws Exception
	{

		String Browser = file.propdataRead("browser");

		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driverUtil = new WebDriverUtility(driver);
		driverUtil.maximixzWindow();
		driverUtil.pageLoadTime();
		String url = file.propdataRead("url");
		driver.get(url);
		Thread.sleep(3000);
	}
	@AfterClass
	public void closeBrowser()
	{

		driverUtil.closeBrowser();
	}
	@BeforeMethod
	public void login() throws IOException
	{
		String uname = file.propdataRead("username");
		String pwd = file.propdataRead("password");
		LoginPage login = new LoginPage(driver);
		login.getUsernametxtbox().sendKeys(uname);
		login.getPasswordtxtbox().sendKeys(pwd);
		login.getLoginbtn().click();

	}
	@AfterMethod
	public void logout() throws Exception
	{
		CreateOrgPage crtorg = new CreateOrgPage(driver);
		crtorg.getHomepagebtnlink().click();
		HomePage hpage = new HomePage(driver);
		hpage.getLogoutbtn().click();

		WebElement logoutbtn = hpage.getLogoutbtn();
		Thread.sleep(3000);
		driverUtil.moveToElement(logoutbtn);

		hpage.getSignoutlinkbtn().click();
	}



}
