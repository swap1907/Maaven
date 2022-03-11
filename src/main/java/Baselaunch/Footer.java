package Baselaunch;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Footer extends Base_launch{
	//WebDriver driver;
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@BeforeClass
	public void xceat() throws Throwable {
		
	setUp();
	}
	
	@Test
	public void footer() throws InterruptedException, AWTException {
	WebElement header1 = driver.findElement(By.xpath("//div[@class='cp-footer']"));
	List<WebElement> lin = header1.findElements(By.tagName("a"));

	int nooflinks = lin.size();
	System.out.println(" the number of link in section : " +nooflinks);

	int count=0;
	for(int i=0; i<nooflinks; i++) {
	WebElement header1New = driver.findElement(By.xpath("//div[@class='cp-footer']"));
	List<WebElement> linNew = header1New.findElements(By.tagName("a"));

	WebElement linkss = linNew.get(i);
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].scrollIntoView(true);",linkss);
	if (linkss.getAttribute("innerText").equalsIgnoreCase("Register Warranty")) {
		Actions actions = new Actions(driver); 
		actions.keyDown(Keys.LEFT_CONTROL) 
		       .click(linkss) 
		       .keyUp(Keys.LEFT_CONTROL) 
		       .build() 
		       .perform(); 
	}
	executor.executeScript("arguments[0].click();", linkss);

	Thread.sleep(3000);
	// for(int j = driver.getWindowHandles().size() -1 ; j > 0 ; j--){
	// String winHandle = driver.getWindowHandles().toArray()[j].toString();
	// driver.switchTo().window(winHandle);
	// driver.close();
	// }

	// Set<String> windows = driver.getWindowHandles();
	// Iterator<String>it2=windows.iterator();
	// String parentId= it2.next();
	// String childId=it2.next();
	// driver.switchTo().window(childId);
	// Thread.sleep(3000);
	//
	//
	//
	// //softAssertion.assertEquals(driver.getCurrentUrl(),childurl);
	// driver.close();
	// driver.switchTo().window(parentId);
	// //softAssertion.assertEquals(driver.getCurrentUrl(), parenturl);
	Thread.sleep(3000);
	String url = driver.getCurrentUrl();
	String title =driver.getTitle();
	System.out.println(url+ "*** the page tiltle is :***" +title);

	if(title.contains("404")) {
	System.out.println("Broken link found");
	count++;
	}


	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	if(count==0) {
	System.out.println("No Broken link found");
	}
	}



	}


	