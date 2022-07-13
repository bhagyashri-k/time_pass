package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartPhone {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles under 20000");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[text()='realme']")).click();
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		String mainId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for(String i: allId)
		{
			if(!i.equals(mainId))
			{
				driver.switchTo().window(i);
			} 
		}
		
//         System.out.println(driver.getTitle());
		WebElement ele = driver.findElement(By.id("productTitle"));
		System.out.println(ele.getText());
		String str = driver.findElement(By.xpath("//div[@id='centerCol']/descendant::span[@class='a-price-whole']")).getText();
		System.out.println(str);
	}

}
