package mobilautomation.stepdefinitions.andstepdefinitions.home;

import io.cucumber.java.en.And;
import mobilautomation.steps.andsteps.home.HomePageSteps;
import mobilautomation.utils.LoggerManager;

public class HomePageStepDefinitions {

    HomePageSteps homePageSteps = new HomePageSteps();
    LoggerManager logger = new LoggerManager();


    @And("User searches {string}")
    public void userSearches(String searchData) {
        logger.info("Entered. Parameters  searchData : "+searchData);
        homePageSteps.searchProductOnSearchBox(searchData);
    }
}
