package elementResources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.GeneralUtilities;
import utilityClasses.MouseActions;

public class HomePageClass {
	WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Workers']")
	WebElement workersButton;
	
	@FindBy(xpath = "//a[text()='Deduction']")
	WebElement deductionButton;
	
	@FindBy(xpath="//a[text()='TimeSheet']")
	WebElement timeSheetButton;
	
	@FindBy(xpath="//a[text()='Payslip']")
	WebElement paySlipButton;
	
	@FindBy(xpath = "//a[text()='Invoice']")
	WebElement invoiceButton;
	
	@FindBy(xpath = "//ul[@id='w3']//li[4]")
	WebElement workersWindow;
	
	@FindBy(xpath = "//ul[@id='w2']//li[5]")
	WebElement deductionWindow;
	
	@FindBy(xpath = "//ul[@id='w1']//li[6]")
	WebElement timeSheetWindow;
	
	@FindBy(xpath = "//ul[@id='w2']//li[7]")
	WebElement paySlipWindow;
	
	@FindBy(xpath = "//ul[@id='w2']//li[8]")
	WebElement invoiceWindow;
	
	@FindBy(xpath = "//img[@alt='logo']")
	WebElement logo;
	
	
	@FindBy(xpath = "//a[text()=' Settings']")
	WebElement settingsButton;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement profileButton;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logOutButton;
	
	
	MouseActions action;
	
	GeneralUtilities generalUtil=new GeneralUtilities();
	
	public HomePageClass(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver,this);

	}
	
	
	public boolean verifyVisibilityOfWorkersWindow()
	{
		return generalUtil.getAttributeValue(workersWindow, "class","active");
	}
	
	public boolean verifyVisibilityOfDeductionWindow()
	{
		return generalUtil.getAttributeValue(deductionWindow, "class","active");
	}
	
	public boolean verifyVisibilityOfTimeSheetWindow()
	{
		return generalUtil.getAttributeValue(timeSheetWindow, "class","active");
	}
	
	public boolean verifyVisibilityOfPaySlipWindow()
	{
		return generalUtil.getAttributeValue(paySlipWindow, "class","active");
	}
	
	public boolean verifyVisibilityOfInvoiceWindow()
	{
		return generalUtil.getAttributeValue(invoiceWindow, "class","active");
	}
	
	public void clickWorkersButton()
	{
		workersButton.click();
	}
	
	public void clickDeductionButton()
	{
		deductionButton.click();
	}

	public void clickTimeSheetButton()
	{
		timeSheetButton.click();
	}
	
	
	public void clickpaySlipButton()
	{
		paySlipButton.click();
	}
	
	public void clickInvoiceButton()
	{
		invoiceButton.click();
	}
	
	public void profileButtonClick()
	{
		profileButton.click();
	}
	
	public void logOutButtonClick()
	{
		logOutButton.click();
	}
	
	public boolean reportStatusOfLogo()
	{
		return generalUtil.isElementDisplayed(logo); 
	}
	
	public String getColorOfSettingsButton()
	{
		return generalUtil.getTextProperty(settingsButton, "background-color");
	}
	
	
	public String getSizeOfSettingsButton()
	{
		return generalUtil.getTextProperty(settingsButton, "font-size");
	}
	
	public boolean reportStatusOfSettingsButton()
	{
		return generalUtil.isElementDisplayed(settingsButton);
	}
	
	public void mouseClickOnProfileButton()
	{
		action=new MouseActions(driver);
		action.mouseClick(profileButton);
		
	}
	
	public void mouseClickLogOut()
	{
		action=new MouseActions(driver);
		action.mouseClick(logOutButton);
		
	}
	
}
