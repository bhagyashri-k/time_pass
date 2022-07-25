package com.dataprovide;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.generic.ReadExData;

public class Excel_DataProvide {


	ReadExData excelUtility = new ReadExData();

	@Test(dataProvider="getValue")
	public void excelData(String src, String dest, String dist)
	{
		System.out.println(src +" ----> "+dest+" Distance is "+dist);
	}
	@DataProvider
	public Object[][] getValue() throws Throwable
	{
		int rowcount = excelUtility.lastRowcount("../SDET7_BHA/SDET7.xlsx", "Sheet2");
		Object [][] arr = new Object[rowcount+1][3];

		for(int i=1; i<rowcount+1; i++)
		{
			arr[i][0] = excelUtility.readExcelData("../SDET7_BHA/SDET7.xlsx", "Sheet2",i,0);
			arr[i][1] = excelUtility.readExcelData("../SDET7_BHA/SDET7.xlsx", "Sheet2",i,1);
			arr[i][2] = excelUtility.readExcelData("../SDET7_BHA/SDET7.xlsx", "Sheet2",i,2);
		}
		return arr;

	}




}
