package Flipkartpage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartTotal {
public static void main(String[] args) {
		
		
		
		System.setProperty("webdriver.chrome.driver","/Users/anand/Documents/Automation/Flipkart/chromedriver");
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		 
		driver.manage().window().maximize();
	
	
	// Waits
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
	 
			// Resources
			WebElement searchBar = driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
			
			//Adding First Product
			
			searchBar.sendKeys("Motorola G34");
			searchBar.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//div[contains(text(),'Motorola')]")).click();
	 
			String parent = driver.getWindowHandle();
			Set<String> s = driver.getWindowHandles();
			Iterator<String> I1 = s.iterator();
			while (I1.hasNext()) {
				String child_window = I1.next();
				if (!parent.equals(child_window)) {
					driver.switchTo().window(child_window);
				}
			}
			
			WebElement addToCart = driver.findElement(By.cssSelector(".row button"));
			w.until(ExpectedConditions.visibilityOfAllElements(addToCart));
			addToCart.click();
			driver.switchTo().window(parent);
			
			
			//Adding second Product
			
			
			searchBar = driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
			searchBar.clear();
			searchBar.sendKeys("Motorola Tablets");
			searchBar.sendKeys(Keys.ENTER);
			w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[contains(text(),'Tablet')])[2]")));
			driver.findElement(By.xpath("(//div[contains(text(),'Tablet')])[2]")).click();
			
			s = driver.getWindowHandles();
			I1 = s.iterator();
			while (I1.hasNext()) {
				String child_window = I1.next();
				if (!parent.equals(child_window)) {
					driver.switchTo().window(child_window);
				}
			}
			addToCart = driver.findElement(By.cssSelector(".row button"));
			addToCart.click();
			
			
			//Getting details from Cart
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Total Amount')]")));
			List<WebElement> itemsName = driver.findElements(By.cssSelector("._2Kn22P.gBNbID"));
			List<WebElement> itemsPrice = driver.findElements(By.cssSelector("._2-ut7f._1WpvJ7"));
			List<WebElement> itemsQty = driver.findElements(By.cssSelector("._253qQJ")); //get attribute value
			
			System.out.println("The Items in the Cart are: ");
			System.out.println("==============================\n");
			
			
			for(int i = 0; i < itemsName.size(); i++) {
				System.out.println("Item Name: "+itemsName.get(i).getText()+"\tPrice: "+itemsPrice.get(i).getText()+"\tQty: "+itemsQty.get(i).getAttribute("value")+"\n");
			}
			int sum = 0;
			for (int i = 0; i < itemsPrice.size(); i++) {
				String k = "";
			char[] c = itemsPrice.get(i).getText().substring(1).toCharArray();
				for(char a: c) {if(Character.isDigit(a)) k = k + a;}
				sum = sum + Integer.parseInt(k);
			}
			System.out.print("Total price is : " + sum);
			driver.quit();
		}
	 
	}
	 


