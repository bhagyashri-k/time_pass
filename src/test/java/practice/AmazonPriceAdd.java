package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPriceAdd {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oppo reno 5");
		driver.findElement(By.id("nav-search-submit-button")).click();
		WebElement ele = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::div[@class='sg-col-inner']/descendant::span[@class='a-price-whole']"));
	    
		System.out.println(ele.getText());
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		String id1 = driver.getWindowHandle();
		Set<String> id2 = driver.getWindowHandles();
		for(String i : id2)
		{
			if(!i.equals(id1))
			{
				driver.switchTo().window(i);
			}
		}
		JavascriptExecutor jse  = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		WebElement ele2 = driver.findElement(By.xpath("//select[@id='quantity']"));
		Select s = new Select(ele2);
		s.selectByIndex(1);
		driver.findElement(By.xpath("//input[@name='submit.add-to-cart']")).click();	
		Thread.sleep(3000);
		WebElement str = driver.findElement(By.xpath("//div[@class='a-row a-spacing-none']/descendant::span[@id='attach-accessory-cart-subtotal']"));
		String str1 = str.getText();
		
		System.out.println(str1);
//		String s2 = sss.substring(1);
	
		String s1 =  str1.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(s1);

	}

}
