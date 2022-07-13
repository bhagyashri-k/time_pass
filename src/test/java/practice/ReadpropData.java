package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadpropData {

	public static WebDriver driver;
	public static void main(String[] args) throws Exception {
		
		
		FileInputStream fis = new FileInputStream("../SDET7_BHA/SDET7.PROPERTIES");
		Properties prop = new Properties();
		prop.load(fis);
		String str = prop.getProperty("url");
		System.out.println(str);
		//driver.get(str);
		
		

	}

}
