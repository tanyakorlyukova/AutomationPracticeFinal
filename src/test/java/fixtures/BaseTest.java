package fixtures;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import watchers.ScreenshotOnFailure;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;

@ExtendWith(ScreenshotOnFailure.class)
public class BaseTest {

    @BeforeAll
    public static void setup() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        //Configuration.browser = "chrome";
        Configuration.browserSize = "1980x1080";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "http://automationpractice.com";
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("/");
    }

    @AfterEach
    public void clearCookies() {
        clearBrowserCookies();
    }
}
