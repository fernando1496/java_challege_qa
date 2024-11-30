package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver; // WebDriver instance to be used by test classes

    // Sets up the WebDriver and browser configuration
    public void setUp() {
        // Automatically manages the ChromeDriver version
        WebDriverManager.chromedriver().setup();

        // Initializes the ChromeDriver instance
        driver = new ChromeDriver();

        // Maximizes the browser window
        driver.manage().window().maximize();

        // Sets a default implicit wait of 10 seconds for element loading
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Tears down the WebDriver instance after the test execution
    public void tearDown() {
        // Ensures the driver is quit if it has been initialized
        if (driver != null) {
            driver.quit();
        }
    }
}
