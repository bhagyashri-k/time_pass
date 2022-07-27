package practice;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports {

	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	@Test
	public void reportCreation() throws IOException
	{
		reporter = new ExtentSparkReporter("../SDET7_BHA/new.html");
		reporter.config().setDocumentTitle("First Screenshot");
		reporter.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Application version", "5.0.5");
		reports.setSystemInfo("Brwoser", "chrome");
		reports.setSystemInfo("Env", "QA");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		test=reports.createTest("ScreenShot143");
		
		TakesScreenshot screens = (TakesScreenshot)driver;
		File file = screens.getScreenshotAs(OutputType.FILE);
		String path = "../SDET7_BHA/ScreenShot/amoz1.png";
		File dest = new File(path);
		FileUtils.copyFile(file, dest);

		test.addScreenCaptureFromPath(path);
		reports.flush();
	}

}
