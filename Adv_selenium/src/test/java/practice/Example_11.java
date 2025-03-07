package practice;

import java.io.File;
import java.nio.file.Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Example_11 {

	public static void main(String[] args) throws Throwable {

		
		File file        = new File("C:\\Users\\yhtro\\OneDrive\\Desktop\\data.json");

		ObjectMapper obj = new ObjectMapper();

		JsonNode data    = obj.readTree(file);

		String BROWSER   = data.get("browser").asText();

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
