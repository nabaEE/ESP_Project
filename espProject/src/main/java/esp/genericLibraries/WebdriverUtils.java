package esp.genericLibraries;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtils {

	/**
	 * 
	 * wait for page to load
	 * 
	 */
	public static void waitForPageToLoad(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	/**
	 * 
	 * Wait for any element available in GUI
	 * 
	 */
	public static void waitForElementPresent(WebDriver driver, WebElement wb) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(wb));
		// System.out.println("/nElement is visible after Explicit Wait\n");
	}

	/**
	 * Customer Wait
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public static void waitForCompleteElementToLoad(WebElement wb) throws InterruptedException {
		int count = 0;
		while (count < 10) {
			try {
				wb.isDisplayed();
				// System.out.println("\nElement is displayed\n");
				break;
			} catch (Throwable t) {
				//System.out.println("Handle the exception and continue");
				Thread.sleep(1000);
				count++;
			}
		}
	}

	/**
	 * Scroll down and up the page
	 * 
	 */
	public static void scrollUP() {
		JavascriptExecutor jse = (JavascriptExecutor) BaseClass.driver;
		jse.executeScript("window.scrollBy(0,-250)");
	}

	/**
	 * 
	 * Stop the page load
	 */
	public static void stopPageLoad() {
		BaseClass.driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
	}
	// Click using Java script executor
   public static void clickUsingJavaScript(WebElement element) {
	JavascriptExecutor js= (JavascriptExecutor)BaseClass.driver;
	js.executeScript("arguments[0].click();", element);
}
   //Method to handle Stale element exception
   public static boolean handleStale(WebElement element) {
	    boolean result = false;
	    int attempts = 0;
	    while(attempts < 2) {
	        try {
	            element.click();
	            result = true;
	            break;
	        } catch(StaleElementReferenceException e) {
	        }
	        attempts++;
	    }
	    return result;
	}
   //Method to click an element
   public static void clickElement(WebElement element) throws InterruptedException {
	   WebDriverWait wait = new WebDriverWait(BaseClass.driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
   }
   //Method to upload document
   public static void clickAnduploadDocument(String filepath, WebElement element) throws AWTException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		StringSelection path = new StringSelection(filepath);
		// pass the driver control to system
		Toolkit t = Toolkit.getDefaultToolkit();
		// pass the driver control to mouse
		Clipboard c = t.getSystemClipboard();
		// Copy the path into mouse clipboard
		c.setContents(path, null);
		// Declare the Robot class
		Robot rob = new Robot();
		// Press control + V
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		// Release control+V
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		// press enter
		rob.keyPress(KeyEvent.VK_ENTER);
		// Release Enter
		rob.keyRelease(KeyEvent.VK_ENTER);
	}
}
