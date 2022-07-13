package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {

	

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("../SDET7_BHA/SDET7.xlsx");
		Workbook book =  WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet("Sheet1");
		int ro = sheet.getLastRowNum();
		 
		for(int i=1; i<=ro; i++)
		{
			Cell sal=sheet.getRow(i).getCell(2);
			int salary = (int)sal.getNumericCellValue();
			if(salary>15000)
			{
				Cell String = sheet.getRow(i).getCell(1);
				System.out.println(String);
			}
			
		}

	}
}
