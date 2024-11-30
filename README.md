
# **Java QA Challenge Framework**

## **Overview**
This framework is built using Java, TestNG, Selenium, and Allure for end-to-end testing and reporting. The framework supports running tests grouped as `positive` and `negative` and generating Allure reports.

---

## **Pre-requisites**
1. **Java Development Kit (JDK):**
    - Ensure JDK 11 or higher is installed.
    - Verify installation:
      ```bash
      java -version
      ```
2. **Maven:**
    - Install Maven for dependency management and project build.
    - Verify installation:
      ```bash
      mvn -version
      ```

3. **Allure Command-Line Tool:**
    - Install Allure to generate and view test reports.
    - Install via:
        - **Mac:** `brew install allure`
        - **Windows:** `choco install allure`

---

## **Setup**
1. Clone the repository:
   ```bash
   git clone <https://github.com/fernando1496/playwright_challege_qa>
   ```
2. Navigate to the project directory:
   ```bash
   cd java_challege_qa
   ```
3. Ensure dependencies are downloaded:
   ```bash
   mvn clean install
   ```

---

## **How to Run the Tests**
### **Run All Tests**
To run all tests defined in the default suite (`all-tests-suite.xml`):
```bash
mvn test
```

### **Run Tests by Groups**
To run tests based on their groups (e.g., `positive` or `negative`):
1. Run `positive` tests:
   ```bash
   mvn test -Dgroups=positive
   ```
2. Run `negative` tests:
   ```bash
   mvn test -Dgroups=negative
   ```

### **Run Specific Suite**
To execute a specific TestNG suite file:
1. Run all tests suite:
   ```bash
   mvn test -Dsurefire.suiteXmlFiles=all-tests-suite.xml
   ```
2. Run positive tests suite:
   ```bash
   mvn test -Dsurefire.suiteXmlFiles=positive-tests-suite.xml
   ```
3. Run negative tests suite:
   ```bash
   mvn test -Dsurefire.suiteXmlFiles=negative-tests-suite.xml
   ```

---

## **Generate and View Allure Report**
1. Run tests to generate Allure results:
   ```bash
   mvn clean test
   ```
   Results will be stored in the `allure-results` directory.

2. Serve the Allure report:
   ```bash
   allure serve allure-results
   ```
   This will start a local server and open the report in your default browser.

3. Generate a static report:
   ```bash
   allure generate allure-results --clean -o allure-report
   allure open allure-report
   ```

---

## **Framework Configuration**
### **Dependencies**
The framework uses the following dependencies:
- **Selenium WebDriver**: For browser automation.
- **TestNG**: For test management and execution.
- **WebDriverManager**: For automatic driver management.
- **Allure TestNG Integration**: For detailed reporting.

Dependencies are managed in the `pom.xml` file.

### **Test Suites**
TestNG suite files are located in the root directory:
- `all-tests-suite.xml`: Includes all tests.
- `positive-tests-suite.xml`: Includes tests tagged as `positive`.
- `negative-tests-suite.xml`: Includes tests tagged as `negative`.

### **Plugins**
The `maven-surefire-plugin` is configured to run TestNG tests, and the `allure-maven-plugin` is configured to generate Allure reports.

---

## **Annotations and Groups**
- **Groups**:
    - Tests are categorized using TestNG groups (`positive` and `negative`) for selective execution.
- **Allure Annotations**:
    - `@Description`: Adds descriptions to test cases.
    - `@Step`: Captures step-by-step details for each test.

---

## **Troubleshooting**
1. **Tests Fail to Run with Allure Integration:**
    - Ensure Allure CLI is installed and accessible in your `PATH`.
    - Run `allure --version` to verify installation.

2. **Suite File Not Found:**
    - Check the location of the suite XML files. By default, they should be in the root folder.

3. **Maven Dependency Issues:**
    - Run:
      ```bash
      mvn clean install -U
      ```
    - Ensure the following repository is in the `pom.xml`:
      ```xml
      <repositories>
          <repository>
              <id>allure-repo</id>
              <url>https://maven.aliyun.com/nexus/content/repositories/central/</url>
          </repository>
      </repositories>
      ```

---

## **Author**
Fernando Maldonado
