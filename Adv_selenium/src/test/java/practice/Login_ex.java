package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_ex {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream file=new FileInputStream("C:\\Users\\yhtro\\OneDrive\\Documents\\login.xlsx");
		
		Workbook book =  WorkbookFactory.create(file);
		
		Sheet sheet= book.getSheet("Sheet1");
		
		Row row = sheet.getRow(1);
		
		String email = row.getCell(0).getStringCellValue();
		
		String pass = row.getCell(1).getStringCellValue();
		
		book.close();
		
		file.close();

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/login/");
		
		WebElement username = driver.findElement(By.id("email"));
		
	    WebElement password = driver.findElement(By.id("pass"));
	    
	    username.sendKeys(email);
	    
	    password.sendKeys(pass);
		
		driver.findElement(By.name("login")).click();
	}

}
