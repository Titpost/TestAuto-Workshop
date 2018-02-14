package workshop;

import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import workshop.day07_jdi.site.EpamSite;

import java.io.IOException;

import static com.epam.jdi.uitests.core.logger.LogLevels.STEP;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static com.epam.jdi.uitests.web.selenium.driver.WebDriverUtils.killAllRunWebBrowsers;
import static com.epam.jdi.uitests.web.selenium.elements.composite.WebSite.init;


public abstract class TestBase extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        logger.setLogLevel(STEP);
        init(EpamSite.class);
        EpamSite.open();
        logger.info("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() throws IOException {
        killAllRunWebBrowsers();
    }
}

