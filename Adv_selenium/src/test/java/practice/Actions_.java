package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_ {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
	    
		driver.get("https://www.facebook.com/");
		
		WebElement clickb = driver.findElement(By.name("login"));
		
		Actions action= new Actions(driver);
	
		action.click(clickb).perform();
	}

}
