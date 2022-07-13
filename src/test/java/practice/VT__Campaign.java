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

public class VT__Campaign {

	

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		WebElement more = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions act = new Actions(driver);
		act.moveToElement(more).perform();
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys("Buy one get two112");
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		driver.findElement(By.xpath("//td[@class='tabSelected']")).click();
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("Buy one get two12");
		WebElement ele = driver.findElement(By.xpath("//select [@id='bas_searchfield']"));
		Select s1 = new Select(ele);
		s1.selectByValue("campaignname");
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		driver.findElement(By.xpath("//input[@name='selected_id']")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		Thread.sleep(3000);
		Alert alt = driver.switchTo().alert();
		alt.accept();
		Thread.sleep(3000);
		 WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act1 = new Actions(driver);
			act1.moveToElement(ele2).perform();
			
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		driver.findElement(By.xpath("//img[@src='themes/images/arrow_down_black.png']")).click();
//		driver.findElement(By.xpath("//input[@value='Campaigns']")).click();
//		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		
		

	}

}
