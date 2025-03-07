package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example_9 {

	public static void main(String[] args) throws Throwable {

		//Keeping the properties file in read mode

		Properties pro= new Properties();

		pro.setProperty("browser", "chrome");

		pro.setProperty("url", "https://www.flipkart.com");

	

		FileOutputStream fos= new FileOutputStream("C:\\Users\\yhtro\\OneDrive\\Desktop\\commondata.properties");
		
		pro.store(fos,"commondata");
		
		FileInputStream fis =new FileInputStream("C:\\Users\\yhtro\\OneDrive\\Desktop\\commondata.properties");
		pro.load(fis);
		
		String BROWSER =pro.getProperty("browser"); 

		String URL= pro.getProperty("url");

		WebDriver driver;
		
		 	        
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

	}

}
