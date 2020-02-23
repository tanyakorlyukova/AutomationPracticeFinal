package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AddToCartPopup {

    public SelenideElement addToCartPopup() {
        return $("#layer_cart .clearfix");
    }

    public SelenideElement successMessage() {
        return addToCartPopup().find(".layer_cart_product h2");
    }

    public SelenideElement productQuantity() {
        return $("#layer_cart_product_quantity");
    }

    public SelenideElement productTitle() {
        return $("#layer_cart_product_title");
    }

    public SelenideElement productPrice() {
        return $("#layer_cart_product_price");
    }
}
