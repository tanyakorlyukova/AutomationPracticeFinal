package tests;

import fixtures.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AddToCartPopup;
import pages.CartPage;
import pages.HomePage;
import pages.ProductBlock;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;

public class CartTest extends BaseTest {

    @BeforeEach
    public void addProductsToCart() {
        ProductBlock product = new ProductBlock();
        AddToCartPopup addToCartPopup = product.clickOnAddToCartButton("Printed Chiffon Dress");
        addToCartPopup.continueShopping();
        product.clickOnAddToCartButton("Printed Summer Dress");
        addToCartPopup.continueShopping();
    }

    @Test
    @Description(value = "Check that number of products in Cart corresponds to number of added products")
    @Severity(value = SeverityLevel.CRITICAL)
    public void checkProductsInCart() {
        HomePage homePage = new HomePage();
        CartPage cartPage = homePage.openCart();
        cartPage.cartPageHeading().shouldHave(text("SHOPPING-CART SUMMARY!!!!!!!!!!!!!!!!"));
        cartPage.products().shouldHave(size(2));
    }

    @Test
    @Description(value = "Check that product can be deleted from Cart")
    @Severity(value = SeverityLevel.NORMAL)
    public void deleteProductFromCart() {
        HomePage homePage = new HomePage();
        CartPage cartPage = homePage.openCart();
        int currentSize = cartPage.products().size();
        cartPage.deleteProduct();
        cartPage.products().shouldHave(size(currentSize - 1));
    }
}
