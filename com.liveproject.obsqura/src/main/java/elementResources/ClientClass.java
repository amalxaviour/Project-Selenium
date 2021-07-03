package elementResources;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.GeneralUtilities;

public class ClientClass {

	WebDriver driver;
	GeneralUtilities generalUtil = new GeneralUtilities();

	@FindBy(xpath = "//a[text()='Clients']")
	WebElement clientsButton;
	@FindBy(xpath = "//input[@id='clientsearch-client_name']")
	WebElement clientName;

	@FindBy(xpath = "//input[@id='clientsearch-id']")
	WebElement clientID;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement clientSearchButton;

	@FindBy(xpath = "//label[text()='Client Name']")
	WebElement clientNameText;

	@FindBy(xpath = "//label[text()='Client ID']")
	WebElement clientIdText;

	@FindBy(xpath = "//ul[@id='w3']//li[3]")
	WebElement clientsWindow;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr//td[2]")
	WebElement searchName;
	
	@FindBy(xpath = "//input[@id='client-client_name']")
	WebElement clientNameOfUpdateBar;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	
	
	

	String expectedLocator;
	WebElement nameElement;
	WebElement updateLoc;

	public ClientClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String getTitleOfClientPageTab() {
		return driver.getTitle();
	}

	public void clickClientButton() {
		clientsButton.click();
	}

	public String getclientNameText() {
		return generalUtil.getElementText(clientNameText);
	}

	public String getclientIdText() {
		return generalUtil.getElementText(clientIdText);
	}

	public boolean verifyClientsWindowVisibility() {
		return generalUtil.getAttributeValue(clientsWindow, "class", "active");

	}

	public String searchClientName(String Name, String id) {
		clientName.sendKeys(Name);
		clientID.sendKeys(id);
		clientSearchButton.click();

		return generalUtil.getElementText(searchName);

	}

	public List<String> getNameOfGrid() {
		generalUtil = new GeneralUtilities(driver);
		String path = "//table[@class='table table-striped table-bordered']//tbody//tr//td[2]";

		List<String> textValuesOfRow = new ArrayList<String>();

		textValuesOfRow = generalUtil.dynamicLocatorOfTableGrid(path);

		return textValuesOfRow;

	}

	public void verifyUpdateOfgrid(String icon) {
		generalUtil = new GeneralUtilities(driver);
		String path = "//table[@class='table table-striped table-bordered']//tbody//tr//td[1]";

		List<String> textValuesOfRow = new ArrayList<String>();

		textValuesOfRow = generalUtil.dynamicLocatorOfTableGrid(path);

		for (int j = 0; j < textValuesOfRow.size(); j++) {
			if (textValuesOfRow.get(j).contentEquals(icon)) {
				j++;
				expectedLocator = "//table[@class='table table-striped table-bordered']//tbody//tr[" + j
						+ "]//td[6]//span[@class='glyphicon glyphicon-pencil']";
				break;
			}

		}
		
		updateLoc=driver.findElement(By.xpath(expectedLocator));
		

	}
	
	
	public void updateIconClick()
	{
		updateLoc.click();
	}
	
public void verifyUpdateName(String icon)
{
	generalUtil = new GeneralUtilities(driver);
	String path = "//table[@class='table table-striped table-bordered']//tbody//tr//td[1]";
	
	List<String> textValuesOfRow = new ArrayList<String>();
	
	textValuesOfRow=generalUtil.dynamicLocatorOfTableGrid(path);
	
	for(int j=0;j<textValuesOfRow.size();j++)
	{
		if(textValuesOfRow.get(j).contentEquals(icon))
		{
			j++;
			
			expectedLocator="//table[@class='table table-striped table-bordered']//tr["+j+"]//td[6]//span[@class='glyphicon glyphicon-pencil']";
			break;
		}
	}

	updateLoc=driver.findElement(By.xpath(expectedLocator));
}

public void updateNameIn(String name)
{
	clientNameOfUpdateBar.clear();
	clientNameOfUpdateBar.sendKeys(name);
}

public void clickSaveButton()
{
	generalUtil.scrollDown(driver, "0","10000");
	saveButton.click();
	
}


public String getName(String icon)
{
	generalUtil = new GeneralUtilities(driver);
	String path = "//table[@class='table table-striped table-bordered']//tbody//tr//td[1]";
	
	List<String> textValuesOfRow = new ArrayList<String>();
	textValuesOfRow=generalUtil.dynamicLocatorOfTableGrid(path);
	
	for(int j=0;j<textValuesOfRow.size();j++)
	{
	if(textValuesOfRow.get(j).contentEquals(icon))
	{
		j++;
		
		expectedLocator="//table[@class='table table-striped table-bordered']//tbody//tr["+j+"]//td[2]";
		break;
	}
	
	
}
	
	updateLoc=driver.findElement(By.xpath(expectedLocator));
	return generalUtil.getElementText(updateLoc);

}
}
