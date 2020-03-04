package tests;

import fixtures.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import pages.DetailedProductPage;
import pages.ProductBlock;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class ViewDetailedInfoTest extends BaseTest {

    @Test
    @Description(value = "Check that Detailed Info page contains correct information about product")
    @Severity(value = SeverityLevel.NORMAL)
    public void viewDetailedInfo() {
        ProductBlock product = new ProductBlock();
        DetailedProductPage detailedPage = product.openDetailedPageForProduct("Blouse");
        detailedPage.pageHeading().shouldHave(text("Blouse"));
        detailedPage.productInfoBox().shouldBe(visible);
        detailedPage.additionalInfoBlocks().get(0).shouldHave(text("DATA SHEET"));
        detailedPage.additionalInfoBlocks().get(1).shouldHave(text("MORE INFO"));
        detailedPage.additionalInfoBlocks().get(2).shouldHave(text("REVIEWS"));
    }
}
