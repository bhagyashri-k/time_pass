package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPhonePrice {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles under 20000");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[text()='realme']")).click();
		Thread.sleep(3000);
		String ele = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='sg-col-inner']/descendant::span[@class='a-price-whole']")).getText();
		 System.out.println(ele);
		String str = ele.replaceAll(",", "");
	    int value = Integer.parseInt(str);
		System.out.println(value);
	    if(value<20000)
	    {
	    	System.out.println("Test case pass");
	    }
	    else
	    {
	    	System.out.println("Test case fail");
	    }
	    driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
	}

}
