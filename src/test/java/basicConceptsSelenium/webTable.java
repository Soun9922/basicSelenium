package basicConceptsSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class webTable {
	public WebDriver driver;
	@BeforeMethod
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\souna\\driverfortest\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void WebTable_rowsColumnsCellCounts_Sum() {
		driver.get("file:///C:/Users/souna/OneDrive/Desktop/HtmlPages/WebTable.html");
		driver.manage().window().maximize();
		
		System.out.println("-------Total Number of rows in the Table------");
		List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
		int totalRowsCount = allRows.size();
		System.out.println("Total Rows Count : " + totalRowsCount);
		
		System.out.println("-------Total Number of Columns in the Table------");
		List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
		int totalColumnsCount = allColumns.size();
		System.out.println("Total Rows Count : " + totalColumnsCount);
		
		System.out.println("-------Total Number of Cells in the Table------");
		List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
		int totalCellsCount = allCells.size();
		System.out.println("Total Cells Count : " + totalCellsCount);
		
		System.out.println("------Total Numeric Values and Sum of all Numeric Values-----");
		int cntNumValue = 0, sum = 0;
		for(WebElement cell : allCells) {
			String cellValue = cell.getText();
			try {
				int number = Integer.parseInt(cellValue);
				System.out.println(" " + number);
				cntNumValue++;
				sum = sum + number;
			}catch(Exception e) {
				
			}
		}
		
		System.out.println("Total Count of Numeric Values : " + cntNumValue);
		System.out.println("Total Sum of all Numeric Values : " + sum);
		
		driver.close();
	}
	
	@Test
	public void marksMatch() {
		driver.get("file:///C:/Users/souna/OneDrive/Desktop/HtmlPages/WebTable_Marks.html");
		driver.manage().window().maximize();
		
		WebElement totalMarks = driver.findElement(By.xpath("//td[text()='100']"));
		List<WebElement> marks = driver.findElements(By.xpath("//td[text()='10']|//td[text()='50']|//td[text()='40']"));
		
		int sum = 0;
		for(WebElement cell : marks) {
			String cellValue = cell.getText();
			try {
				int num = Integer.parseInt(cellValue);
				System.out.println(" " + cellValue);
				sum = sum + num;
			} catch(Exception e) {
				
			}
		}
		
		String totMarks = totalMarks.getText();
		int mark = Integer.parseInt(totMarks);
		if(sum == mark) {
			System.out.println("The Sum of total marks is same as Addition of all Marks");
		} else {
			System.out.println("The Sum of total marks is not same as Addition of all Marks");
		}
		
		System.out.println("The Sum is : " + sum);
		driver.close();
	}
}
