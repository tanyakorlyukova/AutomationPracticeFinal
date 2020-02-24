package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    public SelenideElement cartPageHeading() {
        return $("h1#cart_title");
    }

    public ElementsCollection products() {
        return $$("table#cart_summary tbody tr");
    }

    public void deleteProduct() {
        $$("i.icon-trash").get(0).click();
    }

    //Order a Product

    public void proceedToCheckout() {
        $(".cart_navigation a.standard-checkout").click();
    }

    public void proceedOnAddressStep() {
        $(By.name("processAddress")).click();
    }

    public void agreeWithTerms() {
        $("input#cgv").click();
    }

    public void proceedOnShippingStep() {
        $(By.name("processCarrier")).click();
    }

    public void selectPayByBankwireMethod() {
        $("a.bankwire").click();
    }

    public void confirmOrder() {
        $(byText("I confirm my order")).click();
    }

    public SelenideElement successOrderText() {
        return $("p.cheque-indent");
    }
}
