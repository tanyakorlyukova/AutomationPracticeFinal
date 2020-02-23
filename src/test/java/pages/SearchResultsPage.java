package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {

    public SelenideElement pageHeading() {
        return $("h1.product-listing");
    }

    public ElementsCollection foundProducts() {
        return $$("li.ajax_block_product");
    }
}
