package basicConceptsSelenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class screenshot {
	public WebDriver driver;
	@BeforeMethod
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\souna\\Driverfortesting\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void Take_Screenshot() throws IOException, InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("jjndhpp@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input[class='inputtext _55r1 _6luy _9npi']")).sendKeys("98876w");
		Thread.sleep(2000);
		
		TakesScreenshot tksht = (TakesScreenshot)driver;
		Thread.sleep(2000);
		
		File file = tksht.getScreenshotAs(OutputType.FILE);
		Thread.sleep(2000);
		
		File filesave = new File(".\\Facebook_scrnshot\\" + "FbLogin1.png");
		Thread.sleep(2000);
		
		FileHandler.copy(file, filesave);
		
		driver.close();
	}

}
