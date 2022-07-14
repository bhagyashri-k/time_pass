package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfopg {
	
	WebDriver driver;
	public CampaignInfopg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
