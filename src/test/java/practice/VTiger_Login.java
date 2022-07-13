 package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VTiger_Login {

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
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Test Yantra s/w solutions12");
//		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
//		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		Thread.sleep(5000);
//		Actions act = new Actions(driver);
//		act.moveToElement(ele).perform();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		List<WebElement> ele1 = driver.findElements(By.xpath("//table[@class='lvt small']//tr"));
		System.out.println("No of rows in an organizatin table are: "+ele1.size());
		
//		 List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']//tr[*]/td[3]/a"));
//		for(WebElement i: ele)
//		{
//			System.out.println(i.getText());
//		}
//		This xpath is for click only one check box
//		driver.findElement(By.xpath("//table[@class='lvt small']//tr[3]/td[1]")).click();
		
//		This xpath is for click all check boxes 
//		List<WebElement> clik = driver.findElements(By.xpath("//table[@class='lvt small']//tr[*]/td[1]"));
//		for(WebElement i : clik)
//		{
//			i.click();
//		}
		Thread.sleep(3000);
		WebElement str = driver.findElement(By.xpath("//table[@class='lvt small']//tr[last()]/td[7]"));
		System.out.println(str.getText());
		
//		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("Test Yantra");
//		WebElement drop = driver.findElement(By.xpath("//select[@id='bas_searchfield']"));
//		Select sel = new Select(drop);
//		sel.selectByVisibleText("Organization Name");
//		
//		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
//		
        String org_name = "Test Yantra";
		WebElement ele3 = driver.findElement(By.xpath("//table[@class='lvt small']//tr[*]/td[3]/a[text()='"+org_name+"']/parent::td/parent::tr/td/input"));
		ele3.click();
	}

}
