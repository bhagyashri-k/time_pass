package vtiger_tc;

import java.util.Set;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.genericlib.BaseClass;
import com.vtiger.generic.WebDriverUtility;
import pom_Repo.ContactInfoPg;
import pom_Repo.CreateContPg;
import pom_Repo.HomePage;
import pom_Repo.OrgInfoPage;

public class TC_104_Create_Cont_Del_OrgTest extends BaseClass {
	
	@Test
	public void createCont() throws Exception 
	{ 
		WebDriverUtility driverUtil = new WebDriverUtility(driver);
		
		Fake_Data data = new Fake_Data();
		String fname = data.firstName();
		String lname = data.lastName();
		String cname = data.companyName();
		
		HomePage hpage = new HomePage(driver);

		hpage.getContactlinkbtn().click();
		
		ContactInfoPg contact = new ContactInfoPg(driver);
		contact.getCreatecontbtn().click();
		
		CreateContPg createCont = new CreateContPg(driver);
		WebElement nameinitial = createCont.getFirstnamedd();
		driverUtil.selectDropD(nameinitial, "Dr.");
		
		createCont.getFristnametxtbox().sendKeys(fname);
		createCont.getLastnametxtbox().sendKeys(lname);
        createCont.getOrgnamelinkbtn().click();
        
		String main_page = driver.getWindowHandle();
		Set<String> all_page = driver.getWindowHandles();

		for(String i : all_page)
		{
			if(!i.equals(main_page))
			{
				driver.switchTo().window(i);
			}
		}

		Thread.sleep(3000);
		OrgInfoPage orgmainpg = new OrgInfoPage(driver);
		orgmainpg.getOrgnmsearchbox().sendKeys("Hyatt LLC");
		orgmainpg.getSearchnowbtn().click();

		Thread.sleep(3000);
		orgmainpg.getSelectchechbox().click();
		driver.switchTo().window(main_page);
		Thread.sleep(3000);
		createCont.getContsavebtn().click();

		String headtxt = contact.getSavedcontHeadtxt().getText();
		//		String text1 = driver.findElement(By.xpath("//span[@id='dtlview_First Name']")).getText();
		if(headtxt.contains(fname))
		{
			System.out.println("Contact  Name is verified");
		}

		
	}

}
