package vtiger_tc;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_Repo.CreateOrgPage;
import pom_Repo.HomePage;
import pom_Repo.LoginPage;
import pom_Repo.OrgInfoPage;

public class VT_Org {
	public static WebDriver driver;
	public static void main(String[] args) throws Throwable {

		Prop_File file = Prop_File.getObj();

		String Browser = file.propdataRead("browser");
		String url = file.propdataRead("url");
		String uname = file.propdataRead("username");
		String pwd = file.propdataRead("password");

		Fake_Data data = new Fake_Data();
		String fname = data.firstName();
		String lname = data.lastName();
		String cname = data.companyName();

		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		WebDriverUtility driverUtil = new WebDriverUtility(driver);
		driverUtil.maximixzWindow();
		driverUtil.pageLoadTime();

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
		crtorg.getOrgsavebtn().click();
		Thread.sleep(2000);


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

		hpage.getLogoutbtn().click();

		WebElement logoutbtn = hpage.getLogoutbtn();
		Thread.sleep(3000);
		driverUtil.moveToElement(logoutbtn);

		hpage.getSignoutlinkbtn().click();

		//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(cname);
		//		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		//		Thread.sleep(3000);
		//		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		//		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(cname);
		//		WebElement drop_d = driver.findElement(By.xpath("//select [@id='bas_searchfield']"));
		//		driverUtil.selectDropD("Organization Name", drop_d);
		//		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		//		Thread.sleep(3000);
		//		driver.findElement(By.xpath("//input[@name='selected_id']")).click();
		//		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		//		Thread.sleep(3000);
		//		driverUtil.acceptAlert();
		//		
		//		Thread.sleep(3000);
		//		 WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//			driverUtil.moveToElement(ele2);
		//			
		//			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//			
		//			driverUtil.closeBrowser();

	}

}
