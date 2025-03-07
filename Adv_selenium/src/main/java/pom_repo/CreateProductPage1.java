package pom_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage1 {

	
	public CreateProductPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement prdName;
	
	@FindBy(css = "[title=\"Save [Alt+S]\"]")
	private WebElement saveButton;
	
	public void enterPrdName(String name)
	{
		prdName.sendKeys(name);
	}
	
	public void clickSaveButton()
	{
		
		saveButton.click();
	}
}