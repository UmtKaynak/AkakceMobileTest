package mobilautomation.steps.andsteps.product;

import mobilautomation.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;

import static mobilautomation.pages.andpages.product.ProductPage.GO_TO_SELLER_BUTTON;

public class ProductPageSteps extends BaseSteps {

    public void userVerifyOnTheProductPage() {
        logger.info("Entered");
        Assertions.assertTrue(isDisplayed(GO_TO_SELLER_BUTTON));
    }
}
