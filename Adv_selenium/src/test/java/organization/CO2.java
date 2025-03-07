package organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.Base_class;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import pom_repo.LoginPageEx;



public class CO2 extends Base_class {

	public static void main(String[] args) throws Throwable {
		
//		FileInputStream fis = new FileInputStream("./src/test/resources/vtiger.properties");
//
//		
//		Properties pro = new Properties();
//		pro.load(fis);
//
//		
//		String BROWSER = pro.getProperty("browser");
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("userName");
//		String PASSWORD = pro.getProperty("password");

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

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
//-------------------------------------------------------------------------------------------------

		String mailId = elib.readDataUsingDataFormatter("Data_Sheet2", 2, 0);
		
		driver.findElement(By.id("email1")).sendKeys(mailId);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//------------------------------------------------------------------------------------------
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