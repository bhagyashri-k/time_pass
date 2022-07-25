package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicXpathEx {
	
	public static void main(String[] args) throws InterruptedException {
		
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.makemytrip.com/");
	Thread.sleep(20000);
	WebElement ele = driver.findElement(By.xpath("//iframe[@name='notification-frame-~19713b227']"));
	driver.switchTo().frame(ele);
	driver.findElement(By.xpath("//a[@class='close']")).click();
	Thread.sleep(5000);
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	driver.findElement(By.id("fromCity")).sendKeys("Hyderabad");
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("");
	driver.findElement(By.xpath("//p[@class='font14 appendBottom5 blackText']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@class='lbl_input latoBold  appendBottom5']")).click();
	driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Maldives");
	driver.findElement(By.xpath("//p[@class='font14 appendBottom5 blackText']")).click();
	
	
	}

}
