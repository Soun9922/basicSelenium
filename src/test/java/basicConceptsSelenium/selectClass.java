package basicConceptsSelenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class selectClass{
	public WebDriver driver;
	@BeforeMethod
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\souna\\driverfortest\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void selectMethods() throws InterruptedException {
		driver.get("file:///C:/Users/souna/OneDrive/Desktop/HtmlPages/ListBox_Food.html");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		WebElement eleList = driver.findElement(By.id("mtr"));
		
		Select sclt = new Select(eleList);
		List<WebElement> optns = sclt.getOptions();
		int size1 = optns.size();
		
		Thread.sleep(3000);
		
		System.out.println("Number of elements present in the box : " + size1);
		
		Thread.sleep(3000);
		
		for(WebElement webElemt : optns) {
			String txt = webElemt.getText();
			System.out.println("The Elements are : " + txt );
			Thread.sleep(3000);
		}
		
		sclt.selectByIndex(0);
		Thread.sleep(3000);
		sclt.selectByValue("i");
		Thread.sleep(3000);
		sclt.selectByVisibleText("poori");
		Thread.sleep(3000);
		
		List<WebElement> allSelectedOptns = sclt.getAllSelectedOptions();
		Thread.sleep(3000);
		int size2 = allSelectedOptns.size();
		Thread.sleep(3000);
		System.out.println("Number of elements present in the box : " + size2);
		
		System.out.println("------All Selected Items are printed Below------");
		
		for(WebElement wbElmnt : allSelectedOptns) {
			System.out.println("The Foods are : " + wbElmnt.getText());
			Thread.sleep(3000);
		}
		
		System.out.println("------Check Weather it's Multiple Select ListBox------");
		
		boolean mltpl = sclt.isMultiple();
		Thread.sleep(3000);
		System.out.println( mltpl + " Yes,It's Multiple Select");
		
		if(mltpl) {
			
			WebElement firstSelectedoptn = sclt.getFirstSelectedOption();
			System.out.println(firstSelectedoptn.getText() + " is the first selected item in the box");
			
			sclt.deselectByIndex(0);
			Thread.sleep(3000);
			sclt.deselectByValue("v");
			Thread.sleep(3000);
			sclt.deselectByVisibleText("poori");
			Thread.sleep(3000);
		}
		driver.close();
	}
	
	@Test
	public void listValues_printedinSortedOrder() throws InterruptedException {
		driver.get("file:///C:/Users/souna/OneDrive/Desktop/FoodSelect/ListBox_Food.html");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		WebElement eleList = driver.findElement(By.id("mtr"));
		
		Thread.sleep(2000);
		
		Select sclt = new Select(eleList);
		
		Thread.sleep(2000);
		
		List<WebElement> allOptns = sclt.getOptions();
		int cnt = allOptns.size();
		Thread.sleep(2000);
		System.out.println("The Count of elements from list : " + cnt);
		
		ArrayList<String> arList = new ArrayList<String>();
		
		System.out.println("--------The Unsorted Order from the ListBox-------");
		
		for(WebElement eleOptn : allOptns) {
			System.out.println("The Elements are : " + eleOptn.getText());
			String txt = eleOptn.getText();
			arList.add(txt);
		}
		System.out.println("--------The Sorted Order from the ListBox-------");
		Collections.sort(arList);
		for(String sValue : arList) {
			System.out.println("The Elements are : " + sValue);
		}
		driver.close();
	}
}
