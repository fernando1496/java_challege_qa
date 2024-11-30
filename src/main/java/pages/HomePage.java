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
    private By logo = By.cssSelector("a.logo");
    private By contactUsButton = By.xpath("(//a[contains(text(),'Contact Us')])[1]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait with 10 seconds timeout
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public boolean isLogoDisplayed() {
        WebElement logoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
        return logoElement.isDisplayed();
    }

    public void clickContactUs() {
        WebElement contactUsButtonElement = wait.until(ExpectedConditions.elementToBeClickable(contactUsButton));
        contactUsButtonElement.click();
    }
}
