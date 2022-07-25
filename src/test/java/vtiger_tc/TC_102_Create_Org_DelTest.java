package vtiger_tc;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.genericlib.BaseClass;
import com.github.javafaker.Faker;
import com.vtiger.generic.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_Repo.CreateOrgPage;
import pom_Repo.HomePage;
import pom_Repo.OrgInfoPage;

public class TC_102_Create_Org_DelTest extends BaseClass {
	
	@Test
	public void createOrg() throws Exception
	{
		WebDriverUtility driverUtil = new WebDriverUtility(driver);
		
		Fake_Data data = new Fake_Data();
		String fname = data.firstName();
		String lname = data.lastName();
		String cname = data.companyName();
		String cname1 = cname;
           
		HomePage hpage = new HomePage(driver);

		hpage.getOrglinkbtn().click();
		OrgInfoPage orgpage = new OrgInfoPage(driver);
    
		orgpage.getCreateorglinkbtn().click();
		CreateOrgPage crtorg = new CreateOrgPage(driver);

		crtorg.getOrgnametxtbox().sendKeys(cname1);
		
		crtorg.getOrgsavebtn().click();
		Thread.sleep(3000);
		hpage.getOrglinkbtn().click();
		Thread.sleep(3000);
		orgpage.getSearchorgnametxtbox().sendKeys(cname1);
		WebElement drop_d = orgpage.getOrgnmsearchDD();
		driverUtil.selectDropD("Organization Name", drop_d);
		orgpage.getSearchnowbtn().click();
		orgpage.getSelcheckbox().click();
		Thread.sleep(3000);
		orgpage.getDeletebtn().click();
		Thread.sleep(3000);
		driverUtil.acceptAlert();
		Thread.sleep(3000);
		hpage.getOrglinkbtn().click();
		Thread.sleep(6000);
		List<WebElement> ele1 =  orgpage.getListofexistorgs();
		

		Thread.sleep(6000);
//		ArrayList<String> fist = new ArrayList<String>();
//		Thread.sleep(6000);
//		for(int a=0; a<fist.size(); a++)
//		{
//			String str = ele1.get(a).getText();
//			Thread.sleep(6000);
//			fist.add(str);
//			
//		}
//		Thread.sleep(6000);
//		System.out.println(fist);
		
		for(WebElement i:ele1)
		{
			
			if(i.equals(cname1))
			{
				System.out.println("Test case fail");
			}
			else
			{
				System.out.println("Test case pass");
			}
		}
	

	}

}
