package basicConceptsSelenium;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class handelingPopUp {
	public WebDriver driver;
	@BeforeMethod
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\souna\\driverfortest\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void alertPopup() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		Thread.sleep(2000);
		
		Alert alrt = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println("The Text from the popup :" + alrt.getText());
		Thread.sleep(2000);
		alrt.accept();
		Thread.sleep(1000);
		
		driver.close();
	}
	
	@Test
	public void alertPopup_timer() throws InterruptedException, AWTException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		
		Robot rbt = new Robot();
		rbt.mouseWheel(2);
		
		driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
		Thread.sleep(5000);
		
		Alert alrt = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println("The Text from the timer popup : " + alrt.getText());
		Thread.sleep(2000);
		alrt.accept();
		Thread.sleep(1000);
		
		driver.close();
	}
	
	@Test
	public void confirmationPopUpAccept() throws InterruptedException, AWTException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		
		Robot rbt = new Robot();
		rbt.mouseWheel(2);
		
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		Thread.sleep(1000);
		
		Alert alrt = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println("The text from confirmmation popup : " + alrt.getText());
		Thread.sleep(1000);
		alrt.accept();
		
		driver.close();
	}
	
	@Test
	public void confirmationPopUpDismiss() throws InterruptedException, AWTException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		
		Robot rbt = new Robot();
		rbt.mouseWheel(2);
		
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		Thread.sleep(1000);
		
		Alert alrt = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println("The text from confirmmation popup : " + alrt.getText());
		Thread.sleep(1000);
		alrt.dismiss();
		
		driver.close();
	}
	
	@Test
	public void promtPopup() throws AWTException, InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		
		Robot rbt = new Robot();
		rbt.mouseWheel(2);
		
		driver.findElement(By.cssSelector("button[id='promtButton']")).click();
		Thread.sleep(2000);
		
		Alert alrt = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println("The text from promt popup : " + alrt.getText());
		alrt.sendKeys("Welcome To Selenium");
		Thread.sleep(2000);
		alrt.accept();
		
		driver.close();
	}

}
