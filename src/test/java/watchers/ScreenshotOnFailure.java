package watchers;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotOnFailure implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        try {
            makeScreenshotOnFailure(Screenshots.getLastScreenshot().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment("Screenshot on failure")
    public byte[] makeScreenshotOnFailure(String resourceName) throws IOException {
            return Files.readAllBytes(Paths.get("build/reports/tests", resourceName));
    }
}
