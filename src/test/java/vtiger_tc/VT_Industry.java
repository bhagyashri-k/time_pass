package vtiger_tc;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_Repo.CreateOrgPage;
import pom_Repo.HomePage;
import pom_Repo.LoginPage;
import pom_Repo.OrgInfoPage;

public class VT_Industry {
	public static WebDriver driver;
  @Test
  public void verifyIndustry() throws IOException, InterruptedException
	{
	  Fake_Data data = new Fake_Data();
		String fname = data.firstName();
		String lname = data.lastName();
		String cname = data.companyName();
		
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
		WebDriverUtility driverUtil=new WebDriverUtility(driver);
		driverUtil.pageLoadTime();
		driverUtil.maximixzWindow();
		driver.get(url);
		Thread.sleep(3000);
		
		LoginPage login = new LoginPage(driver);

		login.getUsernametxtbox().sendKeys(uname);
		login.getPasswordtxtbox().sendKeys(pwd);
		login.getLoginbtn().click();

		HomePage hpage = new HomePage(driver);

		hpage.getOrglinkbtn().click();

		OrgInfoPage orgpage = new OrgInfoPage(driver);

		orgpage.getCreateorglinkbtn().click();

		CreateOrgPage crtorg = new CreateOrgPage(driver);

		crtorg.getOrgnametxtbox().sendKeys(cname);
		
         WebElement indus = crtorg.getIndustryDD();

		driverUtil.selectDropD("Communications", indus);
		Thread.sleep(3000);
		WebElement rating = crtorg.getRatingdropD();
		driverUtil.selectDropD("Active", rating);
		Thread.sleep(3000);
		WebElement acctype = crtorg.getAcctypeDD();
		Thread.sleep(2000);
		driverUtil.selectDropD("Analyst",acctype);
		crtorg.getOrgsavebtn().click();
		
		String savedorgname = orgpage.getOrgnamesavedtxt().getText();
		String actualorgname = orgpage.getOrgnameexisttxtbox().getText();

		if(savedorgname.contains(savedorgname))
		{
			System.out.println("Orgnization Name is verified");
		}
		else
		{
			System.out.println("organization name is not verified");
		}
		
		crtorg.getHomepagebtnlink().click();

//		hpage.getLogoutbtn().click();
//
//		WebElement logoutbtn = hpage.getLogoutbtn();
//		Thread.sleep(3000);
//		driverUtil.moveToElement(logoutbtn);
//
//		hpage.getSignoutlinkbtn().click();


//		String str1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		Thread.sleep(3000);
////		String org_name = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
//		if(str1.contains(cname))
//		{
//			System.out.println("Organization name is verified");
//		}
         
//		WebElement sout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Thread.sleep(3000);
//		driverUtil.moveToElement(sout);
//
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

//		driverUtil.closeBrowser();
	}

}
