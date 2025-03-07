package organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.openqa.selenium.interactions.Actions;

import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;
import pom_repo.LoginPageEx;

public class create_new {

	public static void main(String[] args) throws Throwable {


		File_Utility flib= new File_Utility();

		String BROWSER   = flib.getKeyAndValueData("browser");

		String URL       =flib.getKeyAndValueData("url");

		String USERNAME  = flib.getKeyAndValueData("username");

		String PASSWORD  = flib.getKeyAndValueData("password");

		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		driver.get(URL);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		 LoginPageEx login = new LoginPageEx(driver);
		 login.loginToApp(USERNAME, PASSWORD);

		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.loadTheElements(driver);

		driver.findElement(By.linkText("Products")).click();

		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();


		 Java_Utility jlib =new Java_Utility();

    	 int ranum = jlib.getRandomValue();


		Excel_Utility elib = new Excel_Utility();
		String PrdName = elib.getExcelData("Product", 0, 0);
		System.out.println(PrdName);

		driver.findElement(By.name("productname")).sendKeys(PrdName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
//-----------------------------------------------------------------------------------------------------------
		
		WebElement moreLink = driver.findElement(By.linkText("More"));

		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();


		String CampName = elib.getExcelData("Data_Sheet2", 0, 0);
		System.out.println(CampName);

		driver.findElement(By.name("campaignname")).sendKeys(CampName);
		
		driver.findElement(By.xpath("//img[@alt=\"Select\"]")).click();
		
		Set<String> allWins = driver.getWindowHandles();//win1//win2
		Iterator<String> it = allWins.iterator();
	
		while (it.hasNext())
		{
			String win = it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
		if(title.contains("Products&action"))
		{
			break;
		}
		}
	driver.findElement(By.name("search_text")).sendKeys(PrdName);
	driver.findElement(By.cssSelector("[name=\"search\"]")).click();
	
	//Dynamic Xpath
	driver.findElement(By.xpath("//a[text()='"+PrdName+"']")).click();
	
	Set<String> allWins1 = driver.getWindowHandles();
	Iterator<String> it1 = allWins1.iterator();

	while (it1.hasNext())
	{
		String win1 = it1.next();
		driver.switchTo().window(win1);
		String title1 = driver.getTitle();
	if(title1.contains("Campaigns&action"))
	{
		break;
	}
	}
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	 String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

		if(actData.contains(CampName))
		{
			System.out.println("Campaigns Name is Created");
		}
		else
		{
			System.out.println("Campaigns name not created");
		}


		String actData1 = driver.findElement(By.xpath("//span[@id=\"dtlview_Product\"]")).getText();
		if (actData1.equals(PrdName)) {
			System.out.println("Product Name is Created");
		} else {
			System.out.println("Product name is not created");
		}

		WebElement AmdLink = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));

		//Logout
		act.moveToElement(AmdLink).perform();
		driver.findElement(By.linkText("Sign Out")).click();

 		
 		
	}

}
