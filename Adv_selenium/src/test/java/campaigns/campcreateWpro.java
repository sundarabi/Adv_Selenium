package campaigns;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.Base_class;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;
import pom_repo.CampLookUpImg;
import pom_repo.CampValidatePage;
import pom_repo.CreateCampPage;
import pom_repo.CreateProductPage;
import pom_repo.HomePage;
import pom_repo.LoginPageEx;
import pom_repo.ProductLookUpImg;
import pom_repo.WindowSwitchingPage;

public class campcreateWpro extends Base_class{
	
	@Test(groups = "smokeTest")
		public void campcreateWpro() throws Throwable {

			WebDriver_Utility wlib = new WebDriver_Utility();

			HomePage home = new HomePage(driver);
			home.clickPrdLink();

			ProductLookUpImg lookUp = new ProductLookUpImg(driver);
			lookUp.prdLookUpImg();

			int ranNum = jlib.getRandomValue();
			String PrdName = elib.getExcelData("Product", 0, 0) + ranNum;

			CreateProductPage prdPage = new CreateProductPage(driver);
			prdPage.enterPrdName(PrdName);
			prdPage.clickSaveButton();
			// ---------------------------------------------------------------------------------------------------

			home.clickCamp();

			CampLookUpImg lookUp1 = new CampLookUpImg(driver);
			lookUp1.clickCampLookUpImg();

			String campNAme = elib.getExcelData("Data_Sheet3", 0, 0) + ranNum;
			// driver.findElement(By.name("campaignname")).sendKeys(campNAme);

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
			CampValidatePage validate = new CampValidatePage(driver);
			//validate.ValidateCamp(driver, campNAme);
			String actData = validate.ValidateCamp(driver);
			Assert.assertEquals(actData, campNAme);
			System.out.println("campName is created");
			
			Validatecamp.ValidatePrd(driver, PrdName);

		}
	}
    
