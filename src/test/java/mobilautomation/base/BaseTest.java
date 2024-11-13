package mobilautomation.base;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.qameta.allure.Allure;
import mobilautomation.utils.LoggerManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;


public class BaseTest {

    public static AppiumDriver driver;
    public static LoggerManager logger;


    @BeforeAll
    public static void setup() {
        logger = new LoggerManager();
    }


    @Given("User is on the Akakçe mobile app on the {string}")
    public void setUpDriver(String driverName) {
        logger.info("Entered.");
        if (driverName.equalsIgnoreCase("android"))
            driver = Drivers.ANDROID.browserConfigureOptions();
        else if (driverName.equalsIgnoreCase("ios"))
            driver = Drivers.IOS.browserConfigureOptions();
        else
            Assertions.fail("Invalid Environment");
        logger.info("Environment selected as: " + driverName);

    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Error Screen", new ByteArrayInputStream(screenshot));
        }
    }


    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
