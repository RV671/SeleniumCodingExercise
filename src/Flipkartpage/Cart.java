package Flipkartpage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
	
	public static void main(String[] args) {
		
		
		
		System.setProperty("webdriver.chrome.driver","/Users/anand/Documents/Automation/Flipkart/chromedriver");
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
		driver.findElement(By.xpath("//span[contains(text(),'Mobiles')]")).click();
		driver.findElement(By.xpath("//a[@aria-label= 'Electronics']")).click();
		WebElement hoverable = driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
		Actions action = new Actions(driver);
		action.moveToElement(hoverable).perform();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Apple']"))));
		driver.findElement(By.xpath("//a[@title='Apple']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 14 (Blue, 128 GB)')]")).click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		  
		  driver.switchTo().window(tabs.get(1));
		  
		  System.out.println(driver.getTitle());
		  
		  driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		
		  
	}


		
		
		
		
		
		
		
		
	


}
