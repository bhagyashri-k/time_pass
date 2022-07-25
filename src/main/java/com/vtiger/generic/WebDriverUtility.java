package com.vtiger.generic;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	WebDriver driver;
	
	
	public WebDriverUtility(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public void maximixzWindow()
	{
		driver.manage().window().maximize();
	}
	public void pageLoadTime()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void waitandClick(WebElement element )
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	public void selectDropD(String visibleT, WebElement element) {
		 Select select = new Select(element);
		 select.selectByVisibleText(visibleT);
	}
	
	public void selectDropD( WebElement element, String value) {
		 Select select = new Select(element);
		 select.selectByValue(value);
	}
	
	public void selectDropD( WebElement element, int i) {
		 Select select = new Select(element);
		 select.selectByIndex(i);
	}
	
	public void moveToElement(WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public void closeBrowser()
	{
		driver.close();
	}
	
	public void refresgPage()
	{
		driver.navigate().refresh();
	}
	
	public void  acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
//	public void windowHandle()
//	{
//		String main_page = driver.getWindowHandle();
//		Set<String> all_page = driver.getWindowHandles();
//
//		for(String i : all_page)
//		{
//			if(!i.equals(main_page))
//			{
//				driver.switchTo().window(i);
//			}
//		}
//	}
//	public void  mainWindow()
//	{
//		driver.switchTo().window(main_page);
//	}
}
