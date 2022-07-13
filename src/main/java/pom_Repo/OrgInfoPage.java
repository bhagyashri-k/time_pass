package pom_Repo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {
	
	WebDriver driver;
	public OrgInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createorglinkbtn;
	
	
	public WebElement getCreateorglinkbtn() {
		return createorglinkbtn;
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgnamesavedtxt;
	
	public WebElement getOrgnamesavedtxt() {
		return orgnamesavedtxt;
	}

	@FindBy(xpath="//td[@id='mouseArea_Organization Name']")
	private WebElement orgnameexisttxtbox;
	
	
	public WebElement getOrgnameexisttxtbox() {
		return orgnameexisttxtbox;
	}


	


	

}
