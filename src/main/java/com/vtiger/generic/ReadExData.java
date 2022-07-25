package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExData {

	public String readExcelData(String path, String sh, int ro, int cel) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(fis);		
		return book.getSheet(sh).getRow(ro).getCell(cel).toString();
	}
	
	public int lastRowcount(String path,String sheet) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fileInputStream = new FileInputStream(path);
		Workbook workbook=WorkbookFactory.create(fileInputStream);
		return	workbook.getSheet(sheet).getLastRowNum();

	}

	

}
