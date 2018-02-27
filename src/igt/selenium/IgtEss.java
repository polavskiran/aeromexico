package igt.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IgtEss {

	static WebDriver driver	= null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver	=	new ChromeDriver();
		//System.out.println(System.getenv());
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
		//driver	=	new FirefoxDriver();
		
		driver.get("http://pvs.kirankumar:Pola@1982@ess.igt.in/");
	}
}