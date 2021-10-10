package co.com.sofka.stepdefinition.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.python.antlr.ast.Str;

public class WebUI {

    protected WebDriver driver;

    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/driver/windows/chrome/chromedriver.exe";
    private static final String DEMO_QA_URL = "https://demoqa.com/automation-practice-form";

    protected void setUpWebdriver(){

        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);

    }
    protected void setuUpWebdriveUrl(){
        driver = new ChromeDriver();
        driver.get(DEMO_QA_URL);
    }

    protected void generalSetUp(){

        setUpWebdriver();
        setuUpWebdriveUrl();
    }

    protected void quitDriver(){

        driver.quit();
    }
}
