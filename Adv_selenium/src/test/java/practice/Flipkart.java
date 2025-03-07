package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom_repo.POMFK;

public class Flipkart {

	//pom findall and finds
	
	public static void main(String[] args) {

		 WebDriver driver=new ChromeDriver();

		  driver.get("https://www.flipkart.com");

		  driver.manage().window().maximize(); 

		  POMFK page = new POMFK(driver);

		  page.enterValue("Puma");

	}

}
