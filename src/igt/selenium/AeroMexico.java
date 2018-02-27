package igt.selenium;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AeroMexico {

	static WebDriver	driver;
	public static String webUrl = "https://world.aeromexico.com/en/uk";

	public static WebDriver getDriver(String browserName){
		if(browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\IGT-Selenium\\Drivers\\chromedriver.exe");
			driver	=	new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\IGT-Selenium\\Drivers\\geckodriver.exe");
			driver	=	new FirefoxDriver();
		}
		return driver;
	}

	// Date handling for two way
	public void setDate(String inDate, String outDate){
		// To be implemented
	}

	// Date handling for oneway(in date)
	public static String setDate(String inDate){

		String formattedDate = null;

		DateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = (Date) parser.parse(inDate);
			DateFormat formatter = new SimpleDateFormat("yyyy-MMMMM-dd"); // 2018-April-19
			formattedDate = formatter.format(date);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formattedDate;
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub

		// Method to get browser
		driver	=	getDriver("chrome");

		driver.get(webUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.findElement(By.id("one")).click();	// Using one way option

		WebElement fromCity = driver.findElement(By.id("from"));
		fromCity.clear();
		fromCity.sendKeys("London - Heathrow (LHR)");

		WebElement toCity = driver.findElement(By.id("to"));
		toCity.clear();
		toCity.sendKeys("Mexico City (MEX)");

		WebElement selectedCity = driver.findElement(By.xpath("//ul[@id='ui-id-4']/li"));
		selectedCity.click();

		String reqDate = setDate("2018-05-14");
		
		//System.out.println("Requested date converted to format "+reqDate);
		String[] dateParts = reqDate.split("-");
		//String Year = dateParts[0];
		String Month = dateParts[1];
		String Day = dateParts[2];

		// Click on Calendar icon
		WebElement departureDate	=	driver.findElement(By.id("date-init"));
		departureDate.click();

		// Condition to reach requested month
		while(!driver.findElement(By.className("ui-datepicker-title")).getText().contains(Month)){
			driver.findElement(By.linkText("Next")).click();
		}

		List<WebElement> allDays	=	driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

		for(WebElement day:allDays){
			String date = day.getText();

			// Condition to click on request day of the month
			if(date.contains(Day)){
				day.click();
				break;
			}
		}

		// Logic to pick Adults
		WebElement Adult = driver.findElement(By.xpath("//div[@id='adultsF']"));
		Adult.click();

		List<WebElement> adults = driver.findElements(By.xpath("//ul[@class='selector-class show']/li"));
		for(WebElement adult:adults){

			String adult1 = adult.getText();

			if(adult1.equalsIgnoreCase("2 Adults")){
				adult.click();
				break;
			}
		}

		driver.findElement(By.xpath("//*[@title='Click here to search your flight']")).submit();

		System.out.println(driver.getTitle());
		driver.quit();
	}
}