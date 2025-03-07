package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example_5 {

	public static void main(String[] args) throws Exception {

		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.bigbasket.com/");
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Search for Products...' and @fdprocessedid='023tgm']"));
        searchBox.sendKeys("apple");
		
		Thread.sleep(2000);
		WebElement suggests = driver.findElement(By.xpath("//span[contains(@class, 'Label-sc-15v1nk5-0') and contains(., 'Apple - Shimla, Regular')]"));
		suggests.click();
			
		Thread.sleep(2000);
		WebElement apple = driver.findElement(By.xpath("//h1[text()='fresho! Apple - Shimla, Regular, 2x4 pcs Multipack']"));
		
		String name = apple.getText();
		System.out.println("Apple name: "+name);
		
WebElement price = driver.findElement(By.xpath("//td[@class='Description___StyledTd-sc-82a36a-4 fLZywG']"));
		
		String rate = price.getText();
		System.out.println("Apple name: "+rate);
			
		
	}


}