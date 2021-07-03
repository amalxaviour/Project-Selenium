package utilityClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	
	WebDriver driver;
	Actions actions;
	
	public MouseActions(WebDriver driver)
	{
		this.driver=driver;
		actions=new Actions(driver);
	}
	
	public void mouseMoveToElement(WebElement element)
	{
		actions.moveToElement(element).perform();;
		
	}
	
	public void mouseDoubleClickAtElement(WebElement element)
	{
		actions.doubleClick(element).perform();
		
	}
	
	public void mouseClick(WebElement element)
	{
		actions.click(element).perform();
	}
	
	public void acceptAlertPopUp()
	{
		driver.switchTo().alert().accept();
	}
	
	public String getAlertText()
	{
		return driver.switchTo().alert().getText();
	}

}
