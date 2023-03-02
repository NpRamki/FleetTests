package pages.ekartPages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethods;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ProjectSpecificMethods {

	static List<WebElement> productPrices;
	static List<WebElement> productNames;

	public HomePage(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "*//title")
	WebElement pageTitle;

	@FindBy(how = How.XPATH, using = "*//input[@type='search']")
	WebElement searchBox;

	@FindBy(how = How.XPATH, using = "*//button[@type='submit']")
	WebElement submitButton;

	@FindBy(how = How.XPATH, using = "*//div/a[@href='#/offers']")
	WebElement topDealsButton;

	@FindBy(how = How.XPATH, using = "*//tr/td[contains(text(),'Items')]")
	WebElement itemsField;

	@FindBy(how = How.XPATH, using = "(*//tr/td/strong)[1]")
	WebElement itemsQuantity;

	@FindBy(how = How.XPATH, using = "*//tr/td[contains(text(),'Price')]")
	WebElement priceField;

	@FindBy(how = How.XPATH, using = "(*//tr/td/strong)[2]")
	WebElement priceDisplay;

	@FindBy(how = How.XPATH, using = "*//a[@class='cart-icon']")
	WebElement cartBasketButton;

	@FindBy(how = How.XPATH, using = "*//div[@class='action-block']//button[contains(text(),'PROCEED TO CHECKOUT')]")
	WebElement proceedToCheckOutButton;
	
	@FindBy(how = How.XPATH, using = "*//div[@class='cart']/a[3]")
	WebElement flightTicketButton;

	@FindBy(how = How.XPATH, using= "//footer/p/strong")
	WebElement footerText;
	
	@FindBy(how = How.XPATH, using= "*//ul[@class='cart-items']//li")
	WebElement cartItem;
	
	@FindAll({ @FindBy(how = How.XPATH, using = "*//ul[@class='cart-items']//li") })
	private List<WebElement> cartItems;

	
	
	@FindAll({ @FindBy(how = How.XPATH, using = "*//div[@class='product']") })
	private List<WebElement> productTiles;

	@FindAll({ @FindBy(how = How.XPATH, using = "*//div[@class='product-action']/button[@type='button']") })
	private List<WebElement> addToCartButton;

	@FindAll({ @FindBy(how = How.XPATH, using = "*//div[@class='stepper-input']/a[@class='increment']")})
	private List<WebElement> increaseButton;

	@FindAll({ @FindBy(how = How.XPATH, using = "*//div[@class='stepper-input']/a[@class='decrement']")})
	private List<WebElement> decreaseButton;

	@FindAll({ @FindBy(how = How.XPATH, using = "*//div[@class='product-action']/button[@class='added']")})
	private List<WebElement>  addedButtons;

	@FindAll({ @FindBy(how = How.XPATH, using = "*//div[@class='products-wrapper']//div/div/h4") })
	private List<WebElement> productName;

	@FindAll({ @FindBy(how = How.XPATH, using = "*//div[@class='products-wrapper']//div/div/p") })
	private List<WebElement> productPrice;

	public HomePage verifyHomePage() throws IOException {
		try {
			String title =pageTitle.getText();
			Assert.assertEquals(title, "GreenKart - veg and fruits kart");
			reportStep("Page title is displayed and matched", "pass");
		} catch (Exception e) {
			reportStep("Page title is not displayed/matched", "fail");
		}
		return this;
	}

	public HomePage searchField() throws IOException {

		try {
			searchBox.isDisplayed();
			reportStep("searchField is displayed", "pass");
		} catch (Exception e) {
			reportStep("searchField is not displayed", "fail");
		}
		return this;
	}

	public HomePage getproductNames() throws IOException {
		try {
			productNames = productName;
			for (int i = 0; i < productNames.size(); i++) {
				String string = productNames.get(i).getText();
				System.out.println(string);

			}
			reportStep("product names is displayed", "pass");
		} catch (Exception e) {
			reportStep("searchField is not displayed", "fail");
		}
		return this;
	}

	public HomePage getproductPrice() throws IOException {

		try {
			productPrices = productPrice;
			for (int i = 0; i < productPrices.size(); i++) {
				String string = productPrices.get(i).getText();
				System.out.println(string);
			}
			reportStep("product names is displayed", "pass");
		} catch (Exception e) {
			reportStep("searchField is not displayed", "fail");
		}
		return this;
	}

	public HomePage searchFieldFunctionality(String searchText) throws IOException {

		try {
			searchBox.isDisplayed();
			searchBox.sendKeys(searchText);
			int size = productTiles.size();
			Assert.assertEquals(size == 1, true);
			reportStep("product searched is displayed and quantity is 1", "pass");
		} catch (Exception e) {
			reportStep("searchField is not displayed", "fail");
		}
		return this;

	}

	public HomePage topDealsButton() throws IOException {

		try {

			topDealsButton.isDisplayed();
			reportStep("topDealsButton is displayed", "pass");
		} catch (Exception e) {
			reportStep("searchField is not displayed", "fail");
		}

		return this;
	}

	public HomePage cartBagIsDisplayed() throws IOException {

		try {
			cartBasketButton.isDisplayed();
			reportStep("topDealsButton is displayed", "pass");
		} catch (Exception e) {
			reportStep("searchField is not displayed", "fail");
		}

		return this;
	}

	public HomePage cartBagButtonFunctionality() throws IOException {

		try {
			    cartBasketButton.isDisplayed();
                productTiles.get(2);
                increaseButton.get(2).click();
                addToCartButton.get(2).click();
                System.out.println("itemsQuantity.getText()"+itemsQuantity.getText());          
                String quant = itemsQuantity.getText();
                String str=quant;
                int t=Integer.parseInt(str);
                Assert.assertEquals(t, 1);
			    reportStep("Product added to the cart and is displayed in the bag", "pass");
		} catch (Exception e) {
			reportStep("searchField is not displayed", "fail");
		}

		return this;
	}
	
	public HomePage flightBookingButton() throws IOException {
		
		try {
			flightTicketButton.isDisplayed();
			reportStep("flight Ticket is displayed", "pass");
		} catch (Exception e) {
			reportStep("searchField is not displayed", "fail");
		}

		return this;
	}
	
	public HomePage addToCartButtoFunctionality() throws IOException {
		
		try {
			addToCartButton.get(5).click();
			addedButtons.get(5).isDisplayed();
			reportStep("Items added and added button toast is displayed", "pass");
		} catch (Exception e) {
			reportStep("searchField is not displayed", "fail");
		}
		
		return this;
	}
	
	public HomePage footerSection() throws IOException {
		
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;		
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			footerText.isDisplayed();
			reportStep("footer text is displayed", "pass");
		} catch (Exception e) {
			reportStep("footer text is not displayed", "fail");
		}
		
		
		return this;
	}
	
	public HomePage addItemsButton() throws IOException {

		try {
			int addButtons = increaseButton.size();
			System.out.println("add button is displayed for all products");
			Assert.assertEquals(addButtons, 30);
			reportStep("add button is displayed", "pass");
			
		} catch (Exception e) {
			reportStep("footer text is not displayed", "fail");
		}
		return this;
	}
	
	public HomePage decreaseItemsButton() throws IOException {

		try {
			int decreaseButtons = decreaseButton.size();
			System.out.println("decrease button is displayed for all products");
			Assert.assertEquals(decreaseButtons, 30);
			reportStep("decrease Button is displayed", "pass");
			
		} catch (Exception e) {
			reportStep("footer text is not displayed", "fail");
		}
		return this;
	}
	
	public HomePage proceedToCheckout() throws IOException {

		try {
			cartBagButtonFunctionality();
            cartBasketButton.click();
            proceedToCheckOutButton.click();
            String cartPage= pageTitle.getText();
            System.out.println(cartPage);
            Assert.assertNotSame(cartPage, "GreenKart - veg and fruits kart");
		} catch (Exception e) {
			reportStep("Checkout page is not displayed", "fail");
		}
		return this;
	}
	

}
