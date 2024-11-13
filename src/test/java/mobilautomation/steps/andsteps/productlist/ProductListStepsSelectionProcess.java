package mobilautomation.steps.andsteps.productlist;

import mobilautomation.steps.BaseSteps;

import static mobilautomation.pages.andpages.productlist.ProductListPage.*;

public class ProductListStepsSelectionProcess extends BaseSteps {

    public void selectSpecificProduct(int productOrder) {
        logger.info("Entered.");
        int count = 1;
        while (count < productOrder + 1) {
            logger.info(count + "th product name is " + findElements(PRODUCTS_NAME_OPTIONS).get(0).getText());
            scrollByElementHeight(findElement(PRODUCT_SCROLL_AREA), findElement(PRODUCTS_OPTIONS), "down");
            count++;
        }
        logger.info("Selected product is " + findElements(PRODUCTS_NAME_OPTIONS).get(1).getText());
        findElements(PRODUCTS_NAME_OPTIONS).get(1).click();
        clickElement(CONTINUE_PRODUCT_BUTTON);
    }
}
