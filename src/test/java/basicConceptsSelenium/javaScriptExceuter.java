package basicConceptsSelenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class javaScriptExceuter {
	public WebDriver driver;
	@BeforeMethod
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\souna\\driverfortest\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void enterText_intoDisabledTextbox() throws InterruptedException {
		driver.get("file:///C:/Users/souna/OneDrive/Documents/DisabledTextBox.html");
		driver.manage().window().maximize();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(2000);
		
		jse.executeScript("document.getElementById('t1').value='Hasbro'");
		Thread.sleep(2000);
		
		jse.executeScript("document.getElementById('t2').value=''");
		Thread.sleep(2000);
		
		jse.executeScript("document.getElementById('t2').value='submit'");
		Thread.sleep(2000);
		
		jse.executeScript("document.getElementById('t2').type='button'");
		Thread.sleep(2000);
		
		driver.close();
	}
	
	@Test
	public void scrollUpandDown() throws InterruptedException {
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		for(int i = 1; i < 10; i++) {
			js.executeScript("window.scrollBy(0,300)");
			Thread.sleep(3000);
		}
		
		for(int i = 1; i < 10; i++) {
			js.executeScript("window.scrollBy(0,-300)");
			Thread.sleep(3000);
		}
		
		driver.close();
	}
	
}
