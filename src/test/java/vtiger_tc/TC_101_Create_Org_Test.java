package vtiger_tc;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.BaseClass;
import com.genericlib.Fake_Data;
import com.testNG.practice.RetryAnalyzer;

import pom_Repo.CreateOrgPage;
import pom_Repo.HomePage;
import pom_Repo.OrgInfoPage;
@Listeners(com.testNG.practice.ListenerImpliments.class)
public class TC_101_Create_Org_Test extends BaseClass
{


	@Test(retryAnalyzer = RetryAnalyzer.class)
	public  void orgTestCase1() throws Throwable 
	{

		Fake_Data data = new Fake_Data();
		//		String fname = data.firstName();
		//		String lname = data.lastName();
		String cname = data.companyName();
		Assert.assertEquals(true, false);
		HomePage hpage = new HomePage(driver);

		hpage.getOrglinkbtn().click();

		OrgInfoPage orgpage = new OrgInfoPage(driver);

		orgpage.getCreateorglinkbtn().click();

		CreateOrgPage crtorg = new CreateOrgPage(driver);

		crtorg.getOrgnametxtbox().sendKeys(cname);
		crtorg.getOrgsavebtn().click();
		
		System.out.println("Organization Created Successfully");
		Thread.sleep(2000);


		//	String savedorgname = orgpage.getOrgnamesavedtxt().getText();
		//	String actualorgname = orgpage.getOrgnameexisttxtbox().getText();

		

		//	if(savedorgname.contains(actualorgname))
		//	{
		//		System.out.println("Orgnization Name is verified");
		//	}
		//	else
		//	{
		//		System.out.println("organization name is not verified");
		//	}



	}

}
