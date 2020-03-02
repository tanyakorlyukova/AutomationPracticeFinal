package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeEach
    public void setup() {
        Configuration.headless = true;
        Configuration.browserSize = "1980x1080";
        open("http://automationpractice.com");
    }

    @AfterEach
    public void clearCookies() {
        clearBrowserCookies();
    }
}
