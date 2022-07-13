package vtiger_tc;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
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

public class TC_103_Create_Org_Del {
	
	
	public static WebDriver driver;
	@Test
	public void createOrg() throws IOException, InterruptedException{
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
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(uname,Keys.TAB,pwd,Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(cname);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(cname);
		WebElement drop_d = driver.findElement(By.xpath("//select [@id='bas_searchfield']"));
		driverUtil.selectDropD("Organization Name", drop_d);
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='selected_id']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		Thread.sleep(3000);
		driverUtil.acceptAlert();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		Thread.sleep(6000);
		List<WebElement> ele1 = driver.findElements(By.xpath("//a[text()='Organization Name']"));
		

		Thread.sleep(6000);
//		ArrayList<String> fist = new ArrayList<String>();
//		Thread.sleep(6000);
//		for(int a=0; a<fist.size(); a++)
//		{
//			String str = ele1.get(a).getText();
//			Thread.sleep(6000);
//			fist.add(str);
//			
//		}
//		Thread.sleep(6000);
//		System.out.println(fist);
		
		for(WebElement i:ele1)
		{
			
			if(i.equals(cname))
			{
				System.out.println("Test case fail");
			}
			else
			{
				System.out.println("Test case pass");
			}
		}
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		driverUtil.moveToElement(ele2);

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(3000);
		driverUtil.closeBrowser();

	}

}
