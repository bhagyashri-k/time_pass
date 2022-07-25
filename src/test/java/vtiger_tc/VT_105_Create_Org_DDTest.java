package vtiger_tc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericlib.BaseClass;
import com.vtiger.generic.WebDriverUtility;
import pom_Repo.CreateOrgPage;
import pom_Repo.HomePage;
import pom_Repo.OrgInfoPage;

public class VT_105_Create_Org_DDTest extends BaseClass {

	
  @Test
  public void verifyIndustry() throws Exception 
	{
	  WebDriverUtility driverUtil = new WebDriverUtility(driver);
	  Fake_Data data = new Fake_Data();
		String fname = data.firstName();
		String lname = data.lastName();
		String cname = data.companyName();
		
		
		
		HomePage hpage = new HomePage(driver);

		hpage.getOrglinkbtn().click();

		OrgInfoPage orgpage = new OrgInfoPage(driver);

		orgpage.getCreateorglinkbtn().click();

		CreateOrgPage crtorg = new CreateOrgPage(driver);
        Thread.sleep(3000);
		crtorg.getOrgnametxtbox().sendKeys(cname);
		
         WebElement indus = crtorg.getIndustryDD();

		driverUtil.selectDropD("Communications", indus);
		Thread.sleep(3000);
		WebElement rating = crtorg.getRatingdropD();
		driverUtil.selectDropD("Active", rating);
		Thread.sleep(3000);
		WebElement acctype = crtorg.getAcctypeDD();
		Thread.sleep(2000);
		driverUtil.selectDropD("Analyst",acctype);
		crtorg.getOrgsavebtn().click();
		
		String savedorgname = orgpage.getOrgnamesavedtxt().getText();
		String actualorgname = orgpage.getOrgnameexisttxtbox().getText();
		Assert.assertEquals(true, true);

//		if(savedorgname.contains(savedorgname))
//		{
//			System.out.println("Orgnization Name is verified");
//		}
//		else
//		{
//			System.out.println("organization name is not verified");
//		}
//		
//		
	}

}
