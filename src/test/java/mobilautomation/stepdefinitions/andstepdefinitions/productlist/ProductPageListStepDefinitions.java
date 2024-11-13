package mobilautomation.stepdefinitions.andstepdefinitions.productlist;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import mobilautomation.steps.andsteps.productlist.ProductListPageOrderProcess;
import mobilautomation.steps.andsteps.productlist.ProductListStepsFilterProcess;
import mobilautomation.steps.andsteps.productlist.ProductListStepsSelectionProcess;
import mobilautomation.utils.LoggerManager;

public class ProductPageListStepDefinitions {

    ProductListStepsFilterProcess filterProcess = new ProductListStepsFilterProcess();
    ProductListPageOrderProcess orderProcess = new ProductListPageOrderProcess();
    ProductListStepsSelectionProcess selectionProcess = new ProductListStepsSelectionProcess();
    LoggerManager logger = new LoggerManager();

    @When("User applies filters on product list")
    public void userAppliesFiltersOnProductList(DataTable dataTable) {
        logger.info("Entered. Parameters  dataTable : " + dataTable);
        filterProcess.applyFilters(dataTable);
    }

    @When("User orders by products starting {string}")
    public void userOrdersByProductsStarting(String orderingType) {
        logger.info("Entered. Parameters  orderingType : " + orderingType);
        orderProcess.orderProducts(orderingType);
    }

    @And("User selects the {int}  product")
    public void userSelectsTheProduct(int productOrder) {
        logger.info("Entered. Parameters  productOrder : " + productOrder);
        selectionProcess.selectSpecificProduct(productOrder);
    }
}
