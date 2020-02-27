package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import pages.AddToCartPopup;
import pages.DetailedProductPage;
import pages.ProductBlock;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class AddToCartTest extends BaseTest {

    @Test
    @Description(value = "Check that product can be added to Cart from Homepage")
    @Severity(value = SeverityLevel.CRITICAL)
    public void addToCartFromHomepage() {
        ProductBlock product = new ProductBlock();
        AddToCartPopup addToCartPopup = product.clickOnAddToCartButton("Printed Dress");
        addToCartPopup.addToCartPopup().shouldBe(visible);
        addToCartPopup.successMessage().shouldHave(text("Product successfully added to your shopping cart"));
        addToCartPopup.productQuantity().shouldHave(exactText("1"));
        addToCartPopup.productTitle().shouldHave(text("Printed Dress"));
        addToCartPopup.productPrice().shouldHave(text("$26.00"));
    }

    @Test
    @Description(value = "Check that product can be added to Cart from Detailed Product Info page")
    @Severity(value = SeverityLevel.CRITICAL)
    public void addToCartFromDetailedInfoPage() {
        ProductBlock product = new ProductBlock();
        DetailedProductPage detailedPage = product.openDetailedPageForProduct("Blouse");
        detailedPage.changeQuantity("5");
        AddToCartPopup addToCartPopup = detailedPage.clickOnAddToCartButton();
        addToCartPopup.addToCartPopup().shouldBe(visible);
        addToCartPopup.successMessage().shouldHave(text("Product successfully added to your shopping cart"));
        addToCartPopup.productQuantity().shouldHave(exactText("5"));
        addToCartPopup.productPrice().shouldHave(text("$" + 27*5 + ".00"));
    }
}
