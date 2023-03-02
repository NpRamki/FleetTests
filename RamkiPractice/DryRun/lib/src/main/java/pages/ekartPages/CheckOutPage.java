package pages.ekartPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethods;

public class CheckOutPage extends ProjectSpecificMethods {
	
	public CheckOutPage(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how = How.XPATH, using = "//div[@class='products']//table)")
	WebElement productTable;

	@FindBy(how = How.XPATH, using = "*//div[@class='promoWrapper']/input")
	WebElement promoCodeField;
	
	@FindBy(how = How.XPATH, using = "*//div[@class='promoWrapper']/button")
	WebElement promoCodeApplyButton;
	
	@FindBy(how = How.XPATH, using = "*//*[@id='root']/div/div/div/div/button")
	WebElement proceedButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div/div/div/b[1]")
	WebElement noOfItemsSection;
	
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div/div/div/b[2]")
	WebElement totalAmountSection;
	
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div/div/div/b[3]")
	WebElement discountSection;
	
	@FindBy(how = How.XPATH, using = "//*[@id='root']/div/div/div/div/b[4]")
	WebElement totalAmountAfterDiscontSection;
	
	@FindBy(how = How.XPATH, using = "*//select")
	WebElement dropDownOption;
	
	@FindBy(how = How.XPATH, using = "*//div[@class='wrapperTwo']/label")
	WebElement chooseCountryTitle;
	
	@FindBy(how = How.XPATH, using = "*//input[@type='checkbox']")
	WebElement termsAndConditionsCheckbox;
	
	@FindBy(how = How.XPATH, using = "*//span[@class='errorAlert']/b")
	WebElement alertOnNotAcceptingTermsAndConditions;
	
	@FindBy(how = How.XPATH, using = "*//div[@class='wrapperTwo']/span")
	WebElement orderConfirmationMessage;
	
	public CheckOutPage proceedToCheckOutCart() throws IOException {
		try {
			
			try {
				HomePage homePage = new HomePage(driver, node);
				homePage.proceedToCheckout();
				proceedButton.click();
				Select objSelect = new Select(dropDownOption);
				objSelect.selectByValue("India");
				termsAndConditionsCheckbox.click();
				proceedButton.click();
				String text =orderConfirmationMessage.getText();
				Assert.assertEquals(text, "Thank you, your order has been placed successfully\n"
						+ "You'll be redirected to Home page shortly!!");
				reportStep("Order placed successfully", "pass");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			reportStep("Unable to place order", "fail");
		}
		return this;
	}
	
}
