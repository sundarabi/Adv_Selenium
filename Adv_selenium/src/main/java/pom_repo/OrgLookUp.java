package pom_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgLookUp {

	public OrgLookUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement lookUp;
	
	public void clickOrgLookUp()
	{
		lookUp.click();
	}
}
