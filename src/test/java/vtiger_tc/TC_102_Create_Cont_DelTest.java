package vtiger_tc;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.vtiger.generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_Repo.HomePage;
import pom_Repo.LoginPage;

public class TC_102_Create_Cont_DelTest {
	public static WebDriver driver;
	@Test
	public void createCont() throws InterruptedException, IOException {

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
		WebDriverUtility driverUtil = new WebDriverUtility(driver);
		driverUtil.pageLoadTime();
		driverUtil.maximixzWindow();
		driver.get(url);
		Thread.sleep(3000);
		LoginPage login = new LoginPage(driver);

		login.getUsernametxtbox().sendKeys(uname);
		login.getPasswordtxtbox().sendKeys(pwd);
		login.getLoginbtn().click();

		HomePage hpage = new HomePage(driver);


		hpage.getContactlinkbtn().click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		WebElement name = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Thread.sleep(3000);
		Select s1 = new Select(name);
		s1.selectByIndex(2);

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(fname);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lname);

		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		String main_page = driver.getWindowHandle();
		Set<String> all_page = driver.getWindowHandles();

		for(String i : all_page)
		{
			if(!i.equals(main_page))
			{
				driver.switchTo().window(i);
			}
		}

		Thread.sleep(3000);
		WebElement str = driver.findElement(By.xpath("//input[@name='search_text']"));

		str.sendKeys("JDK Learning");
		driver.findElement(By.xpath("//input[@name='search']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='1']")).click();
		driver.switchTo().window(main_page);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();

		String text = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		//		String text1 = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();
		if(text.contains(fname))
		{
			System.out.println("Contact  Name is verified");
		}

		WebElement sout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(sout).perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();

	}

}
