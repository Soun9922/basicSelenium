package basicConceptsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframe {
	public WebDriver driver;
	@BeforeMethod
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\souna\\driverfortest\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void frame_test() throws InterruptedException {
		driver.get("file:///C:/Users/souna/OneDrive/Documents/frame/page2.html");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		driver.findElement(By.id("t1")).sendKeys("Sounak");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.id("t2")).sendKeys("Frame Concept");
		Thread.sleep(3000);
		
		driver.close();
	}
	
	@Test
	public void frame_Webelement() throws InterruptedException {
		driver.get("file:///C:/Users/souna/OneDrive/Documents/frame/page2.html");
		driver.manage().window().maximize();
		
		WebElement frame = driver.findElement(By.className("c1"));
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		driver.findElement(By.id("t1")).sendKeys("Rakars");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.id("t2")).sendKeys("Frame Concept with WebElement");
		Thread.sleep(3000);
		
		driver.close();
	}
	
}
