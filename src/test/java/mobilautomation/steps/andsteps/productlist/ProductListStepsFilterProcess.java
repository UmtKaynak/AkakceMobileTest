package mobilautomation.steps.andsteps.productlist;

import io.cucumber.datatable.DataTable;
import mobilautomation.steps.BaseSteps;

import java.util.Map;

import static mobilautomation.pages.andpages.productlist.ProductListPage.APPLY_FILTER_BUTTON;
import static mobilautomation.pages.andpages.productlist.ProductListPage.FILTER_BUTTON;

public class ProductListStepsFilterProcess extends BaseSteps {

    public void applyFilters(DataTable dataTable) {
        logger.info("Entered.");
        clickElement(FILTER_BUTTON);
        for (Map<String, String> data : dataTable.asMaps(String.class, String.class)) {
            if (data.containsKey("Sub_Catogrory") && !(data.get("Sub_Catogrory").equalsIgnoreCase("None")))
                filterByClicking(data.get("Sub_Catogrory"));
            if (data.containsKey("Brand") && !(data.get("Brand").equalsIgnoreCase("None")))
                filterByClicking(data.get("Brand"));
            if (data.containsKey("Features") && !(data.get("Features").equalsIgnoreCase("None")))
                filterByClicking(data.get("Features"));
            if (data.containsKey("Apply_Filter") && !(data.get("Apply_Filter").equalsIgnoreCase("None")))
                ifStatusBooleanClickElement(Boolean.parseBoolean(data.get("Apply_Filter").toLowerCase()), APPLY_FILTER_BUTTON);
        }
    }

    private void filterByClicking(String text) {
        logger.info("Entered. Parameters  text : " + text);
        clickElement(createXPathByText("//android.widget.TextView", text, ""));
    }
}
