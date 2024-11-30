package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utils.BaseTest;

public class ContactUsTest extends BaseTest {
    private HomePage homePage;
    private ContactUsPage contactUsPage;

    @BeforeMethod(alwaysRun = true)
    public void setUpTest() {
        setUp();
        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);
    }

    @Test(groups = {"negative"})
    public void testVerifyRequiredFieldFirstName() {
        homePage.openHomePage("https://www.qubika.com");
        homePage.clickContactUs();

        contactUsPage.enterLastName("Test Last Name");
        contactUsPage.enterEmail("fernando496.496@gmail.com");
        contactUsPage.enterCompanyName("Test Company");
        contactUsPage.selectContactTypeOption("Interested in Qubika services");
        contactUsPage.enterMessage("This is a test message.");
        contactUsPage.clickGetInTouch();

        // Validate the required field error is displayed
        assert contactUsPage.isRequiredFieldErrorDisplayed();
    }

    @Test(groups = {"negative"})
    public void testVerifyRequiredFieldLastName() {
        homePage.openHomePage("https://www.qubika.com");
        homePage.clickContactUs();

        contactUsPage.enterFirstName("Test First Name");
        contactUsPage.enterEmail("fernando496.496@gmail.com");
        contactUsPage.enterCompanyName("Test Company");
        contactUsPage.selectContactTypeOption("Interested in Qubika services");
        contactUsPage.enterMessage("This is a test message.");
        contactUsPage.clickGetInTouch();

        // Validate the required field error is displayed
        assert contactUsPage.isRequiredFieldErrorDisplayed();
    }

    @Test(groups = {"negative"})
    public void testVerifyRequiredFieldEmail() {
        homePage.openHomePage("https://www.qubika.com");
        homePage.clickContactUs();

        contactUsPage.enterFirstName("Test First Name");
        contactUsPage.enterLastName("Test Last Name");
        contactUsPage.enterCompanyName("Test Company");
        contactUsPage.selectContactTypeOption("Interested in Qubika services");
        contactUsPage.enterMessage("This is a test message.");
        contactUsPage.clickGetInTouch();

        // Validate the required field error is displayed
        assert contactUsPage.isRequiredFieldErrorDisplayed();
    }

    @Test(groups = {"negative"})
    public void testVerifyRequiredFieldCompanyName() {
        homePage.openHomePage("https://www.qubika.com");
        homePage.clickContactUs();

        contactUsPage.enterFirstName("Test First Name");
        contactUsPage.enterLastName("Test Last Name");
        contactUsPage.enterEmail("fernando496.496@gmail.com");
        contactUsPage.selectContactTypeOption("Interested in Qubika services");
        contactUsPage.enterMessage("This is a test message.");
        contactUsPage.clickGetInTouch();

        // Validate the required field error is displayed
        assert contactUsPage.isRequiredFieldErrorDisplayed();
    }

    @Test(groups = {"negative"})
    public void testVerifyRequiredFieldMessage() {
        homePage.openHomePage("https://www.qubika.com");
        homePage.clickContactUs();

        contactUsPage.enterFirstName("Test First Name");
        contactUsPage.enterLastName("Test Last Name");
        contactUsPage.enterEmail("fernando496.496@gmail.com");
        contactUsPage.enterCompanyName("Test Company");
        contactUsPage.selectContactTypeOption("Interested in Qubika services");
        contactUsPage.clickGetInTouch();

        // Validate the required field error is displayed
        assert contactUsPage.isRequiredFieldErrorDisplayed();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        tearDown();
    }
}
