package com.testNG.practice;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.genericlib.BaseClass;
import com.vtiger.generic.IAutoconstants;

public class ListenerImpliments extends BaseClass implements ITestListener 
{
	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName());
		System.out.println("Test Started");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("TC Pass");
		test.log(Status.PASS,result.getMethod().getMethodName()+" got Pass");

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("TC fail");

		test.log(Status.FAIL, result.getMethod().getMethodName()+"got Fail");
		test.log(Status.FAIL,result.getThrowable());
		String path;
		try {
			path=BaseClass.takeScreenshot(result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("TC Skip");
		test.log(Status.SKIP,result.getMethod().getMethodName()+" got Skip");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		System.out.println("On Start");
		reporter = new ExtentSparkReporter(IAutoconstants.extentreportfile);
		reporter.config().setDocumentTitle("First Screenshot");
		reporter.config().setTheme(Theme.STANDARD);

		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Application version", "5.0.5");
		reports.setSystemInfo("Brwoser", "chrome");
		reports.setSystemInfo("Created By", "Testing Team");


	}

	public void onFinish(ITestContext context) {


		reports.flush();
		System.out.println("At last");

	}



}
