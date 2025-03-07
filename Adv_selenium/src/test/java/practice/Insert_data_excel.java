package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Insert_data_excel {

	public static void main(String[] args) throws Throwable, IOException {

		FileInputStream fis =new FileInputStream("./src/test/resources/data_fetch.xlsx");
		
		Workbook book= WorkbookFactory.create(fis);
		
		Sheet sheet= book.getSheet("Data_Sheet1");
		  
	    
	    Row row = sheet.createRow(5);
		
		Cell cell = row.createCell(5);
		
		cell.setCellValue("Nike");
		
		FileOutputStream fos =new FileOutputStream("./src/test/resources/data_fetch.xlsx");

	    book.write(fos);
	    book.close();
		
	}

}
