package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Fetch_num_ex {

	public static void main(String[] args) throws Throwable {

		FileInputStream file=new FileInputStream("./src/test/resources/data_fetch.xlsx");
		
		Workbook book= WorkbookFactory.create(file);
		
		Sheet sheet=book.getSheet("Data_Sheet1");
		
		Row row= sheet.getRow(2);
		
		Cell cell= row.getCell(0);
		
		 int data = (int) cell.getNumericCellValue();
		
		System.out.println("number : "+data);
	}

}
