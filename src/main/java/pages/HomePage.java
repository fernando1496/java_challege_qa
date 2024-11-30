package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By logo = By.cssSelector("a.logo"); // Locator for the logo element on the home page
    private By contactUsButton = By.xpath("(//a[contains(text(),'Contact Us')])[1]"); // Locator for the "Contact Us" button

    // Constructor to initialize WebDriver and WebDriverWait
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait with 10 seconds timeout
    }

    // Opens the specified URL in the browser
    public void openHomePage(String url) {
        driver.get(url); // Navigate to the home page URL
    }

    // Checks if the logo element is visible on the page
    public boolean isLogoDisplayed() {
        WebElement logoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logo)); // Wait until the logo is visible
        return logoElement.isDisplayed(); // Return true if the logo is displayed
    }

    // Clicks the "Contact Us" button on the home page
    public void clickContactUs() {
        WebElement contactUsButtonElement = wait.until(ExpectedConditions.elementToBeClickable(contactUsButton)); // Wait until the button is clickable
        contactUsButtonElement.click(); // Click the "Contact Us" button
    }
}
