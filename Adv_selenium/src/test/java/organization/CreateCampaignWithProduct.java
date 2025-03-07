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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;
import object_Repository.CampWithPrdWindowSwitching;
import object_Repository.CreateCampaignPage;
import object_Repository.CreateProductPage;
import object_Repository.VtigerHomePage;
import object_Repository.VtigerLoginPage;

public class CreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable {
		
        File_Utility flib = new File_Utility();	
        Java_Utility jlib = new  Java_Utility();
        Excel_Utility elib = new Excel_Utility();
        WebDriver_Utility wlib = new WebDriver_Utility();
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
		VtigerLoginPage login = new VtigerLoginPage(driver);
		login.loginToVitigerApp(USERNAME, PASSWORD);
		
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickProductLink();
		
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickOnPlusSign();
	      
	    int ranNum = jlib.getRandomValue();
	     
	    String prdData = elib.getExcelData("Product", 0, 0)+ ranNum;  
			         
	    prdPage.enterProductName(prdData);
	    prdPage.clickOnSaveButton();
	        
	    home.clickMoreLink();
	    home.clickCampaignsLink();
		
		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.clickOnPlusSign();
	
		String campData = elib.getExcelData("Data_Sheet3", 0, 0)+ranNum;
		campPage.enterCampaignName(prdData);

		CampWithPrdWindowSwitching Switching = new CampWithPrdWindowSwitching(driver);
		Switching.clickOnPrdPlusSign();
		
        wlib.windowSwitching(driver, "Products&action");
	    
        Switching.enterPrdName(prdData);
        Switching.searchPrdName();
        
	//  driver.findElement(By.xpath("//a[text()='Bluetooth202']")).click();
	    
	 //   driver.findElement(By.xpath("//a[text()='"+prdData+"']")).click();
        Switching.prdDynamicElement(driver, prdData);
	
	    wlib.windowSwitching(driver, "Campaigns&action");
	    
	    campPage.clickOnSaveButton();
			
		Thread.sleep(2000);
		home.logOut(driver);
		}

}
