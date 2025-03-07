package organization;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;
import pom_repo.LoginPageEx;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

public class Create_organisation {
    public static void main(String[] args) throws Throwable {

    	WebDriver_Utility wlib = new WebDriver_Utility();

		File_Utility flib= new File_Utility();
		

		String BROWSER   = flib.getKeyAndValueData("browser");

		String URL       =flib.getKeyAndValueData("url");

		String USERNAME  = flib.getKeyAndValueData("username");
		
		String PASSWORD  = flib.getKeyAndValueData("password");
		
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
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		 LoginPageEx login = new LoginPageEx(driver);
		 login.loginToApp(USERNAME, PASSWORD);

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomValue();
		Excel_Utility elib = new Excel_Utility();
		String OrgName = elib.getExcelData("Data_Sheet2", 0, 0) + ranNum;
		
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		


		String phnNum = elib.readDataUsingDataFormatter("Data_Sheet2", 1, 0);
		driver.findElement(By.name("phone")).sendKeys(phnNum);
		
		
		String mailId = elib.readDataUsingDataFormatter("Data_Sheet2", 2, 0);
	
		driver.findElement(By.id("email1")).sendKeys(mailId);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();

		if (actData.contains(OrgName)) {
			System.out.println("Organization is created");
		} else {
			System.out.println("Organization is not created");
		}

		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
    }
}
