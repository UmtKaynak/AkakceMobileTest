package mobilautomation.stepdefinitions.andstepdefinitions.product;

import io.cucumber.java.en.Then;
import mobilautomation.steps.andsteps.product.ProductPageSteps;
import mobilautomation.utils.LoggerManager;

public class ProductPageStepDefinitions {

    ProductPageSteps productPageSteps = new ProductPageSteps();
    LoggerManager logger = new LoggerManager();


    @Then("User should see the Satıcıya Git button on the product page")
    public void userShouldSeeTheButtonOnTheProductPage() {
        logger.info("Entered.");
        productPageSteps.userVerifyOnTheProductPage();
    }
}
