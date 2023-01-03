package basicConceptsSelenium;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class actionClass {
	public WebDriver driver;
	@BeforeMethod
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\souna\\driverfortest\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void movetoElement_mouseFunction() throws InterruptedException, AWTException {
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		WebElement srcDrop = driver.findElement(By.id("draggable"));
		WebElement dstnDrop = driver.findElement(By.xpath("//p[text()='Drop here']"));
		
		Actions actn = new Actions(driver);
		actn.moveToElement(srcDrop).clickAndHold().perform();
		Thread.sleep(3000);
		actn.release(dstnDrop).perform();
		Thread.sleep(3000);
		
		driver.close();
	}
	
	@Test
	public void contextClick_withKeyBoardFunctions() throws InterruptedException {
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Earth");
		WebElement click = driver.findElement(By.xpath("//div[@class='o3j99 ikrT4e om7nvf']"));
		
		Actions actn = new Actions(driver);
		actn.contextClick(click).perform();
		
		actn.sendKeys(Keys.DOWN).perform();
		Thread.sleep(2000);
		actn.sendKeys(Keys.DOWN).perform();
		Thread.sleep(2000);
		actn.sendKeys(Keys.DOWN).perform();
		Thread.sleep(2000);
		actn.sendKeys(Keys.ENTER).perform();
		
		driver.close();
	}
	
	@Test
	public void dragandDrop_mouseFunction() throws InterruptedException, AWTException {
		driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/index.html");
		driver.manage().window().maximize();
		
		WebElement ele1 = driver.findElement(By.xpath("//h1[contains(text(),'Block 1')]"));
		WebElement ele3 = driver.findElement(By.cssSelector("div[id='column-2']"));
		
		Actions actn = new Actions(driver);
		actn.dragAndDrop(ele1, ele3).perform();
		Thread.sleep(3000);
		
		driver.close();
	}
	
	@Test
	public void dragandDrop_offSet() throws AWTException, InterruptedException {
		driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/index.html");
		
		Robot rbt = new Robot();
		rbt.mouseWheel(1);
		
		WebElement ele2 = driver.findElement(By.xpath("//h1[contains(text(),'Block 2')]"));
		WebElement ele4 = driver.findElement(By.cssSelector("div[id='block-4']"));
		
		Actions actn = new Actions(driver);
		Thread.sleep(3000);
		actn.dragAndDropBy(ele2, ele4.getLocation().getX()+10, ele4.getSize().getHeight()+10).perform();
		Thread.sleep(3000);
		
		driver.close();
	}
	
	@Test
	public void moveToElement_mouseHover() throws InterruptedException, AWTException {
		driver.get("https://www.istqb.in/");
		driver.manage().window().maximize();
		
		Actions actn = new Actions(driver);
		
		WebElement foundtn = driver.findElement(By.xpath("//span[text()='FOUNDATION']"));
		actn.moveToElement(foundtn).perform();
		Thread.sleep(3000);
		WebElement enroll = driver.findElement(By.xpath("//a[text()='ENROLLMENT']"));
		actn.moveToElement(enroll).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='ENROLLMENT']")).click();
		Thread.sleep(3000);
		
		driver.close();
	}
	
	@Test
	public void doubleClickMethod() throws InterruptedException {
		driver.get("https://toolzweb.net/double-click-test/");
		driver.manage().window().maximize();
		
		Actions actn = new Actions(driver);
		WebElement dblclk = driver.findElement(By.xpath("//div[@id='darea']"));
		actn.doubleClick(dblclk).perform();
		Thread.sleep(2000);
		actn.doubleClick(dblclk).perform();
		Thread.sleep(2000);
		actn.doubleClick(dblclk).perform();
		Thread.sleep(2000);
		
		driver.close();
	}
}
