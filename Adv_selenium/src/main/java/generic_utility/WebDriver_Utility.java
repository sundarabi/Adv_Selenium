package generic_utility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriver_Utility {

	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * this method is used to wait for all the elements to get loaded
	 * @param driver
	 */
	public void loadTheElements(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void windowSwitching(WebDriver driver,String partialTitle)
	{
		Set<String> allWins = driver.getWindowHandles();// win1,win2
		Iterator<String> it = allWins.iterator();

		while (it.hasNext()) {
			String win =  it.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains(partialTitle)) {
				break;
			}
		}
	}
	
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
			}

	public void moveToElement(WebDriver driver, WebElement admLink) {
	
	}
	
	
	
public static String takeScreenShotEx(WebDriver driver, String screenShotName) throws Throwable {
		
		TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/" + screenShotName +".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	
}
