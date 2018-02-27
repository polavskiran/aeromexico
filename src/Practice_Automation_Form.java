//import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practice_Automation_Form {

	static WebDriver	driver;
	
	public static WebDriver getDriver(String browserName){
		if(browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\IGT-Selenium\\Drivers\\chromedriver.exe");
			driver	=	new ChromeDriver();
			
			//return driver;
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\IGT-Selenium\\Drivers\\geckodriver.exe");
			driver	=	new FirefoxDriver();
			
			//return driver;
		}
		return driver;
	}

	public static void main(String[] args) {

		driver	=	getDriver("chrome");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.toolsqa.com/automation-practice-form/");
		driver.manage().window().maximize();
		
		//Thread.sleep(3000);
		
		//String pageTitle	=	driver.getTitle();
		//System.out.println("Page Title is: "+pageTitle);

		WebElement partialLinkTest = driver.findElement(By.partialLinkText("Partial"));
		partialLinkTest.click();

		WebElement	linkTest	=	driver.findElement(By.linkText("Link Test"));
		linkTest.click();
		driver.navigate().to("http://www.toolsqa.com/automation-practice-form/");

		WebElement firstName	=	driver.findElement(By.name("firstname"));
		firstName.clear();
		firstName.sendKeys("Kiran");

		WebElement lastName	=	driver.findElement(By.name("lastname"));
		lastName.clear();
		lastName.sendKeys("Kumar");
		
		driver.findElement(By.id("sex-0")).click();
		
		driver.findElement(By.id("exp-6")).click();
		
		driver.findElement(By.id("datepicker")).sendKeys("2018/12/19");
		
		driver.findElement(By.id("profession-1")).click();
		
		driver.findElement(By.id("tool-2")).click();
		
		driver.findElement(By.id("submit")).click();

		//driver.quit();
	}
}