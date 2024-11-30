package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utils.BaseTest;

public class ContactUsTest extends BaseTest {
    private HomePage homePage; // Page object for the Home Page
    private ContactUsPage contactUsPage; // Page object for the Contact Us Page

    @BeforeMethod(alwaysRun = true)
    public void setUpTest() {
        // Initialize WebDriver and page objects before each test
        setUp();
        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);
    }

    @Test(groups = {"negative"})
    public void testVerifyRequiredFieldFirstName() {
        // Navigate to the home page and open the Contact Us form
        homePage.openHomePage("https://www.qubika.com");
        homePage.clickContactUs();

        // Fill in all fields except "First Name"
        contactUsPage.enterLastName("Test Last Name");
        contactUsPage.enterEmail("fernando496.496@gmail.com");
        contactUsPage.enterCompanyName("Test Company");
        contactUsPage.selectContactTypeOption("Interested in Qubika services");
        contactUsPage.enterMessage("This is a test message.");
        contactUsPage.clickGetInTouch();

        // Validate that the required field error is displayed for "First Name"
        assert contactUsPage.isRequiredFieldErrorDisplayed();
    }

    @Test(groups = {"negative"})
    public void testVerifyRequiredFieldLastName() {
        // Navigate to the home page and open the Contact Us form
        homePage.openHomePage("https://www.qubika.com");
        homePage.clickContactUs();

        // Fill in all fields except "Last Name"
        contactUsPage.enterFirstName("Test First Name");
        contactUsPage.enterEmail("fernando496.496@gmail.com");
        contactUsPage.enterCompanyName("Test Company");
        contactUsPage.selectContactTypeOption("Interested in Qubika services");
        contactUsPage.enterMessage("This is a test message.");
        contactUsPage.clickGetInTouch();

        // Validate that the required field error is displayed for "Last Name"
        assert contactUsPage.isRequiredFieldErrorDisplayed();
    }

    @Test(groups = {"negative"})
    public void testVerifyRequiredFieldEmail() {
        // Navigate to the home page and open the Contact Us form
        homePage.openHomePage("https://www.qubika.com");
        homePage.clickContactUs();

        // Fill in all fields except "Email"
        contactUsPage.enterFirstName("Test First Name");
        contactUsPage.enterLastName("Test Last Name");
        contactUsPage.enterCompanyName("Test Company");
        contactUsPage.selectContactTypeOption("Interested in Qubika services");
        contactUsPage.enterMessage("This is a test message.");
        contactUsPage.clickGetInTouch();

        // Validate that the required field error is displayed for "Email"
        assert contactUsPage.isRequiredFieldErrorDisplayed();
    }

    @Test(groups = {"negative"})
    public void testVerifyRequiredFieldCompanyName() {
        // Navigate to the home page and open the Contact Us form
        homePage.openHomePage("https://www.qubika.com");
        homePage.clickContactUs();

        // Fill in all fields except "Company Name"
        contactUsPage.enterFirstName("Test First Name");
        contactUsPage.enterLastName("Test Last Name");
        contactUsPage.enterEmail("fernando496.496@gmail.com");
        contactUsPage.selectContactTypeOption("Interested in Qubika services");
        contactUsPage.enterMessage("This is a test message.");
        contactUsPage.clickGetInTouch();

        // Validate that the required field error is displayed for "Company Name"
        assert contactUsPage.isRequiredFieldErrorDisplayed();
    }

    @Test(groups = {"negative"})
    public void testVerifyRequiredFieldMessage() {
        // Navigate to the home page and open the Contact Us form
        homePage.openHomePage("https://www.qubika.com");
        homePage.clickContactUs();

        // Fill in all fields except "Message"
        contactUsPage.enterFirstName("Test First Name");
        contactUsPage.enterLastName("Test Last Name");
        contactUsPage.enterEmail("fernando496.496@gmail.com");
        contactUsPage.enterCompanyName("Test Company");
        contactUsPage.selectContactTypeOption("Interested in Qubika services");
        contactUsPage.clickGetInTouch();

        // Validate that the required field error is displayed for "Message"
        assert contactUsPage.isRequiredFieldErrorDisplayed();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        // Clean up WebDriver after each test
        tearDown();
    }
}
