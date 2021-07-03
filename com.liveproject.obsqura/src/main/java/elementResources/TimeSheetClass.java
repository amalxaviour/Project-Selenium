package elementResources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.GeneralUtilities;

public class TimeSheetClass {

	WebDriver driver;
	GeneralUtilities generalUtil=new GeneralUtilities();

	@FindBy(xpath = "//a[text()='TimeSheet']")
	WebElement timeSheetButton;

	@FindBy(xpath = "//button[text()='Generate Invoice']")
	WebElement generateInvoiceButton;

	@FindBy(xpath = "//button[text()='Generate Playslip']")
	WebElement generatePaySlipButton;
	

	public void timeSheetButtonClick() {
		timeSheetButton.click();
	}
	
	public void generatePaySlipButtonClick()
	{
		generatePaySlipButton.click();
	}

	public void generateInvoiceButtonClick() {
		generateInvoiceButton.click();
	}

	public TimeSheetClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getGenerateInvoiceButtonColor()
	{
		return generalUtil.getTextProperty(generateInvoiceButton, "background-color"); 
	}
}
