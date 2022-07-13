package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class FlipkartAssignment {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone 13");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		driver.findElement(By.xpath("//div[@class='_4rR01T']/ancestor::a[@class='_1fQZEK']")).click();
		String mainId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for(String i : allId)
		{
			if(!i.equals(mainId))
			{
				driver.switchTo().window(i);
			}
		}
		
		String str = driver.findElement(By.xpath("//span[@class='B_NuCI']/ancestor::div[@class='_1YokD2 _3Mn1Gg col-8-12']/descendant::div[@class='_30jeq3 _16Jk6d']")).getText();
		System.out.println(str);
	driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
	
//		driver.findElement(By.xpath("//*[name()='svg'and@class='_1KOMV2']")).click();
//		Thread.sleep(3000);
//		JavascriptExecutor jse = (JavascriptExecutor)driver;
//		jse.executeScript("window.scrollBy(0, 3500)");
//			
			
//		
//		driver.findElement(By.xpath("(//button[@class='_23FHuj'])[2]")).click();
		
		
		

	}

}
