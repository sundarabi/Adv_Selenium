package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;

public class CreateProductAndDeleteProduct {

	public static void main(String[] args) throws Throwable {
	
		WebDriver_Utility wlib = new WebDriver_Utility();
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		File_Utility flib = new File_Utility();

		String BROWSER = flib.getCommonData("browser");
		String URL = flib.getCommonData("url");
		String USERNAME = flib.getCommonData("username");
		String PASSWORD = flib.getCommonData("password");

		WebDriver driver;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		wlib.maximizeWindow(driver);
		wlib.loadTheElements(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		
		int ranNum = jlib.getRandomValue();
		
		// step1:- connecting the excel file
		FileInputStream file = new FileInputStream("./src/test/resources/ExcelData3.xlsx");
		String PrdName = elib.getExcelData("Product", 0, 0)+ranNum;

		driver.findElement(By.name("productname")).sendKeys(PrdName);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		String actdata = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
		if (actdata.contains(PrdName)) {
			System.out.println("Product name is created");
		} else {
			System.out.println("Product name is not created");
		}
		driver.findElement(By.linkText("Products")).click();

//	driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='Product Name']/../preceding-sibling::td[@class='lvtCol']//input[@type=\"checkbox\"]")).click();

		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + PrdName
				+ "']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();

//		driver.switchTo().alert().accept();
		wlib.alertAccept(driver);

//	WebElement data = driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+PrdName+"']"));
//	
//	if(data.equals(PrdName))
//	{
//		System.out.println("product name is present");
//	}
//	else
//	{
//		System.out.println("product name is not present");
//	}

		List<WebElement> prdList = driver
				.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));

		boolean flag = false;
		for (WebElement prd : prdList) {

			String actData = prd.getText();
			if (actData.contains(PrdName)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("Product name is deleted");
		}

		else {
			System.out.println("Product name is not deleted");
			
			String month = "March";
			
			driver.findElement(By.xpath("//div[text()='"+month+"']/../..//p[text()='10']"));
		}
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

	}



