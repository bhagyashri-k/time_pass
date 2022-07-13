package practice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CurrentDate {

	public static void main(String[] args) {
		
		Date date = new Date();
		System.out.println(date);
		String currentDate = date.toString();
		String[] str = currentDate.split(" ");
//		Wed Jun 22 13:15:17 IST 2022
//       0   1   2     3     4    5
//		0    1   2                5
		String day = str[0];
		String month = str[1];
		String date1 = str[2];
		String year = str[5];
		
		String todaysDate =day+" "+month+" "+date1+" "+year;
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10']")).click();
		driver.findElement(By.xpath(""));
		
	}

	
}
