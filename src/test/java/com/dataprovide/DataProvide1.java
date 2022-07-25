package com.dataprovide;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvide1 {
	
	@Test(dataProvider = "getValue")
	public void testdata(String src, String dest) {
		System.out.println(src + " ----> "+dest);
	}
	
	@DataProvider
	public Object[][] getValue()
	{
		Object [][]  arr = new Object[4][2];
		
		arr[0][0] = "HYD";
		arr[0][1] = "MOB";
		
		arr[1][0] = "CHN";
		arr[1][1] = "DHL";
		
		arr[2][0] = "MOB";
		arr[2][1] = "DUBI";
		
		arr[3][0] = "DHL";
		arr[3][1] = "Cond";
				
		return arr;
	}
}
