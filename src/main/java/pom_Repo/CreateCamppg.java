package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCamppg {
	
	WebDriver driver;
	public CreateCamppg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campnametxtbox;
	
	public WebElement getCampnametxtbox() {
		return campnametxtbox;
	}
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement campsavebtn;
	
	public WebElement getCampsavebtn() {
		return campsavebtn;
	}
	
	
	
	

}
