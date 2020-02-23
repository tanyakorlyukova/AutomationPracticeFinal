package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public SelenideElement loginPageHeading() {
        return $("h1.page-heading");
    }

    public void logIn(String email, String password) {
        $("input#email").setValue(email);
        $("input#passwd").setValue(password).pressEnter();
    }

    public SelenideElement userMenuItem() {
        return $("a.account");
    }
}
