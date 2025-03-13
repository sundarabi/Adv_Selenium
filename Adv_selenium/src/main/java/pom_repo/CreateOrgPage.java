package pom_repo;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {

	public CreateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement OrgName;

	@FindBy(name = "phone")
	private WebElement phnNum;

	@FindBy(id = "email1")
	private WebElement mailId;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public void enterOrgDetails(String name, String phnNo, String mail)

	{
		OrgName.sendKeys(name);
		phnNum.sendKeys(phnNo);
		mailId.sendKeys(mail);
		}
public void clicksaveButton()
{
	saveButton.click();
}
}
