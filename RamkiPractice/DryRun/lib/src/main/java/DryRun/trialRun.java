package DryRun;

import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class trialRun {
	
static List<WebElement> productName;
	

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		
		
	System.out.println(driver.findElement(By.xpath("//*[@id='root']/div/header/div/div[3]/div[1]/table/tbody/tr[1]/td[3]/strong")));
	
	
	
	driver.quit();
//List<WebElement> names = driver.findElements(By.xpath("*//div/div[contains(text(),'Plaintiff Name')]"));
//
//for (int i = 0; i < names.size(); i++) {
//	 System.out.println(names.get(i).getText());
//	
//}
//
//System.out.println("~~~~~~~~~~~**********************8~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//
//List<String> PlaintiffNames = new ArrayList<>();
//List<String> DefendantNames = new ArrayList<>();
//
//for (int i = 0; i < names.size(); i++) {
//	
//	 String name = names.get(i).getText();
//	 String newStr = name.substring(0, name.indexOf("Filing"));
//	 String keepOnlyName= newStr.substring(name.indexOf(":")+1);
//	 PlaintiffNames.add(keepOnlyName);
//	 
//	 System.out.println(keepOnlyName);
//}
//
//System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//
//for (int i = 0; i < names.size(); i++) {
//	
//	 String name = names.get(i).getText();
//	 String newStr =  name.substring(name.indexOf("Defendant Name")+0);
//	 String keepOnlyName= newStr.substring(name.indexOf(":")+1);
//
//	 String finalkey = keepOnlyName.replaceAll("[^a-zA-Z0-9 ']", " ");  
//
//	 DefendantNames.add(finalkey);
//	 System.out.println(finalkey);
//	 
//}
//
//JavascriptExecutor js = (JavascriptExecutor) driver;
//
//
//WebElement ele  = driver.findElement(By.xpath("*//div/a[@class='next-link']"));
//
////get the height of the webpage and scroll to the end
//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//Thread.sleep(500);
//
////Used points class to get x and y coordinates of element.
//		Point point = ele.getLocation();
//		int xcord = point.getX();
//		System.out.println("Position of the webelement from left side is "+xcord +" pixels");
//		int ycord = point.getY();
//		System.out.println("Position of the webelement from top side is "+ycord +" pixels");
//		
//		
//Actions act = new Actions(driver);
//
//act.moveByOffset(xcord, ycord);
//
//ele.click();
//



		
	}
}
