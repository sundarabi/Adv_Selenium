package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example_7 {

	public static void main(String[] args) throws Throwable {


		FileInputStream files= new FileInputStream("C:\\Users\\yhtro\\OneDrive\\Desktop\\up.properties");
		
		Properties pro = new Properties();

		pro.load(files);

		String BROWSER  = pro.getProperty("browser");
        String URL      = pro.getProperty("url");
		String USERNAME = pro.getProperty("userName");
		String PASSWORD = pro.getProperty("password");
		
        WebDriver driver ;
        
        if (BROWSER.equalsIgnoreCase("firefox"))
        	
		{
			driver=new FirefoxDriver();
		}
		
       else if (BROWSER.equalsIgnoreCase("edge"))

		{
            driver=new EdgeDriver();
		}
        
		else 
		{

		driver=new ChromeDriver();

		}
        
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		
	}

}
