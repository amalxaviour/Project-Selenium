package elementResources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.ExcelDataHub;
import utilityClasses.GeneralUtilities;


public class LoginClass {
	WebDriver driver;
	  GeneralUtilities generalUtil=new GeneralUtilities();
	  
	  

	@FindBy(xpath = "//input[@id='loginform-username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='loginform-password']")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath = "//p[text()='Incorrect username or password.']")
	WebElement errorMessage;
	
	@FindBy(xpath = "//a[text()='reset it']")
	WebElement resetLink;
	
	@FindBy(xpath = "//input[@id='loginform-rememberme']")
	WebElement rememberMe;
	
	@FindBy(xpath = "//p[text()='Username cannot be blank.']")
	WebElement errorMessageUserName;
	
	@FindBy(xpath = "//a[text()='Carol Thomas']")
	WebElement accountHolderName;
	
	
	

	ExcelDataHub excel;
	
	
	public LoginClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);

		
	}
	
	public void enterUserName(String u)
	{
		userName.sendKeys(u);
	}
	public void enterPassword(String p)
	{
		password.sendKeys(p);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public void clickRememberMeCheckBox()
	{
		rememberMe.click();
	}
	
	public String profileText()
	{
		return generalUtil.getElementText(accountHolderName);
		
	}
	
	public void wait(int time)
	{
		generalUtil.applyImplicitWait(driver, time);
	}
	
	
  
	public String getErrorMessageText()
	{
		return generalUtil.getElementText(errorMessage);
	}
	
	public boolean rememberMeBoxStatus()
	{
		return rememberMe.isSelected();
	}
	
	public void clickResetLink()
	{
		resetLink.click();
	}
	public boolean verifyResetLink()
	{
	
		return generalUtil.getTagName(resetLink,"a");
	}
	
	public void shortcutToLogin()
	{
		excel=new ExcelDataHub();
		
		userName.sendKeys(excel.getDataFromExcel(0, 1, 0));
		password.sendKeys(excel.getDataFromExcel(0, 1, 1));
		loginButton.click();
	}
	
	
	
}
