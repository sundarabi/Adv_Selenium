package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_utility.Base_class;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;

import pom_repo.CampLookUpImg;
import pom_repo.CampValidatePage;
import pom_repo.CreateCampPage;
import pom_repo.HomePage;
import pom_repo.LoginPageEx;

//@Listeners (generic_utility.Listeners.class)

@Listeners(generic_utility.Extent_Report.class)

public class CreateCampaigns extends Base_class{

	//@Test(retryAnalyzer =generic_utility.RetryAnalysering.class)
	@Test
	public void CreateCampaigns() throws Throwable {
		HomePage home = new HomePage(driver);
		home.clickCampLink();

		CampLookUpImg campImg = new CampLookUpImg(driver);
		campImg.clickCampLookUpImg();

		int ranNum = jlib.getRandomValue();

		String campNAme = elib.getExcelData("Data_Sheet3", 0, 0) + ranNum;

		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampName(campNAme);
		campPage.clickSaveButton();
       // Assert.fail("im failing the TestScript");
		
		CampValidatePage validate = new CampValidatePage(driver);
		validate.ValidateCamp(driver);
		//String actData = validate.ValidateCamp(driver,campNAme);
		//Assert.assertEquals(actData, campNAme);
		System.out.println("campName is created");
	}
}
