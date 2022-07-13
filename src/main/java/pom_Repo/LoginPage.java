package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernametxtbox;
	
	@FindBy(name="user_password")
	private WebElement passwordtxtbox;
	
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	
	
	public WebElement getUsernametxtbox() {
		return usernametxtbox;
	}

	public WebElement getPasswordtxtbox() {
		return passwordtxtbox;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}


	

}
