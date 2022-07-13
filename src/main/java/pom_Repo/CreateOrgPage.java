package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {
	
	WebDriver driver;
	public CreateOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgnametxtbox;
	
	
	public WebElement getOrgnametxtbox() {
		return orgnametxtbox;
	}
	
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement orgsavebtn;
	
	
	public WebElement getOrgsavebtn() {
		return orgsavebtn;
	}
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homepagebtnlink;
	
	public WebElement getHomepagebtnlink() {
		return homepagebtnlink;
	}
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industryDD;
	
	
	public WebElement getIndustryDD() {
		return industryDD;
	}

	@FindBy(xpath="//select[@name='rating']")
	private WebElement ratingdropD;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement acctypeDD;
	
	
	public WebElement getRatingdropD() {
		return ratingdropD;
	}

	public WebElement getAcctypeDD() {
		return acctypeDD;
	}


	

//	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
//	private WebElement logoutbtn;
//	
//	
//	public WebElement getLogoutbtn() {
//		return logoutbtn;
//	}
//	
//	@FindBy(xpath="//a[text()='Sign Out']")
//	private WebElement signoutlinkbtn;
//	
//	public WebElement getSignoutlinkbtn() {
//		return signoutlinkbtn;
//	}

	

	

	
	
//	@FindBy(xpath="//span[@class='dvHeaderText']")
//	private WebElement orgnamesavedtxt;
//	
//	public WebElement getOrgnamesavedtxt() {
//		return orgnamesavedtxt;
//	}
//
//	@FindBy(xpath="//td[@id='mouseArea_Organization Name']")
//	private WebElement orgnameexisttxtbox;
//	
//	
//	public WebElement getOrgnameexisttxtbox() {
//		return orgnameexisttxtbox;
//	}

	
}
