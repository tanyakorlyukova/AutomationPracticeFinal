package tests;

import fixtures.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.*;

public class LoginTest  extends BaseTest {

    @Test
    @Description(value = "Check that registered user can log in")
    @Severity(value = SeverityLevel.BLOCKER)
    public void correctLogin() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.loginPageHeading().shouldHave(text("AUTHENTICATION"));
        loginPage.logIn("testuser00001@email.com", "password");
        loginPage.userMenuItem().shouldHave(text("Test User"));
    }

    @Test
    @Description(value = "Check that logged in user can log out")
    @Severity(value = SeverityLevel.NORMAL)
    public void logout() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.openLoginPage();
        loginPage.logIn("testuser00001@email.com", "password");
        homePage.logout();
        loginPage.userMenuItem().should(not(exist))
                .shouldNotBe(visible);
        homePage.signInButton().should(exist)
                .shouldBe(visible);
    }
}
