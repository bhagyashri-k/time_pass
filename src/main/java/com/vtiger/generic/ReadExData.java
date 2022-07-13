package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExData {

	public String readExcelData(String path, String sh, int ro, int cel) throws Throwable {
		FileInputStream fis = new FileInputStream("../SDET7_BHA/src/main/java/SDET711.xlsx");
		Workbook book = WorkbookFactory.create(fis);
//		 Sheet sh = book.getSheet(sh);
//		Row ro = sh.getRow(ro);
//		ro.ge
		
		return book.getSheet(sh).getRow(ro).getCell(cel).toString();
	}

}
