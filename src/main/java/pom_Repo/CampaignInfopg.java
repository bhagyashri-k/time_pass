package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfopg {
	
	WebDriver driver;
	public CampaignInfopg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement crtcamplinkbtn;
	
	
	public WebElement getCrtcamplinkbtn() {
		return crtcamplinkbtn;
	}


	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement existcmptxtbox;
	
	public WebElement getExistcmptxtbox() {
		return existcmptxtbox;
	}
	
	@FindBy(xpath="//a[@title='Campaigns']")
	private WebElement existcampname;
	
	public WebElement getExistcampname() {
		return existcampname;
	}
	
	@FindBy(xpath="//select [@id='bas_searchfield']")
	private WebElement campnmDD;
	
	public WebElement getCampnmDD() {
		return campnmDD;
	}
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchnwbtn;
	
	public WebElement getSearchnwbtn() {
		return searchnwbtn;
	}
	
	@FindBy(xpath="//input[@name='selected_id']")
	private WebElement selectcheckbox;
	
	public WebElement getSelectcheckbox() {
		return selectcheckbox;
	}
	
	
	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement deletebtn;
	
	public WebElement getDeletebtn() {
		return deletebtn;
	}

}
