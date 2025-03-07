package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class fetch_data_excel {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis =new FileInputStream("./src/test/resources/data_fetch.xlsx");
	
		Workbook book= WorkbookFactory.create(fis);
		
		Sheet sheet= book.getSheet("Data_Sheet1");
		  
		Row row=sheet.getRow(0);
		
		Cell cell= row.getCell(0);
		//Date val = cell.getDateCellValue();
		
		 String EXvalue = cell.getStringCellValue();
		
		System.out.println("Exceldata: "+EXvalue);
	     
	
	
	}

}
