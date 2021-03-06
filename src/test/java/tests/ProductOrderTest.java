package tests;

import fixtures.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;

import static com.codeborne.selenide.Condition.text;

public class ProductOrderTest extends BaseTest {

    @BeforeEach
    public void logIn() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.logIn("testuser00001@email.com", "password");
        homePage.openCategoryWomenPage();
    }


    @Test
    @Description(value = "Check that registered user can order a product from Cart")
    @Severity(value = SeverityLevel.BLOCKER)
    public void orderProduct() {
        ProductBlock product = new ProductBlock();
        AddToCartPopup addToCartPopup = product.clickOnAddToCartButton("Faded Short Sleeve T-shirts");
        CartPage cartPage = addToCartPopup.proceedToCheckout();
        cartPage.proceedToCheckout();
        cartPage.proceedOnAddressStep();
        cartPage.agreeWithTerms();
        cartPage.proceedOnShippingStep();
        cartPage.selectPayByBankwireMethod();
        cartPage.confirmOrder();
        cartPage.successOrderText().shouldHave(text("Your order on My Store is complete."));
    }
}
