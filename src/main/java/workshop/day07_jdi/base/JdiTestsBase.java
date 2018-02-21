package workshop.day07_jdi.base;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import workshop.day07_jdi.JdiSite;

import java.io.IOException;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.jdi.uitests.web.selenium.driver.WebDriverUtils.killAllRunWebBrowsers;

public class JdiTestsBase extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(JdiSite.class);
        logger.info("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() throws IOException {
        killAllRunWebBrowsers();
    }
}
