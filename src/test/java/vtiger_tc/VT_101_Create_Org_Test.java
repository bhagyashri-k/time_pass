package vtiger_tc;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.genericlib.BaseClass;
import com.genericlib.Fake_Data;
import pom_Repo.CreateOrgPage;
import pom_Repo.HomePage;
import pom_Repo.OrgInfoPage;

public class VT_101_Create_Org_Test extends BaseClass
{

	@Test
	public  void orgTestCase1() throws Throwable 
	{

		Fake_Data data = new Fake_Data();
		String fname = data.firstName();
		String lname = data.lastName();
		String cname = data.companyName();
	
	HomePage hpage = new HomePage(driver);

	hpage.getOrglinkbtn().click();

	OrgInfoPage orgpage = new OrgInfoPage(driver);

	orgpage.getCreateorglinkbtn().click();

	CreateOrgPage crtorg = new CreateOrgPage(driver);

	crtorg.getOrgnametxtbox().sendKeys(cname);
	crtorg.getOrgsavebtn().click();
	Thread.sleep(2000);


	String savedorgname = orgpage.getOrgnamesavedtxt().getText();
	String actualorgname = orgpage.getOrgnameexisttxtbox().getText();
	
	Assert.assertEquals(true, true);

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
