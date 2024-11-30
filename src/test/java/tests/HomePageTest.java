package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import utils.BaseTest;

public class HomePageTest extends BaseTest {
    private HomePage homePage;
    private ContactUsPage contactUsPage;

    @BeforeMethod(alwaysRun = true)
    public void setUpTest() {
        setUp();
        homePage = new HomePage(driver);
        contactUsPage = new ContactUsPage(driver);
    }

    @Test(groups = {"positive"})
    public void testHomePageAndContactUsFormDisplay() {
        // Navigate to the home page
        homePage.openHomePage("https://www.qubika.com");
        assert driver.getCurrentUrl().equals("https://qubika.com/");
        assert homePage.isLogoDisplayed(); // Validate the logo is displayed

        // Click the Contact Us button
        homePage.clickContactUs();

        // Validate that the contact form elements are displayed
        assert contactUsPage.isNameFieldDisplayed();
        assert contactUsPage.isEmailFieldDisplayed();
        assert contactUsPage.isGetInTouchButtonDisplayed();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        tearDown();
    }
}
