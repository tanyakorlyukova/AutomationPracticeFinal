package tests;

import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SearchResultsPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;

public class SearchTest extends BaseTest {

    @Test
    public void productSearch() {
        HomePage homePage = new HomePage();
        SearchResultsPage searchResultsPage = homePage.search("dress");
        searchResultsPage.pageHeading().shouldHave(text("SEARCH  \"DRESS\""),
                        text("7 results have been found"));
        searchResultsPage.foundProducts().shouldHave(size(7));
    }
}
