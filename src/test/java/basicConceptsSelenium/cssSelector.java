package basicConceptsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class cssSelector {
	public WebDriver driver;
	@BeforeMethod
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\souna\\driverfortest\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void fbLoginbyCSS() throws InterruptedException {
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input[id='email']")).sendKeys("ssoun@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input[class='inputtext _55r1 _6luy _9npi'][id='pass']")).sendKeys("sskkju8998");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("button[value='1']")).click();
		Thread.sleep(2000);
		
		driver.close();
	}

}
