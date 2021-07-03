package utilityClasses;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralUtilities {

	Select select;
	JavascriptExecutor js;
	WebDriver driver;

	public GeneralUtilities(WebDriver driver) {
		this.driver = driver;
	}

	public GeneralUtilities() {
		System.out.println("");
	}

	public String getElementText(WebElement element) {
		return element.getText();
	}

	public void applyImplicitWait(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void applyExplicitWaitElementTobeClickable(WebDriver driver, WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public boolean getTagName(WebElement element, String val) {
		return element.getTagName().contains(val);
	}

	public boolean getAttributeValue(WebElement element, String val, String exp) {
		return element.getAttribute(val).contains(exp);
	}

	public void selectDropByIndex(WebElement element, int x) {
		select = new Select(element);

		select.selectByIndex(x);

	}

	public void selectDropByVisibleText(WebElement element, String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void scrollDown(WebDriver driver, String x, String y) {

		String s = "window.scrollBy(" + x + "," + y + ")";
		js = (JavascriptExecutor) driver;
		js.executeScript(s);
	}

	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	public void switchToNewTab(WebDriver driver, String windowId) {
		driver.switchTo().window(windowId);
	}

	
	
	
	public List<String> dynamicLocatorOfTableGrid(String locatorOfFullRow) {

		
		List<String> textValues = new ArrayList<String>();
		List<WebElement> firstColumns = driver.findElements(By.xpath(locatorOfFullRow));

		for (int i = 0; i < firstColumns.size(); i++) {
			textValues.add(firstColumns.get(i).getText());
		}

		
		return textValues;
	
	
	
	
	}
	
	
	
	public String getTextProperty(WebElement element,String property)
	{
		return element.getCssValue(property);
		
	}
	
	
	
	}

