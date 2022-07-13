package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICC_Cricket_Rank {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/odi");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,700)");
//		This xpath for to print all text inside the table
		WebElement ele = driver.findElement(By.xpath("//section[@class='widget rankings-widget ']"));
		System.out.println(ele.getText()+" ");
//		This xpath is to print perticular row data
		WebElement str = driver.findElement(By.xpath("//table[@class='table']//tr[4]/td[2]/span[@class='u-hide-phablet']"));
		System.out.println(str.getText());
//		This xpath is to print the data of one column
		List<WebElement> ele1 = driver.findElements(By.xpath("//table[@class='table']//tr[*]/td[2]"));
		for(WebElement i: ele1)
		{
			System.out.println(i.getText());
		}

	}

}
