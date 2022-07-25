package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPg {
	
	WebDriver driver;
	public ContactInfoPg(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createcontbtn;
	
	public WebElement getCreatecontbtn() {
		return createcontbtn;
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement savedcontHeadtxt;
	
	public WebElement getSavedcontHeadtxt() {
		return savedcontHeadtxt;
	}

	

}
