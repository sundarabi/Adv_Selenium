package product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;
import object_Repository.VtigerHomePage;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {
	
File_Utility flib = new File_Utility();
WebDriver_Utility wlib = new WebDriver_Utility();
Excel_Utility elib = new Excel_Utility();
Java_Utility jlib = new Java_Utility();

WebDriver driver;
String BROWSER = flib.getKeyAndValueData("browser");
  if(BROWSER.equalsIgnoreCase("chrome"))
  {
 	 driver=new ChromeDriver();
  }
  else
  {
  if(BROWSER.equalsIgnoreCase("edge"))
 	 {
 		 driver=new EdgeDriver();
 	 }
	 else
 	 {
 if(BROWSER.equalsIgnoreCase("firefox"))
 		{
 			driver=new FirefoxDriver();
 		}
 else
 		{
 			driver=new ChromeDriver();
 		}
 	 }
  }
		wlib.maximizeWindow(driver);
		wlib.loadTheElements(driver);
		

		String URL = flib.getKeyAndValueData("url");
		String USERNAME =flib.getKeyAndValueData("username");
    	String PASSWORD = flib.getKeyAndValueData("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
        driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
        
        int ranNum = jlib.getRandomValue();
       String prdData = elib.getExcelData("Product", 0, 0)+ranNum;
		
        driver.findElement(By.name("productname")).sendKeys(prdData);
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(3000);
		VtigerHomePage home = new VtigerHomePage(driver);
		home.logOut(driver);
		
	}

}


