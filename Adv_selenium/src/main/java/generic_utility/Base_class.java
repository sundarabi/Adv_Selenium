package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pom_repo.HomePage;
import pom_repo.LoginPageEx;

public class Base_class {

	public WebDriver driver;
	public static WebDriver sdriver;
	public Java_Utility jlib = new Java_Utility();
	public Excel_Utility elib = new Excel_Utility();
	WebDriver_Utility wlib = new WebDriver_Utility();
	File_Utility flib = new File_Utility();

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void BS() {
		System.out.println("DataBase connection");
	}

	@BeforeTest
	public void BT() {
		System.out.println("Parallel execution");
	}

//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
//	public void BC(String BROWSER) throws Throwable {

	public void BC() throws Throwable {
	String BROWSER = flib.getCommonData("browser");
	//	String BROWSER = System.getProperty("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		System.out.println("Launching Browser");
		sdriver=driver;
	}

	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void BM() throws Throwable {

		wlib.maximizeWindow(driver);
		wlib.loadTheElements(driver);

		String URL = flib.getCommonData("url");
		String USERNAME = flib.getCommonData("username");
		String PASSWORD = flib.getCommonData("password");
		driver.get(URL);

		// using Business Logics
		LoginPageEx login = new LoginPageEx(driver);
		login.loginToApp(USERNAME, PASSWORD);

		System.out.println("Login to App");
	}

	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void AM() {
		HomePage home = new HomePage(driver);
		home.logOut();
		System.out.println("Logout from App");
	}

	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void AC() {
		driver.quit();
		System.out.println("Close the browser");
	}

	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void AT() {
		System.out.println("Parallel execution");
	}

	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void AS() {
		System.out.println("DataBase Connection close");
	}
}