package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilityClasses.GeneralUtilities;
import utilityClasses.ScreenShotCapture;

public class BaseClass {

	public WebDriver driver;

	ScreenShotCapture ob;
	GeneralUtilities generalUil;

	@BeforeMethod(enabled = false)
	@Parameters("browser")
	public void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\amalx\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\fire fox\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "F:\\edgeDriverAmal\\msedgedriver.exe");
			driver=new EdgeDriver();

		}

		else {
			System.setProperty("webdriver.chrome.driver", "F:\\amalx\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		driver.get("https://www.qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();

	}
	
	
	@BeforeMethod(enabled=true)
	public void launchBrowser()
	{
	
		System.setProperty("webdriver.chrome.driver", "F:\\amalx\\chromedriver.exe");
		driver = new ChromeDriver();
		generalUil=new GeneralUtilities(driver);
		generalUil.applyImplicitWait(driver, 10);
		driver.get("https://www.qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();


	}
	
	

	@AfterMethod
	public void closeBrowser(ITestResult itestresult) throws Exception {
		ob = new ScreenShotCapture();
		
		if(itestresult.getStatus()==itestresult.FAILURE)
		{
			ob.takeScreenShotFailure(driver,itestresult.getName());

		}
		driver.close();
	}

}
