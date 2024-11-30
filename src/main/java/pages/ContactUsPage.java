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

    // Locators for elements on the Contact Us page
    private By nameField = By.xpath("//span[text()='First Name']"); // Label for the "First Name" field
    private By emailField = By.xpath("//span[text()='Last Name']"); // Label for the "Last Name" field
    private By getInTouchButton = By.xpath("//input[@type='submit']"); // "Get in Touch" button
    private By firstNameInput = By.xpath("//input[@name='firstname']"); // Input for "First Name"
    private By lastNameInput = By.xpath("//input[@name='lastname']"); // Input for "Last Name"
    private By emailInput = By.xpath("//input[@name='email']"); // Input for "Email"
    private By companyInput = By.xpath("//input[@name='company']"); // Input for "Company Name"
    private By contactTypeDropdown = By.xpath("//div[@class='selector' and contains(@id, 'uniform-contact_type')]"); // Dropdown for contact type
    private By messageTextarea = By.xpath("//textarea[@name='message']"); // Textarea for the message
    private By requiredFieldError = By.xpath("//*[text()='Please complete this required field.']"); // Error message for required fields

    // Constructor
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait with 10 seconds timeout
    }

    // Verify if the "First Name" field label is displayed
    public boolean isNameFieldDisplayed() {
        WebElement nameFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        return nameFieldElement.isDisplayed();
    }

    // Verify if the "Last Name" field label is displayed
    public boolean isEmailFieldDisplayed() {
        WebElement emailFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        return emailFieldElement.isDisplayed();
    }

    // Verify if the "Get in Touch" button is displayed
    public boolean isGetInTouchButtonDisplayed() {
        WebElement getInTouchButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getInTouchButton));
        return getInTouchButtonElement.isDisplayed();
    }

    // Enter text into the "First Name" input field
    public void enterFirstName(String firstName) {
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }

    // Enter text into the "Last Name" input field
    public void enterLastName(String lastName) {
        WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }

    // Enter text into the "Email" input field
    public void enterEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    // Enter text into the "Company Name" input field
    public void enterCompanyName(String companyName) {
        WebElement companyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(companyInput));
        companyElement.clear();
        companyElement.sendKeys(companyName);
    }

    // Select an option from the "Contact Type" dropdown based on its value
    public void selectContactTypeOption(String optionValue) {
        // Click the dropdown to expand options
        WebElement contactTypeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(contactTypeDropdown));
        contactTypeElement.click(); // Expand dropdown

        // Locate the desired option by its value
        By dropdownOption = By.xpath("//option[@value='" + optionValue + "']");
        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(dropdownOption));
        optionElement.click(); // Select the desired option
    }

    // Enter text into the "Message" textarea
    public void enterMessage(String message) {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(messageTextarea));
        messageElement.clear();
        messageElement.sendKeys(message);
    }

    // Click the "Get in Touch" button
    public void clickGetInTouch() {
        WebElement getInTouchButtonElement = wait.until(ExpectedConditions.elementToBeClickable(getInTouchButton));
        getInTouchButtonElement.click();
    }

    // Verify if the "Please complete this required field" error is displayed
    public boolean isRequiredFieldErrorDisplayed() {
        List<WebElement> elements = driver.findElements(requiredFieldError);

        // Ensure only one error element exists, then verify its visibility
        if (elements.size() == 1) {
            return wait.until(ExpectedConditions.visibilityOf(elements.get(0))).isDisplayed();
        } else {
            throw new AssertionError("Expected only 1 error element, but found: " + elements.size());
        }
    }
}
