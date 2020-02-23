package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DetailedProductPage {

    public SelenideElement pageHeading() {
        return $("h1");
    }

    public SelenideElement productInfoBox() {
        return $(".box-info-product");
    }

    public ElementsCollection additionalInfoBlocks() {
        return $$("h3");
    }

    public void changeQuantity(String quantity) {
        SelenideElement quantityInput = $("input#quantity_wanted");
        quantityInput.clear();
        quantityInput.setValue(quantity);
    }

    public AddToCartPopup clickOnAddToCartButton() {
        $("#add_to_cart button").click();
        return new AddToCartPopup();
    }
}
