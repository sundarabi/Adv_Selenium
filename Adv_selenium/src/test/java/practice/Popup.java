package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Popup {

	public static void main(String[] args) throws Exception {
	
		ChromeOptions settings = new ChromeOptions();
		
		//to avoid popup and to accept micro phone permission
		settings.addArguments("--auto-accept-camera-and-microphone-capture");
		

		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://mictests.com/");
		
		Thread.sleep(3000);
		
		//driver.findElement(By.id("mic-launcher")).click();
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 WebElement testMyMicBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("mic-launcher")));
         testMyMicBtn.click();
		
     
	}

}
