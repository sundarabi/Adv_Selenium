package organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_utility.Base_class;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;
import pom_repo.LoginPageEx;

public class create_camp extends Base_class {

	public static void main(String[] args) throws Throwable {



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

		//driver.manage().window().maximize();
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.loadTheElements(driver);
		
    	  
    	 driver.get(URL);
    	 
//    	 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//    	 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);	
//    	 driver.findElement(By.id("submitButton")).click();
    	 
    	 LoginPageEx login = new LoginPageEx(driver);
 		login.loginToApp(USERNAME, PASSWORD);
    	
    	 driver.findElement(By.linkText("Products")).click();
    	 driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
    	 
    	

    	
    	 Java_Utility jlib =new Java_Utility();

    	 int ranum = jlib.getRandomValue();


		Excel_Utility elib = new Excel_Utility();
		String PrdName = elib.getExcelData("Data_Sheet2",0,0)+ranum;
		System.out.println(PrdName);
		
		driver.findElement(By.name("productname")).sendKeys(PrdName);
		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
    	 
		Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
        System.out.println("Product created successfully!");

      
        driver.findElement(By.linkText("Products")).click();

       
        driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + PrdName
				+ "']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();

		driver.switchTo().alert().accept();



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
		
		driver.quit();
	}

}
