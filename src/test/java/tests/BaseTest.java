package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeEach
    public void setup() {
        Configuration.startMaximized=true;
        open("http://automationpractice.com");
    }
}
