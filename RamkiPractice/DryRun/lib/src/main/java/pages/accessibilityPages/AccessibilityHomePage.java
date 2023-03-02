package pages.accessibilityPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethods;

public class AccessibilityHomePage extends ProjectSpecificMethods {

	WebDriver driver;
	List<String> PlaintiffNames = new ArrayList<>();
	List<String> DefendantNames = new ArrayList<>();

	@FindAll({ @FindBy(xpath = "*//div/div[contains(text(),'Plaintiff Name')]") })
	private List<WebElement> names;

	@FindBy(how = How.XPATH, using = "*//div/a[@class='next-link']")
	WebElement nextPageButton;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[3]/div[1]/div[3]/div[16]/div[3]/a[1]/span")
	WebElement totalNumberOfPagesAvilable;
	
	
	public AccessibilityHomePage(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
		PageFactory.initElements(driver, this);
	}
	
	public AccessibilityHomePage fetchPlaintiffNames() {

		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i).getText();
			String newStr = name.substring(0, name.indexOf("Filing"));
			String keepOnlyName = newStr.substring(name.indexOf(":") + 1);
			PlaintiffNames.add(keepOnlyName);
			System.out.println(keepOnlyName);
		}
		return this;
	}

	public AccessibilityHomePage fetchDefendantNames() {

		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i).getText();
			String newStr = name.substring(name.indexOf("Defendant Name") + 0);
			String keepOnlyName = newStr.substring(name.indexOf(":") + 1);
			String finalkey = keepOnlyName.replaceAll("[^a-zA-Z0-9 ']", " ");
			DefendantNames.add(finalkey);
			System.out.println(finalkey);

		}
		return this;
	}

	public AccessibilityHomePage goDownAndClickNextPage() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(500);
		Point point = nextPageButton.getLocation();
		int xcord = point.getX();
		System.out.println("Position of the webelement from left side is " + xcord + " pixels");
		int ycord = point.getY();
		System.out.println("Position of the webelement from top side is " + ycord + " pixels");
		Actions act = new Actions(driver);
		act.moveByOffset(xcord, ycord);
		nextPageButton.click();
		
		return this;
	}
	
	public AccessibilityHomePage getDetailsFromAllThePage() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(500);
		String lastPage = totalNumberOfPagesAvilable.getText();
		System.out.println("lastPage"+ lastPage);
		
//		
//		for (int i = 0; i < totalNumberOfPagesAvilable.; i++) {
//			array_type array_element = totalNumberOfPagesAvilable[i];
//			
//		}
//		fetchPlaintiffNames();
//		fetchDefendantNames();
//		goDownAndClickNextPage();
		
		
		return this;
	}
	

}
