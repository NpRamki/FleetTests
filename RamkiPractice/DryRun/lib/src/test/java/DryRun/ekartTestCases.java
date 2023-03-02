package DryRun;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.ekartPages.CheckOutPage;
import pages.ekartPages.HomePage;


public class ekartTestCases extends ProjectSpecificMethods{
	

	@BeforeTest
	public void setDetails() {
		excelFileName ="ekart";
		testName = "Ekart tests";
		testDescription = "Verify Basic sanity check on functionality of the elements in the page is loaded and working fine as expected";
		testCategory = "Sanity";
		testAuthor = "Ramki";
	}
	
	@Test
	public void verifyTitle() throws InterruptedException, IOException {
		
		new HomePage(driver,node).verifyHomePage();	
	}
	
	@Test
	public void verifySearchFieldIsDisplayed() throws IOException {
		
		new HomePage(driver, node).searchField();
	}

	@Test(dataProvider = "fetchData")
	public void validateSearchFieldFunctionality(String searchQuery ) throws IOException {
		
		
		new HomePage(driver, node).searchFieldFunctionality(searchQuery);
	}
	
	@Test
	public void validateTopDealsIsDisplayed() throws IOException{
		
		new HomePage(driver, node).topDealsButton();
	}

	@Test
	public void flightBookingButtonIsdisplayed() throws IOException {
		
		new HomePage(driver, node).flightBookingButton();
	}
	
	@Test
	public void verifyAddToCartButtonIsDisplayed() throws IOException {
		
		new HomePage(driver, node).addToCartButtoFunctionality();
	}

	@Test
	public void verifyAddItemsButtonIsDisplayed() throws IOException {
		
		new HomePage(driver, node).addItemsButton();
	}
	
	
	@Test
	public void verifyDecreaseItemsButtonIsDisplayed() throws IOException {
		
		new HomePage(driver, node).decreaseItemsButton();
		
	}

	@Test
	public void verifyProductNameIsDisplayed() throws IOException {
		
		new HomePage(driver, node).getproductNames();
		
	}
	
	@Test
	public void verifyProductPriceIsDisplayed() throws IOException {
		
		new HomePage(driver, node).getproductPrice();
	}
	
	@Test
	public void verifyBagFunctionality() throws IOException {
		
		new HomePage(driver, node).cartBagButtonFunctionality();
	}
	
	
	@Test
	public void validateProductCheckOut() throws IOException {
		
		new HomePage(driver, node).proceedToCheckout();
	}
	
	@Test
	public void proceedToCheckOut() throws IOException {
		
		new CheckOutPage(driver, node).proceedToCheckOutCart();
	}
	
}
