package igt.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ConfigTool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Open browser
		// Navigate to URL
		// Enter username
		// Enter password
		// select tool
		// click on submit
		
		// Check validations
		
		
		WebDriver driver	=	new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://mail.google.com/");
		
		driver.navigate().to("http://ct.uccpreconfig.fastbooking.ch/fbct/");
		
		//driver.get("http://ct.uccpreconfig.fastbooking.ch/fbct/");
		
		WebElement loginId	=	driver.findElement(By.id("txtLoginID"));
		loginId.sendKeys("pkiran");
		
		WebElement password	=	driver.findElement(By.id("pwdKey"));
		password.sendKeys("p1004kiran");
		
		WebElement toolElement	=	driver.findElement(By.id("tool"));
		
		Select toolSelect	=	new Select(toolElement);
		toolSelect.selectByValue("UD");
		
		driver.findElement(By.id("btnLogin")).click();

	}

}
