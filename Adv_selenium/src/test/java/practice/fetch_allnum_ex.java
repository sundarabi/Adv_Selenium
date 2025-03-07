package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fetch_allnum_ex {

	public static void main(String[] args) throws Throwable {

		FileInputStream file= new FileInputStream("./src/test/resources/data_fetch.xlsx");
		
		Workbook book = WorkbookFactory.create(file);
		
		Sheet sheet = book.getSheet("Data_Sheet1");
		
		for(int i=1;i<6;i++) {
		
		Row row= sheet.getRow(i);
		
		Cell cell= row.getCell(0);
		
	   // long phone_num = (long) cell.getNumericCellValue();
	    
	   // System.out.println("phone number : "+phone_num);
		
		DataFormatter format = new DataFormatter();

		String excelData = format.formatCellValue(cell); System.out.println(excelData);
		
		}
		
	}}
