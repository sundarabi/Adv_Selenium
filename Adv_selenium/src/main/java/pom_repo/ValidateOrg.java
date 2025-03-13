package pom_repo;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateOrg {

	public ValidateOrg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateOrg(WebDriver driver,String name)
	
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();

		if (actData.contains(name)) {
			System.out.println("Organization is created");
		} else {
			System.out.println("Organization is not created");
		}
	}
}