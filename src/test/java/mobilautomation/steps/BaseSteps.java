package mobilautomation.steps;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import mobilautomation.base.BaseTest;
import mobilautomation.utils.LoggerManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class BaseSteps {

    protected AppiumDriver appiumDriver;
    protected WebDriverWait wait;
    protected LoggerManager logger;

    public BaseSteps() {
        this.appiumDriver = BaseTest.driver;
        this.logger = BaseTest.logger;
    }


    public WebElement findElement(By by) {
        wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by) {
        return appiumDriver.findElements(by);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void clickElement(By by) {
        clickElement(findElement(by));
    }

    public void sendKeys(WebElement element, String text) {
        logger.info("Entered.");
        element.sendKeys(text);
        logger.info("Sended text is " + text);
    }

    public void sendKeys(By by, String text) {
        logger.info("Entered.");
        findElement(by).clear();
        sendKeys(findElement(by), text);
    }

    public void forcedSendKeys(By by, String text) {
        logger.info("Entered.");
        Actions actions = new Actions(appiumDriver);
        actions.sendKeys(findElement(by), text).perform();
        logger.info("Sended text is :'" + text + "'");
    }

    public boolean isDisplayed(By by) {
        logger.info("Entered.");
        try {
            logger.info(by + " Element is visible on the current page");
            findElement(by);
            return true;
        } catch (TimeoutException e) {
            logger.error("Element is not visible");
            return false;
        }
    }

    public void sendEnter() {
        logger.info("Entered.");
        Actions actions = new Actions(appiumDriver);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void sendEsc() {
        logger.info("Entered.");
        Actions actions = new Actions(appiumDriver);
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public By createXPathByText(String startWith, String text, String endWith) {
        logger.info("Entered.");
        By elementPath;
        if (startWith == null && endWith == null) {
            elementPath = By.xpath("//*[@text='" + text + "']");
        } else if (startWith == null) {
            elementPath = By.xpath("//*[@text='" + text + "']" + endWith);
        } else if (endWith == null) {
            elementPath = By.xpath(startWith + "[@text='" + text + "']");
        } else {
            elementPath = By.xpath(startWith + "[@text='" + text + "']" + endWith);
        }
        logger.info("Created xpath is : " + elementPath);
        return elementPath;
    }

    public void ifStatusBooleanClickElement(boolean condition, By by) {
        logger.info("Entered.");
        if (condition)
            clickElement(by);
        else
            logger.error("Not clicked " + by + " because condition is false");
    }

    public void waitByMilliSeconds(int milliseconds) {
        logger.info("Entered.");
        try {
            Thread.sleep(milliseconds);
            logger.info("Driver is waiting during " + milliseconds + " ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollByElementHeight(WebElement scrollArea, WebElement firstElement, String direction) {
        logger.info("Entered. Page is scroling " + direction);
        Rectangle rectangle = scrollArea.getRect();
        int fromY = rectangle.getY();
        int fromX = rectangle.getX();
        int toY = 0;

        int height = firstElement.getSize().getHeight();
        if (direction.equals("down")) {
            toY = fromY + height;
        } else if (direction.equals("up")) {
            toY = fromY - height;
        }

        appiumDriver.executeScript("mobile: scrollGesture", Map.of(
                "left", fromX,
                "top", fromY,
                "width", 0,
                "height", toY,
                "direction", direction,
                "speed", 500,
                "percent", 1
        ));
    }

}


