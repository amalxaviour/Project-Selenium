package elementResources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.GeneralUtilities;

public class InvoiceClass {
	
	WebDriver driver;
	
	GeneralUtilities generalUtil = new GeneralUtilities();
	
	
	@FindBy(xpath = "//a[text()='Invoice']")
	WebElement invoiceButton;
	@FindBy(xpath ="//table[@class='table table-striped table-bordered']//tr[1]//a[@target='_blank']//span[@class='glyphicon glyphicon-paperclip']")
	WebElement invoiceNewTabButton;
	
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tr//th[2]")
	WebElement clientNumberHeadText;
	
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tr//th[3]")
	WebElement dateText;
	
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tr//th[4]")
	WebElement amountHeadName;
	
	
	@FindBy(xpath = "//a[text()='2']")
	WebElement next2ButtonBottom;
	
	@FindBy(xpath = "//ul[@class='pagination']//li[3]")
	WebElement next2ButtonActiveTag;
	
	
	
	
	
	
	
	
	
	
	public InvoiceClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickInvoiceButton()
	{
		invoiceButton.click();
	}
	
	public void clickNewTabButtonOfFirstRow()
	{
		invoiceNewTabButton.click();
	}
	
	
	public String getTextOfClientNumberText()
	{
		return generalUtil.getElementText(clientNumberHeadText);
	}
	
	public String getTextOfDateText()
	{
		return generalUtil.getElementText(dateText);
	}
	
	public String getTextOfAmountText()
	{
		return generalUtil.getElementText(amountHeadName);
	}

	
	public boolean verifyVisibilityOfNextPageButtonClick()
	{
		generalUtil.scrollDown(driver, "0","10000");
		next2ButtonBottom.click();
		return generalUtil.getAttributeValue(next2ButtonActiveTag,"class","active");
		
		
	}
	
	
}
