package com.vtiger.generic;

public interface IAutoconstants {
	
	String currentdirectory = System.getProperty("user.dir");
	
	String propertyfile = currentdirectory+"/SDET7.PROPERTIES";
	
	String excelfile = currentdirectory+"/SDET7.xlsx";
	
	String screenshotfile = currentdirectory+"/ScreenShot/";
	
	String extentreportfile = currentdirectory+"/ExtentReport/VTiger.html";

}
