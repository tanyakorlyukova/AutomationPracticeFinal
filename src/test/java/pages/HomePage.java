package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public LoginPage openLoginPage() {
        $("a.login").click();
        return new LoginPage();
    }

    public SearchResultsPage search(String searchValue) {
        $("input#search_query_top").setValue(searchValue).pressEnter();
        return new SearchResultsPage();
    }

    public void logout() {
        $("a.logout").click();
    }

    public SelenideElement signInButton() {
        return $("a.login");
    }

    public CartPage openCart() {
        $("div.shopping_cart>a").click();
        return new CartPage();
    }

    public void openCategoryWomenPage() {
        $("a[title='Women']").click();
    }
}
