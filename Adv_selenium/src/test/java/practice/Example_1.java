package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example_1 {

	public static void main(String[] args) {

		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		 WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("Iphone");
		search.submit();
		List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class=\"sg-col-inner\"]"));
		 System.out.println("iPhone Suggestions:");
         for (WebElement suggest : suggestions) {
             System.out.println(suggest.getText());
         }
	
	
	
	
	
	}

}
