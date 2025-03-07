package organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import generic_utility.Base_class;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;
import pom_repo.CampLookUpImg;
import pom_repo.CampValidatePage;
import pom_repo.CreateCampPage;
import pom_repo.CreateProductPage1;
import pom_repo.HomePage;
import pom_repo.LoginPageEx;
import pom_repo.ProductLookUpImg;
import pom_repo.WindowSwitchingPage;

public class campcreateWpro extends Base_class{
    public static void main(String[] args) throws Throwable {
//  String PrdName = elib.getExcelData("Product", 0, 0)+ranNum;
//String campNAme = elib.getExcelData("Data_Sheet2", 0, 0)+ranNum;    	
    	File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

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
        
		LoginPageEx login = new LoginPageEx(driver);
		login.loginToApp(USERNAME, PASSWORD);

		HomePage home = new HomePage(driver);
		home.getPrdLink();

		ProductLookUpImg lookUp = new ProductLookUpImg(driver);
		lookUp.prdLookUpImg();

		int ranNum = jlib.getRandomValue();
		String PrdName = elib.getExcelData("Product", 0, 0) + ranNum;

		CreateProductPage1 prdPage = new CreateProductPage1(driver);
		prdPage.enterPrdName(PrdName);
		prdPage.clickSaveButton();
		// ---------------------------------------------------------------------------------------------------

		home.clickCampLink();

		CampLookUpImg lookUp1 = new CampLookUpImg(driver);
		lookUp1.clickCampLookUpImg();

		String campNAme = elib.getExcelData("Data_Sheet2", 0, 0)+ranNum;    	

		WindowSwitchingPage window = new WindowSwitchingPage(driver);
		window.clickPrdPlusSign();

		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampName(campNAme);

		wlib.windowSwitching(driver, "Products&action");
		window.enterPrdName(PrdName);
		window.clickprdSearchBar();
		window.selectPrdName(driver, PrdName);

		wlib.windowSwitching(driver, "Campaigns&action");
		campPage.clickSaveButton();

		CampValidatePage Validatecamp = new CampValidatePage(driver);
		Validatecamp.ValidateCamp(driver, campNAme);
		Validatecamp.ValidatePrd(driver, PrdName);

		home.logOut();

	}
    
}