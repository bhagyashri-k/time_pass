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
	

}
