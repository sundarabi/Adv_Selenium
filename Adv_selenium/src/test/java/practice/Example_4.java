package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example_4 {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.prokabaddi.com/standings");
		
		String team_name = "Patna Pirates";
		String won = driver.findElement(By.xpath("//p[text()='"+team_name+"']/ancestor::div[@class='row-head']//div[@class='table-data matches-won']")).getText();
        System.out.println(won);
		List<WebElement> kabadi = driver.findElements(By.xpath("//p[text()='"+team_name+"']/../../../../div[@class]"));
		
		for(WebElement team:kabadi) {
			System.out.println(team.getText());
		}
		
		
}

}
