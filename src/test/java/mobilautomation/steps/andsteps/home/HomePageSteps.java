package mobilautomation.steps.andsteps.home;

import mobilautomation.steps.BaseSteps;

import static mobilautomation.pages.andpages.home.HomePage.SEARCH_BOX;

public class HomePageSteps extends BaseSteps {


    public void searchProductOnSearchBox(String searchData) {
        logger.info("Entered. searchData : " + searchData);
        clickElement(SEARCH_BOX);
        waitByMilliSeconds(500);
        forcedSendKeys(SEARCH_BOX, searchData);
        sendEnter();
    }
}
