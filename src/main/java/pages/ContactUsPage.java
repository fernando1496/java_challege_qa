package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ContactUsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By nameField = By.xpath("//span[text()='First Name']");
    private By emailField = By.xpath("//span[text()='Last Name']");
    private By getInTouchButton = By.xpath("//input[@type='submit']");
    private By firstNameInput = By.xpath("//input[@name='firstname']");
    private By lastNameInput = By.xpath("//input[@name='lastname']");
    private By emailInput = By.xpath("//input[@name='email']");
    private By companyInput = By.xpath("//input[@name='company']");
    private By contactTypeDropdown = By.xpath("//div[@class='selector' and contains(@id, 'uniform-contact_type')]");
    private By messageTextarea = By.xpath("//textarea[@name='message']");
    private By requiredFieldError = By.xpath("//*[text()='Please complete this required field.']");


    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait with 10 seconds timeout
    }

    // Existing methods
    public boolean isNameFieldDisplayed() {
        WebElement nameFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        return nameFieldElement.isDisplayed();
    }

    public boolean isEmailFieldDisplayed() {
        WebElement emailFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        return emailFieldElement.isDisplayed();
    }

    public boolean isGetInTouchButtonDisplayed() {
        WebElement getInTouchButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getInTouchButton));
        return getInTouchButtonElement.isDisplayed();
    }

    // New methods for form fields
    public void enterFirstName(String firstName) {
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterCompanyName(String companyName) {
        WebElement companyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(companyInput));
        companyElement.clear();
        companyElement.sendKeys(companyName);
    }

    public void selectContactTypeOption(String optionValue){
        // Click the dropdown to expand options
        WebElement contactTypeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(contactTypeDropdown));
        contactTypeElement.click(); // Expand dropdown

        // Locator for the dropdown option based on the value
        By dropdownOption = By.xpath("//option[@value='" + optionValue + "']");

        // Wait for the desired option to be visible and clickable, then click it
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(dropdownOption));
        optionElement.click();
    }



    public void enterMessage(String message) {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(messageTextarea));
        messageElement.clear();
        messageElement.sendKeys(message);
    }

    public void clickGetInTouch() {
        WebElement getInTouchButtonElement = wait.until(ExpectedConditions.elementToBeClickable(getInTouchButton));
        getInTouchButtonElement.click();
    }

    public boolean isRequiredFieldErrorDisplayed() {
        // Find all elements matching the locator
        List<WebElement> elements = driver.findElements(requiredFieldError);

        // Check the number of elements
        if (elements.size() == 1) {
            // If only one element, check its visibility
            return wait.until(ExpectedConditions.visibilityOf(elements.get(0))).isDisplayed();
        } else {
            // Fail the test if there are multiple elements
            throw new AssertionError("Expected only 1 error element, but found: " + elements.size());
        }
    }


}
