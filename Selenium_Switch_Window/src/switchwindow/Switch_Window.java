package switchwindow;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Switch_Window {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.letskodeit.com/practice");
        
        WebElement openWindow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='openwindow']")));
        openWindow.click();
        waitForTheUser();
        
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
        	 if (!handle.equals(mainWindowHandle)) {
        		 driver.switchTo().window(handle);
        		 break;
        	 }
        }
        driver.manage().window().maximize();
        
        JavascriptExecutor js_scrolldownone = (JavascriptExecutor) driver;
        js_scrolldownone.executeScript("window.scrollBy(0,1000)");
        waitForTheUser();
        JavascriptExecutor js_scrolldowntwo = (JavascriptExecutor) driver;
        js_scrolldowntwo.executeScript("window.scrollBy(0,1000)");
        waitForTheUser();
        JavascriptExecutor js_scrollupone = (JavascriptExecutor) driver;
  	    js_scrollupone.executeScript("window.scrollBy(0,-1000)");
  	    waitForTheUser();
  	    JavascriptExecutor js_scrolluptwo = (JavascriptExecutor) driver;
	    js_scrolluptwo.executeScript("window.scrollBy(0,-1000)");
	    waitForTheUser();
        
	    driver.close();
	    waitForTheUser();
	    
	    driver.switchTo().window(mainWindowHandle);
	    driver.quit();
	}
	
	public static void waitForTheUser() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
