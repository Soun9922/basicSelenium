package basicConceptsSelenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fileUploadPopup {
	public WebDriver driver;
	@BeforeMethod
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\souna\\driverfortest\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void fileUploadUsingAutoit() throws InterruptedException, IOException {
		driver.get("https://www.freepdfconvert.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@class='btn-wrapper upload-btn']")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\souna\\OneDrive\\Desktop\\Autoit\\File_Upload.exe");
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void filePopupSenkeys() throws InterruptedException {
		driver.get("https://www.freepdfconvert.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@class='btn-wrapper upload-btn']")).sendKeys("C:\\Users\\souna\\OneDrive\\Desktop\\Autoit\\File_Upload.exe");
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void fileUploadUsingAutoit_2() throws InterruptedException, IOException {
		driver.get("https://smallpdf.com/pdf-converter");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[@class='l3tlg0-0 ggoliT']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\souna\\OneDrive\\Desktop\\Autoit\\File_Upload2.exe");
		Thread.sleep(5000);
		driver.close();
	}
}
