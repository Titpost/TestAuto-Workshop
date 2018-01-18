package workshop.day04;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelenideTest {

    private SelenidePage selenidePage;

    /**
     * Gets Object-Page instance.
     */
    @BeforeClass
    public void setUp() {
        selenidePage = SelenidePage.getInstance();
    }

    @Test
    public void login() {
        selenidePage.openPage("https://jdi-framework.github.io/tests");

        selenidePage.login("epam", "1234");

        selenidePage.checkProfileName("Piter Chailovskii");

        selenidePage.checkIconWithText(".icon-practise",
                "To include good practices and ideas from successful EPAM projec");
    }
}
