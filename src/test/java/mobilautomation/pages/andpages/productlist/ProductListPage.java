package mobilautomation.pages.andpages.productlist;

import org.openqa.selenium.By;

public class ProductListPage {

    public static final By FILTER_BUTTON = By.id("com.akakce.akakce:id/filterArea");
    public static final By APPLY_FILTER_BUTTON = By.id("com.akakce.akakce:id/applyFilterTextView");


    public static final By SORTING_BUTTON = By.id("com.akakce.akakce:id/sortArea");
    public static final By SORTING_BY_POPULARITY_BUTTON = By.xpath("//android.widget.TextView[@text='Popülerlik']/parent::android.widget.LinearLayout");
    public static final By SORTING_BY_CHEAP_BUTTON = By.xpath("//android.widget.TextView[@text='En Düşük Fiyat']/parent::android.widget.LinearLayout");
    public static final By SORTING_BY_EXPENSIVE_BUTTON = By.xpath("//android.widget.TextView[@text='En Yüksek Fiyat']/parent::android.widget.LinearLayout");
    public static final By SORTING_BY_HIGH_RATE_BUTTON = By.xpath("//android.widget.TextView[@text='En Yüksek Puan']/parent::android.widget.LinearLayout");
    public static final By SORTING_BY_NEWEST_BUTTON = By.xpath("//android.widget.TextView[@text='En Yeniler']/parent::android.widget.LinearLayout");


    public static final By PRODUCT_SCROLL_AREA = By.id("com.akakce.akakce:id/productRecycler");
    public static final By PRODUCTS_OPTIONS = By.id("com.akakce.akakce:id/card");
    public static final By PRODUCTS_NAME_OPTIONS = By.id("com.akakce.akakce:id/name");
    public static final By CONTINUE_PRODUCT_BUTTON = By.id("com.akakce.akakce:id/detailBtnLayout");


}
