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

public class AddtoCart {

	public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver","/Users/anand/Documents/Automation/Flipkart/chromedriver");
	
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	 
	// Waits
	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Resources
	WebElement searchBar = driver.findElement(By.xpath("//input[contains(@title,'Search')]"));
//	WebElement addtocart = driver.findElement(By.xpath("(//ul[@class = 'row']//button)[1]"));

	// Functionality
	Thread.sleep(2000);
	searchBar.sendKeys("Motorola G34");
	searchBar.sendKeys(Keys.ENTER);
	
	driver.findElement(By.xpath("//div[contains(text(),'Motorola G34')]")).click();
	String parent = driver.getWindowHandle();
	Set<String> s = driver.getWindowHandles();
	Iterator<String> I1 = s.iterator();
	while (I1.hasNext()) {
		String child_window = I1.next();
		if (!parent.equals(child_window)) {
			driver.switchTo().window(child_window);
		}
	}
	WebElement addtocart = driver.findElement(By.xpath("(//ul[@class = 'row']//button)[1]"));
	 addtocart.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	w.until(ExpectedConditions.titleContains("Shopping Cart"));
	Thread.sleep(2000);
	driver.close();
	//perform actions on new window
	driver.switchTo().window(parent);
	
	//Adding second Product

	searchBar = driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
	searchBar.clear();
	searchBar.sendKeys("Motorola Tablets");
	searchBar.sendKeys(Keys.ENTER);
	// w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[contains(text(),'Tablet')])[2]")));
// driver.findElement(By.xpath("(//div[contains(text(),'Tablet')])[2]")).click();
//	driver.navigate().refresh();
//	driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
	driver.findElement(By.xpath("//div[contains(text(),'MOTOROLA Tab')]")).click();
	s = driver.getWindowHandles();
	I1 = s.iterator();
	while (I1.hasNext()) {
		String child_window = I1.next();
		if (!parent.equals(child_window)) {
			driver.switchTo().window(child_window);
		}
	}
//		driver.switchTo().window(newwin);
	//System.out.println(" "+driver.getTitle());
	
	
//	String win2 = it.next();
//	driver.switchTo().window(win2);
	
	addtocart = driver.findElement(By.xpath("(//ul[@class = 'row']//button)[1]"));
	 addtocart.click();
	 Thread.sleep(2000);
	  driver.findElement(By.xpath("((//button[@class = '_23FHuj'])[2])")).click();
		
	  
	  //Getting details from Cart
	  Thread.sleep(2000);
		
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


		
				
	
	
	
	

//	String parent = driver.getWindowHandle();
//	Set<String> s = driver.getWindowHandles();


//	Iterator<String> I1 = s.iterator();

	//while (I1.hasNext()) {
	//	String child_window = I1.next();
	//	if (!parent.equals(child_window)) {
		//	driver.switchTo().window(child_window);
//		//	driver.close();
	

	//}

//	w.until(ExpectedConditions.visibilityOfAllElements(actionBtns));
//	actionBtns.get(0).click();

//	
//	
//	searchBar.sendKeys("Motorola Tablets");
//	searchBar.sendKeys(Keys.ENTER);
//	

 //}

 // }


// }
 // }
