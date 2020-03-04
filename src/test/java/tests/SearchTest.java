package tests;

import fixtures.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SearchResultsPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;

public class SearchTest extends BaseTest {

    @Test
    @Description(value = "Check that product search is performed correctly")
    @Severity(value = SeverityLevel.NORMAL)
    public void productSearch() {
        HomePage homePage = new HomePage();
        SearchResultsPage searchResultsPage = homePage.search("dress");
        searchResultsPage.pageHeading().shouldHave(text("SEARCH  \"DRESS\""),
                        text("7 results have been found"));
        searchResultsPage.foundProducts().shouldHave(size(7));
    }
}
