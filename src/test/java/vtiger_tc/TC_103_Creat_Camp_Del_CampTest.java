package vtiger_tc;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.BaseClass;
import com.testNG.practice.RetryAnalyzer;
import com.vtiger.generic.WebDriverUtility;

import pom_Repo.CampaignInfopg;
import pom_Repo.CreateCamppg;
import pom_Repo.HomePage;
import practice.Fake_Data;
@Listeners(com.testNG.practice.ListenerImpliments.class)
public class TC_103_Creat_Camp_Del_CampTest extends BaseClass {	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void createCampTest() throws Throwable 
	{
        WebDriverUtility driverUtil = new WebDriverUtility(driver);
        HomePage hpage = new HomePage(driver);
        CampaignInfopg camppage = new CampaignInfopg(driver);
        CreateCamppg crtcmppg = new CreateCamppg(driver);
        
		Fake_Data data = new Fake_Data();
//		String fname = data.firstName();
//		String lname = data.lastName();
		String cname = data.companyName();
		Thread.sleep(3000);
		
		
		WebElement moreoption = hpage.getMoreoptlinkbtn();
		driverUtil.moveToElement(moreoption);
		hpage.getCamplinkbtn().click();
		
        camppage.getCrtcamplinkbtn().click();
        crtcmppg.getCampnametxtbox().sendKeys(cname);
		Thread.sleep(3000);
		crtcmppg.getCampsavebtn().click();
		hpage.getCampinfolnkbtn().click();
		
		String campname = camppage.getExistcampname().getText();
		camppage.getExistcmptxtbox().sendKeys(campname);
		Thread.sleep(3000);
		WebElement ele = camppage.getCampnmDD();
		driverUtil.selectDropD(ele, "campaignname");
		
		camppage.getSearchnwbtn().click();
		
		Thread.sleep(3000);
		camppage.getSelectcheckbox().click();
		Thread.sleep(3000);
		camppage.getDeletebtn().click();
		Thread.sleep(3000);
		driverUtil.acceptAlert();
		
		System.out.println("Campaign Created and Deleted Successfully");
	}

	

}
