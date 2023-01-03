package basicConceptsSelenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class browserPopUp {
	public WebDriver driver;
	@BeforeMethod
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\souna\\driverfortest\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void printWindowHandel() {
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		
		String windowHandle = driver.getWindowHandle();
		System.out.println(" " + windowHandle);
		
		driver.close();
	}
	
	@Test
	public void childBrowserPopup() throws InterruptedException {
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@title='Remote']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span[title='MNC']")).click();
		
		Set<String> allWindowHndls = driver.getWindowHandles();
		int cntWindow = allWindowHndls.size();
		System.out.println("Number of Browsers Opened : " + cntWindow);
		
		for(String windowHndl : allWindowHndls) {
			
			driver.switchTo().window(windowHndl);
			Thread.sleep(3000);
			String title = driver.getTitle();
			System.out.println("Window Handle id of page " + title + " is : " + windowHndl);
			Thread.sleep(3000);
			driver.close();
		}
	}
	
	@Test
	public void closeMainBrowser() throws InterruptedException {
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
	
		String parentWindowId = driver.getWindowHandle();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Marketing']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span[title='MNC']")).click();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		int countWindow = allWindowHandles.size();
		System.out.println("Number of browser windows opened : " + countWindow);
		
		for(String windowHandle : allWindowHandles) {
			driver.switchTo().window(windowHandle);
			Thread.sleep(2000);
			if(windowHandle.equals(parentWindowId)) {
				String title = driver.getTitle();
				driver.close();
				System.out.println("Main Browser Window with title " + title + " is closed");
			}
		}
	}
	
	@Test
	public void closeAllChildBrowsers() throws InterruptedException {
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		
		String parentWindowId = driver.getWindowHandle();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Remote']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span[title='MNC']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span[title='Marketing']")).click();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		int countWindow = allWindowHandles.size();
		System.out.println("Number of browser windows opened : " + countWindow);
		
		for(String windowHandle : allWindowHandles) {
			driver.switchTo().window(windowHandle);
			Thread.sleep(2000);
			if(!windowHandle.equals(parentWindowId)) {
				String title = driver.getTitle();
				driver.close();
				System.out.println("Child Browser Window with title " + title + " is closed");
			}
		}
	}
}
