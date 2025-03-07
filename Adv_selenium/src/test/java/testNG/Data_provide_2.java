package testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_provide_2 {

	
           @Test(dataProvider="readData")
			public void createOrganization(String name, String phoNum, String mailId) throws Throwable{

			WebDriver driver =new ChromeDriver();

			driver.get("http://localhost:8888");

			driver.manage().window().maximize();

			driver.findElement(By.name("user_name")).sendKeys("admin");

			driver.findElement(By.name("user_password")).sendKeys("pass");

			driver.findElement(By.id("submitButton")).click();

			driver.findElement(By.linkText("Organizations")).click();


			driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();

			driver.findElement(By.name("accountname")).sendKeys(name); 
			
			driver.findElement(By.name("phone")).sendKeys(phoNum);

			driver.findElement(By.name("email1")).sendKeys(mailId);

			driver.findElement(By.xpath("//input[@accesskey='S']")).click();

			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();

			driver.findElement(By.linkText("Sign Out")).click();

			driver.quit();
           }
           
           @DataProvider
       	public Object[][] readData() throws IOException

       	{
        	   Random ran = new Random();

        	   int ranNum = ran.nextInt(1000);

//       		Object[][] objArr = new Object[3][3];
//
//       		objArr[0][0]="sundar"+ranNum;
//
//       		objArr[0][1]="876545678";
//       		
//       		objArr[0][2]="sundar@gmail.com";
//
//       		objArr[1][0]="Govind"+ranNum;
//
//       		objArr[1][1]="9234567899";
//       		
//       		objArr[1][2]="govind@gmail.com";
//
//       		objArr[2][0]="tamy"+ranNum;
//
//       		objArr[2][1]="345678932";
//       		
//       		objArr[2][2]="lonely@gmail.com";
        	   
        	   

//       		return objArr;
        	   
        	   String filePath = "./src/test/resources/data_fetch.xlsx";
               FileInputStream fis = new FileInputStream(filePath);
               Workbook book = WorkbookFactory.create(fis);           
               Sheet sheet = book.getSheet("Data_provider");
               
               int rowCount = sheet.getPhysicalNumberOfRows();
               Object[][] data = new Object[rowCount - 1][3]; // Excluding header row

               for (int i = 1; i < rowCount; i++) { // Start from row 1 (skip headers)
                   Row row = sheet.getRow(i);
                   data[i - 1][0] = row.getCell(0).getStringCellValue(); // Name
                   data[i - 1][1] = row.getCell(1).getStringCellValue(); // Phone
                   data[i - 1][2] = row.getCell(2).getStringCellValue(); // Email
               }
               book.close();
               return data;
       	}
}
