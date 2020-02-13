import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumRunner {

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\IGT-Selenium\\Drivers\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://world.aeromexico.com/en/uk");
		driver.manage().window().maximize();
		
		WebElement oneway	=	driver.findElement(By.id("one"));
		oneway.click();
		
		WebElement departure	=	driver.findElement(By.id("from"));
		departure.clear();
		departure.sendKeys("Berlin (TXL)");
		
		WebElement destination	=	driver.findElement(By.id("to"));
		destination.clear();
		destination.sendKeys("Mexico City (MEX)");
		
		WebElement fromDate	=	driver.findElement(By.id("date-init"));
		fromDate.sendKeys("Sat, Dec 16, 2017");
		
			
		WebElement btnSubmit	=	driver.findElement(By.xpath("//*[@id='flight']/fieldset/div[8]/input"));
		btnSubmit.click();		
		driver.quit();
	}
}
