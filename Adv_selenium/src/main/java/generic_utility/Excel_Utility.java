package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {


	/**
	 * This method is used to read data from excel file
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 * @throws Throwable
	 * @author Shobha
	 */
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable {
		// step1:- connecting the excel file
		FileInputStream file = new FileInputStream(Paths.excelpath);

		// step2:- keep excel in read mode
		Workbook book = WorkbookFactory.create(file);

		// step3:- navigate into excel sheet
		Sheet sheet = book.getSheet(sheetName);

		// step4:- navigate into row
		Row row = sheet.getRow(rowNum);

		// step5:-navigate into cell
		Cell cell = row.getCell(cellNum);

		String excelData = cell.getStringCellValue();
		System.out.println(excelData);
		return excelData;
	}

//-----------------------------------------------------------------------------------------------------------	
	public String readDataUsingDataFormatter(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream file = new FileInputStream(Paths.excelpath);

		// step2:- keep excel in read mode
		Workbook book = WorkbookFactory.create(file);

		// step3:- navigate into excel sheet
		Sheet sheet = book.getSheet(sheetName);

		// step4:- navigate into row
		Row row = sheet.getRow(rowNum);

		// step5:-navigate into cell
		Cell cell = row.getCell(cellNum);

		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell);
		System.out.println(ExcelData);
		return ExcelData;

	}

	// --------------------------------------------------------------------------------------------------------
	public Object[][] readExcelDataForDataProvider(String sheetName) throws Throwable, IOException {
		FileInputStream file = new FileInputStream(Paths.excelpath);

		// step2:- keep excel in read mode
		Workbook book = WorkbookFactory.create(file);

		// step3:- navigate into excel sheet
		Sheet sheet = book.getSheet(sheetName);

		int lastRow = sheet.getLastRowNum()+1;
		short lastCell = sheet.getRow(0).getLastCellNum();

		Object[][] objArr = new Object[lastRow][lastCell];
		for (int i = 0; i < lastRow; i++) {
			for (int j = 0; j < lastCell; j++) {
				objArr[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return objArr;

	}
	
}

