package igt.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Aero_Mexico {
	
	static WebDriver	driver;
	public static String webUrl = "https://world.aeromexico.com/en/uk";

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
		// TODO Auto-generated method stub
		
		driver	=	getDriver("chrome");		

		driver.get(webUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.id("one")).click();

		WebElement fromCity = driver.findElement(By.id("from"));
		fromCity.clear();
		fromCity.sendKeys("London - Heathrow (LHR)");

		WebElement toCity = driver.findElement(By.id("to"));
		toCity.clear();
		toCity.sendKeys("Mexico City (MEX)");
		
		WebElement selectedCity = driver.findElement(By.xpath("//ul[@id='ui-id-4']/li"));
		System.out.println(selectedCity.getText());
		selectedCity.click();

		// Click on Calendar icon
		WebElement departureDate	=	driver.findElement(By.id("date-init"));
		departureDate.click();
		
		while(!driver.findElement(By.className("ui-datepicker-title")).getText().contains("February"))     // Handle the  month
		  {
		     driver.findElement(By.linkText("Next")).click();
		   }
		
		                   // handle the Departure date
		  
		  int DepartureCount = driver.findElements(By.className("ui-state-default")).size();
		  
		  for(int i=0;i<DepartureCount;i++)
		   
		    {
		   
		          String gettext=   driver.findElements(By.className("ui-state-default")).get(i).getText();
		  if(gettext.equalsIgnoreCase("22"))
		  {
		    driver.findElements(By.className("ui-state-default")).get(i).click();
		      }
		      
		}
		  
		  WebElement Adult = driver.findElement(By.xpath("//div[@id='adultsF']"));
			Adult.click();

			List<WebElement> adults = driver.findElements(By.xpath("//ul[@class='selector-class show']/li"));
			//System.out.println(adults.size());
			for(WebElement adult:adults){

				String adult1 = adult.getText();

				if(adult1.equalsIgnoreCase("2 Adults")){
					//System.out.println("Success");
					adult.click();
					break;
				}
			}

			driver.findElement(By.xpath("//*[@title='Click here to search your flight']")).submit();

			System.out.println(driver.getTitle());
	}
}
