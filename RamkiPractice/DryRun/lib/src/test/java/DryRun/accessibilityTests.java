package DryRun;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.accessibilityPages.AccessibilityHomePage;
import pages.ekartPages.CheckOutPage;
import pages.ekartPages.HomePage;

public class accessibilityTests extends ProjectSpecificMethods{
	

	@BeforeTest
	public void setDetails() {
		testName = "Accessibility page tests";
		testDescription = "Fetch the names mentioned in the test case";
		testCategory = "Sanity";
		testAuthor = "Ramki";
	}
	
//	@Test
//	public void fetchPlaintiffNameFromThePage() throws InterruptedException, IOException {
//		
//		new AccessibilityHomePage(driver,node).fetchPlaintiffNames();	
//	}
//	
//	
//	@Test
//	public void fetchDefendantNamesNameFromThePage() throws InterruptedException, IOException {
//		
//		new AccessibilityHomePage(driver,node).fetchPlaintiffNames();	
//	}
	
	
	@Test
	public void fetchDetailUntilLastPage() throws InterruptedException, IOException {
		
		new AccessibilityHomePage(driver,node).getDetailsFromAllThePage();	
	}
	
	
	
	
}
