package vtiger_tc;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.BaseClass;
import com.testNG.practice.RetryAnalyzer;
import com.vtiger.generic.WebDriverUtility;

import pom_Repo.CreateOrgPage;
import pom_Repo.HomePage;
import pom_Repo.OrgInfoPage;
import practice.Fake_Data;
@Listeners(com.testNG.practice.ListenerImpliments.class)
public class TC_105_Create_Org_DDTest extends BaseClass {

	
  @Test(retryAnalyzer = RetryAnalyzer.class)
  public void verifyIndustry() throws Exception 
	{
	  WebDriverUtility driverUtil = new WebDriverUtility(driver);
	  Fake_Data data = new Fake_Data();
//		String fname = data.firstName();
//		String lname = data.lastName();
		String cname = data.companyName();
		
		
		
		HomePage hpage = new HomePage(driver);

		hpage.getOrglinkbtn().click();

		OrgInfoPage orgpage = new OrgInfoPage(driver);

		orgpage.getCreateorglinkbtn().click();

		CreateOrgPage crtorg = new CreateOrgPage(driver);
        Thread.sleep(3000);
		crtorg.getOrgnametxtbox().sendKeys(cname);
		
         WebElement indus = crtorg.getIndustryDD();
         Assert.assertEquals(true, true);
		driverUtil.selectDropD("Communications", indus);
		Thread.sleep(3000);
		WebElement rating = crtorg.getRatingdropD();
		driverUtil.selectDropD("Active", rating);
		Thread.sleep(3000);
		WebElement acctype = crtorg.getAcctypeDD();
		Thread.sleep(2000);
		driverUtil.selectDropD("Analyst",acctype);
		crtorg.getOrgsavebtn().click();
		
		System.out.println("All Dropdown selected Successfully");
		Thread.sleep(5000);
//		String savedorgname = orgpage.getOrgnamesavedtxt().getText();
//		String actualorgname = orgpage.getOrgnameexisttxtbox().getText();
		
		
	}

}
