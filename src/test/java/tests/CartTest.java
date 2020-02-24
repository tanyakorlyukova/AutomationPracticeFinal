package tests;

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
    public void checkProductsInCart() {
        HomePage homePage = new HomePage();
        CartPage cartPage = homePage.openCart();
        cartPage.cartPageHeading().shouldHave(text("SHOPPING-CART SUMMARY"));
        cartPage.products().shouldHave(size(2));
    }

    @Test
    public void deleteProductFromCart() {
        HomePage homePage = new HomePage();
        CartPage cartPage = homePage.openCart();
        int currentSize = cartPage.products().size();
        cartPage.deleteProduct();
        cartPage.products().shouldHave(size(currentSize - 1));
    }
}
