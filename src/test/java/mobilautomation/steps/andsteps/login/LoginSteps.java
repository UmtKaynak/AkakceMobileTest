package mobilautomation.steps.andsteps.login;

import mobilautomation.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;

import static mobilautomation.pages.andpages.home.HomePage.SEARCH_BOX;
import static mobilautomation.pages.andpages.login.LoginPage.*;

public class LoginSteps extends BaseSteps {

    public void continuesWithoutLogin() {
        logger.info("Entered");
        if (isDisplayed(CONTINUE_WITHOUT_LOGIN_BUTTON)) {
            clickElement(CONTINUE_WITHOUT_LOGIN_BUTTON);
        } else {
            logger.error("Element is not visible elementPath = " + CONTINUE_WITHOUT_LOGIN_BUTTON);
        }
    }

    public void continuesWithLogin(String userName, String password) {
        logger.info("Entered. Parameters  userName : " + userName + " password : " + password);
        sendKeys(USER_NAME_INPUT, userName);
        sendKeys(USER_PASSWORD_INPUT, password);
        clickElement(LOGIN_BUTTON);
    }
}
