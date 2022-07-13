package vtiger_tc;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_Org {
    public static WebDriver driver;
    
	@Test
	public void createOrgDeleteVerify() throws IOException, InterruptedException {
		
		Fake_Data data = new Fake_Data();
		String fname = data.firstName();
		String lname = data.lastName();
		String cname = data.companyName();
		
		Prop_File file = Prop_File.getObj();
		
		String Browser = file.propdataRead("browser");
		String url = file.propdataRead("url");
		String uname = file.propdataRead("username");
		String pwd = file.propdataRead("password");
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(uname, Keys.TAB,pwd, Keys.ENTER);
		

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(cname);
		WebElement indus = driver.findElement(By.xpath("//select[@name='industry']"));

		Select sel = new Select(indus);
		Thread.sleep(2000);
		sel.selectByVisibleText("Electronics");
		
		WebElement rating = driver.findElement(By.xpath("//select[@name='rating']"));
		Select rate = new Select(rating);
		rate.selectByValue("Active");
		
		WebElement type = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select typ = new Select(type);
		typ.selectByValue("Competitor");
		
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		
		String str1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Thread.sleep(3000);
//		String org_name = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(str1.contains(cname))
		{
			System.out.println("Organization name is verified");
		}
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(cname);
		WebElement drop_d = driver.findElement(By.xpath("//select [@id='bas_searchfield']"));
		Select s = new Select(drop_d);
		s.selectByVisibleText("Organization Name");
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='selected_id']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		Thread.sleep(3000);
		Alert a1 = driver.switchTo().alert();
		a1.accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(cname);
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		Thread.sleep(3000);
		boolean msg=driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).isDisplayed();
		if(msg==true)
		{
			System.out.println("Test case pass");
		}
		
		else {
			System.out.println("Test case fail");
		}
		Thread.sleep(3000);
		WebElement sout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(sout).perform();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
