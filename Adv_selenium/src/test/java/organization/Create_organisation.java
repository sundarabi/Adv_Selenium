package organization;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import generic_utility.Base_class;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;
import pom_repo.CreateOrgPage;
import pom_repo.HomePage;
import pom_repo.LoginPageEx;
import pom_repo.OrgLookUp;
import pom_repo.ValidateOrg;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

public class Create_organisation extends Base_class {
	
	@Test(retryAnalyzer =generic_utility.RetryAnalysering.class)
	public void CreateOrganizationTest() throws Throwable {

//		WebDriver_Utility wlib = new WebDriver_Utility();

		HomePage home = new HomePage(driver);
		home.clickOrgLink();

		OrgLookUp lookUp = new OrgLookUp(driver);
		lookUp.clickOrgLookUp();
//Assert.fail("Fail the script");
//		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomValue();

		Excel_Utility elib = new Excel_Utility();
		String OrgName = elib.getExcelData("Data_Sheet2", 0, 0) + ranNum;

		driver.findElement(By.name("accountname")).sendKeys(OrgName);
////-----------------------------------------------------------------------------------------------
//
		String phnNum = elib.readDataUsingDataFormatter("Data_Sheet2", 1, 0);

		String mailId = elib.getExcelData("Data_Sheet2", 2, 0);

		CreateOrgPage orgPage = new CreateOrgPage(driver);
		orgPage.enterOrgDetails(OrgName, phnNum, mailId);
		orgPage.clicksaveButton();
//------------------------------------------------------------------------------------------

		ValidateOrg validate = new ValidateOrg(driver);
		validate.ValidateOrg(driver, OrgName);
	}
}
