package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Qsp_clock {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/ui/timePick/timeClock?sublist=1");
		driver.manage().window().maximize();

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[placeholder=\"hh:mm aa\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='MuiClock-root css-fhpqww']//span[text()='4']")).click();

	}
	}


