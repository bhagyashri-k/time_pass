package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VTiger_Select {

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
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		List<WebElement> allorg = driver.findElements(By.xpath("//table[@class='lvt small']//tr"));
		for(int i=3; i<=allorg.size(); i++)
		{
			WebElement ele = driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]/td[1]"));
			ele.click();
			WebElement ele2 = driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]/td[3]"));
			String str = ele2.getText();
			System.out.println(str);
				
		}
//		for(int i=3; i<=allorg.size(); i++)
//		{
//			WebElement oneclik = driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]/td[3]"));
//			String str = oneclik.getText();
//			if(str.equalsIgnoreCase("Test Yantra"))
//			{
//			WebElement click = driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]/td[1]"));
//			click.click();
//			}
//		}
		
		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
				
				

	}

}
