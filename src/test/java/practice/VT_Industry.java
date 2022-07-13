package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VT_Industry {

	public static void main(String[] args) throws Throwable {
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Smart code Learning");
		WebElement indus = driver.findElement(By.xpath("//select[@name='industry']"));
		
		Select sel = new Select(indus);
		Thread.sleep(2000);
		sel.selectByVisibleText("Electronics");
		
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		String str1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Thread.sleep(3000);
		String org_name = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(str1.contains(org_name))
		{
			System.out.println("Organization name is verified");
		}
		
		WebElement sout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(sout).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}

}
