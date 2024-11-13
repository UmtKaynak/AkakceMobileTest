package mobilautomation.stepdefinitions.andstepdefinitions.login;

import io.cucumber.java.en.When;
import mobilautomation.steps.andsteps.login.LoginSteps;
import mobilautomation.utils.LoggerManager;


public class LoginStepDefinitions {
    LoginSteps loginSteps = new LoginSteps();
    LoggerManager logger = new LoggerManager();


    @When("User continues without login")
    public void userContinuesWithoutLogin() {
        logger.info("Entered.");
        loginSteps.continuesWithoutLogin();
    }

    @When("User login with {string} username and {string} password")
    public void userContinuesWithLogin(String userName, String password) {
        logger.info("Entered. Parameters  userName : " + userName + " password : " + password);
        loginSteps.continuesWithLogin(userName, password);
    }
}
