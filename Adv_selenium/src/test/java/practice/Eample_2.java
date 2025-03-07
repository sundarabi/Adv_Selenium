package practice;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Eample_2 {

	public static void main(String[] args) {

WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		 WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("Iphone");
		search.submit();
		

		List<WebElement> phones = driver.findElements(By.xpath("//span[contains(text(),'Apple')]"));
		
		for(WebElement mobiles:phones) {
			System.out.println(mobiles.getText());
		}
	}
	

}