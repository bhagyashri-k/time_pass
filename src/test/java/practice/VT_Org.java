package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger_tc.Prop_File;

public class VT_Org {
  public static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		
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
        driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("JDK Learning");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("BSK techwish sol/");
		WebElement drop_d = driver.findElement(By.xpath("//select [@id='bas_searchfield']"));
		Select s = new Select(drop_d);
		s.selectByVisibleText("Organization Name");
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='selected_id']")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		Thread.sleep(3000);
		Alert a1 = driver.switchTo().alert();
		a1.accept();
		
		Thread.sleep(3000);
		 WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act1 = new Actions(driver);
			act1.moveToElement(ele2).perform();
			
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
