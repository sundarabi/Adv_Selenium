package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Example_6 {

	public static void main(String[] args) throws Exception {

		FileInputStream files= new FileInputStream("C:\\Users\\yhtro\\OneDrive\\Desktop\\browserchrome.properties");
		
		Properties pro = new Properties();

		pro.load(files);

		String BROWSER = pro.getProperty("browser");

		WebDriver driver;

		if (BROWSER.equalsIgnoreCase("chrome"))

		{

		driver=new ChromeDriver();

		}

		else if (BROWSER.equalsIgnoreCase("edge"))

		{
            driver=new EdgeDriver();
		}
        
		
	}

}
