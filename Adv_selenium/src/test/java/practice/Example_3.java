package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example_3 {

	public static void main(String[] args) throws Exception {

WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		 WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("Iphone");
		search.submit();
		
		List<WebElement> allColors = driver.findElements(By.xpath(
				"//span[text()=\"Apple iPhone 14 (128 GB) - Blue\"]/../../../..//div[@class='a-section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view']//a"));

		for (WebElement color : allColors) {
			System.out.println(color.getAttribute("aria-label"));
		}
         }
	}


