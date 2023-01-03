package basicConceptsSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class navigation {
	public WebDriver driver;
	@BeforeMethod
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\souna\\Driverfortesting\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void navigateBrowser() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.youtube.com/");
		
		String title = driver.getTitle();
		System.out.println("The title is : " + title);
		String url = driver.getCurrentUrl();
		System.out.println("The Current URL : " + url);
		String source = driver.getPageSource();
		System.out.println("The Source of the page is: " + source);
		
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();
		
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
	}

}
