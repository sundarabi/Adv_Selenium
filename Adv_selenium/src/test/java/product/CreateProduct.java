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
import org.testng.annotations.Test;

import generic_utility.Base_class;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;


public class CreateProduct extends Base_class{
	
		@Test(groups = {"smokeTest","regressionTest"})
		public void CreateProductTest() throws Throwable {

			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();

			Java_Utility jlib = new Java_Utility();
			int ranNum = jlib.getRandomValue();

			Excel_Utility elib = new Excel_Utility();
			String PrdName = elib.getExcelData("Product", 0, 0) + ranNum;

			driver.findElement(By.name("productname")).sendKeys(PrdName);
			driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			String actdata = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
			if (actdata.contains(PrdName)) {
				System.out.println("Product name is created");
			} else {
				System.out.println("Product name is not created");
			}
	}

}


