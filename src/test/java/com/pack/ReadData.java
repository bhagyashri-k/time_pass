package com.pack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.vtiger.generic.ReadExData;

public class ReadData {

	public static void main(String[] args) throws Throwable {
		
//		FileInputStream fis = new FileInputStream("../SDET7_BHA/src/test/java/com/pack/SDET711.xlsx");
//		Workbook book = WorkbookFactory.create(fis);		
//		Sheet sh = book.getSheet("Sheet1");
//		Row ro = sh.getRow(2);
//		Cell cel = ro.getCell(0);
//		String str = cel.toString();
		
		ReadExData data = new ReadExData();
		
		String str = data.readExcelData("../SDET7_BHA/src/main/java/SDET711.xlsx","Sheet1", 2,0);
		
		System.out.println(str);

	}

}
