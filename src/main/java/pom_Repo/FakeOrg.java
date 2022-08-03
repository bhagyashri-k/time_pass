package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FakeOrg {
	
	WebDriver driver;
	public FakeOrg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement crtcamplinkbtn;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement existcmptxtbox;
	
	@FindBy(xpath="//select [@id='bas_searchfield']")
	private WebElement campnmDD;
	
	public WebElement getCrtcamplinkbtn() {
		return crtcamplinkbtn;
	}

	public WebElement getExistcmptxtbox() {
		return existcmptxtbox;
	}

	public WebElement getCampnmDD() {
		return campnmDD;
	}
	
	

}
