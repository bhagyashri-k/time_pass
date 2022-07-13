package vtiger_tc;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;
import com.vtiger.generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_101_Creat_CampTest {
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
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(uname,Keys.TAB,pwd,Keys.ENTER);
		WebElement more = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions act = new Actions(driver);
		act.moveToElement(more).perform();
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys(cname);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		driver.findElement(By.xpath("//td[@class='tabSelected']")).click();
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(cname);
		WebElement ele = driver.findElement(By.xpath("//select [@id='bas_searchfield']"));
		driverUtil.selectDropD("campaignname", ele);
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='selected_id']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		Thread.sleep(3000);
		driverUtil.acceptAlert();
		Thread.sleep(3000);
		 WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			driverUtil.moveToElement(ele2);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			
	}

}
