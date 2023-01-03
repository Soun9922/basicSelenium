package basicConceptsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fbSignup {
	public WebDriver driver;
	@BeforeMethod
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\souna\\driverfortest\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void createFbAccount() throws InterruptedException {
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Create New Account")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.name("firstname")).sendKeys("Sounak");
		Thread.sleep(1000);
		
		driver.findElement(By.name("lastname")).sendKeys("Sarkar");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("sarkar22@gmail.com");
		Thread.sleep(1000);
		
		driver.findElement(By.name("reg_passwd__")).sendKeys("SS@20229941");
		Thread.sleep(1000);
		
		driver.findElement(By.name("birthday_day")).sendKeys("17");
		Thread.sleep(1000);
		
		driver.findElement(By.name("birthday_month")).sendKeys("Sep");
		Thread.sleep(1000);
		
		driver.findElement(By.id("year")).sendKeys("2002");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='sex'][@value=2]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		Thread.sleep(1000);
		
		driver.close();
	}
	
	@Test
	public void xpathTextFunction() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		String txtFunc = "//input[@class='inputtext _55r1 _6luy'][ @id = 'email']";
		driver.findElement(By.xpath(txtFunc)).sendKeys("Dloujdj");
		
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void xpathContainsFunciton() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[contains(@class,'inputtext _55r1 _6luy _9npi')]")).sendKeys("282753");
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void xpathStartswithFunction() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[starts-with(@name,'login')]")).click();
		Thread.sleep(3000);
		driver.close();
	}
}
