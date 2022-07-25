package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orglinkbtn;
	
	
	public WebElement getOrglinkbtn() {
		return orglinkbtn;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutbtn;
	
	
	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutlinkbtn;
	
	public WebElement getSignoutlinkbtn() {
		return signoutlinkbtn;
	}

	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactlinkbtn;
		
	
	public WebElement getContactlinkbtn() {
		return contactlinkbtn;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreoptlinkbtn;
	
	public WebElement getMoreoptlinkbtn() {
		return moreoptlinkbtn;
	}
	
	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement camplinkbtn;
	
	public WebElement getCamplinkbtn() {
		return camplinkbtn;
	}
	
	@FindBy(xpath="//td[@class='tabSelected']")
	private WebElement campinfolnkbtn;
	
	public WebElement getCampinfolnkbtn() {
		return campinfolnkbtn;
	}

	
}
