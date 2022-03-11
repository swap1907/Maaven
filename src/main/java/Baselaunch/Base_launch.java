package Baselaunch;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Base_launch {
	
	WebDriver driver;
	JavascriptExecutor js;
	@Test(alwaysRun = true)
	public void setUp() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\Driver\\chromedriver.exe");
	//	DesiredCapabilities capabilities= DesiredCapabilities.chrome();
	//	capabilities.setCapability("chrome.binary", "D:\\Selenium\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications"); // Disabled notifications popup
		options.addArguments("--incognito");
		options.addArguments("--start-maximized"); // https://stackoverflow.com/a/26283818/1689770
		options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
		options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
		options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
		options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
		options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
		options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
		options.setExperimentalOption("useAutomationExtension", false);
	//	options.merge(capabilities);
	
		driver= new ChromeDriver(options);
		//this.driver=driver;
		driver.get("http://stage.ceat.com");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		this.js=js;
	}

}
