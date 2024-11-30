package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utils.BaseTest;

public class HomePageTest extends BaseTest {
    private HomePage homePage; // Page object for the Home Page
    private ContactUsPage contactUsPage; // Page object for the Contact Us Page

    @BeforeMethod(alwaysRun = true)
    public void setUpTest() {
        // Initialize WebDriver and page objects before each test
        setUp();
        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);
    }

    @Test(groups = {"positive"})
    public void testHomePageAndContactUsFormDisplay() {
        // Step 1: Navigate to the home page
        homePage.openHomePage("https://www.qubika.com");

        // Step 2: Validate the current URL and that the home page logo is displayed
        assert driver.getCurrentUrl().equals("https://qubika.com/");
        assert homePage.isLogoDisplayed();

        // Step 3: Click the "Contact Us" button
        homePage.clickContactUs();

        // Step 4: Validate that the "Contact Us" form is displayed correctly
        assert contactUsPage.isNameFieldDisplayed(); // Verify the "First Name" field is displayed
        assert contactUsPage.isEmailFieldDisplayed(); // Verify the "Last Name" field is displayed
        assert contactUsPage.isGetInTouchButtonDisplayed(); // Verify the "Get in Touch" button is displayed
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        // Clean up WebDriver after each test
        tearDown();
    }
}
