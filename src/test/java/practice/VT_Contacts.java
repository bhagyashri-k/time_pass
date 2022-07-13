package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VT_Contacts {

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

		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		WebElement name = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Thread.sleep(3000);
		Select s1 = new Select(name);
		s1.selectByIndex(2);

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Bhagya");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("kale");

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

		str.sendKeys("Smart code Learning");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='1']")).click();
		driver.switchTo().window(main_page);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();

		String text = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String text1 = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();
		if(text.contains(text1))
		{
			System.out.println("Contact  Name is verified");
		}

		WebElement sout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(sout).perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		

	}

}
