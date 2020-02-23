package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class ProductBlock {

    private SelenideElement findProduct(String productName) {
        return $$("div.product-container").find(text(productName));
    }

    public DetailedProductPage openDetailedPageForProduct(String productName) {
        findProduct(productName).click();
        return new DetailedProductPage();
    }

    public AddToCartPopup clickOnAddToCartButton(String productName) {
        findProduct(productName).hover();
        findProduct(productName).find("a.ajax_add_to_cart_button")
                .shouldBe(visible)
                .click();
        return new AddToCartPopup();
    }
}
