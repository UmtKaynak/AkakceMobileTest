package mobilautomation.steps.andsteps.productlist;

import mobilautomation.steps.BaseSteps;

import static mobilautomation.pages.andpages.productlist.ProductListPage.*;

public class ProductListStepsSelectionProcess extends BaseSteps {


    /**
     *scrollByElementHeight() method requires the 3 parameter
     *  1- element seems scroolable on the inspector works for scroll process
     *  2- scroll method work for scroll during one element size to count by one by
     *  3- direction can enter:up/down
     *
     * selectSpecificProduct() scrolls by the height of given element, retrieves the element's title,
     * specifies which scroll step it is on, and tells which element it has seen.
     */

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
