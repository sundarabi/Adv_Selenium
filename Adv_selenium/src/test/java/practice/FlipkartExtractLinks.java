package practice;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FlipkartExtractLinks {
    public static void main(String[] args) throws Throwable {
    	
    	
      FileInputStream fis =new FileInputStream("./src/test/resources/data_fetch.xlsx");
		
		Workbook book= WorkbookFactory.create(fis);
		
		Sheet sheet= book.getSheet("Data_Sheet1");
        
        WebDriver driver = new ChromeDriver();

            driver.get("https://www.flipkart.com/");

            driver.manage().window().maximize();

            List<WebElement> links = driver.findElements(By.xpath("//a"));
            
            for(int i=0;i<links.size();i++) {
            	
            	Row row = sheet.createRow(i);
            	
            	Cell cell = row.createCell(0);
            	
            	cell.setCellValue(links.get(i).getAttribute("href"));
            	
            }
            
           FileOutputStream fos = new FileOutputStream("./src/test/resources/data_fetch.xlsx");

           book.write(fos);
           book.close();
           
           FileInputStream fisRead = new FileInputStream("./src/test/resources/data_fetch.xlsx");
           Workbook bookRead = WorkbookFactory.create(fisRead);
           Sheet sheetRead = bookRead.getSheet("Data_Sheet1");

           for (Row row : sheetRead) {
               Cell cell = row.getCell(0);
               if (cell != null) {
                   System.out.println(cell.getStringCellValue());
               }
           }
           bookRead.close();
        }
    }

