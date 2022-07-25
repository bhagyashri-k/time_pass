package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContPg {
	
	WebDriver driver;
	public CreateContPg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement firstnamedd;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement fristnametxtbox;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastnametxtbox;
	
	public WebElement getFirstnamedd() {
		return firstnamedd;
	}

	public WebElement getFristnametxtbox() {
		return fristnametxtbox;
	}

	public WebElement getLastnametxtbox() {
		return lastnametxtbox;
	}
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement orgnamelinkbtn;
	
	public WebElement getOrgnamelinkbtn() {
		return orgnamelinkbtn;
	}
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement contsavebtn;
	
	public WebElement getContsavebtn() {
		return contsavebtn;
	}

	

}
