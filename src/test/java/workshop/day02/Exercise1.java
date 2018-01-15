package workshop.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import workshop.SeleniumTest;

import java.util.List;
import java.util.Optional;

import static org.testng.AssertJUnit.fail;

/**
 * @author Titov on 14.01.2018
 */
public class Exercise1 extends SeleniumTest {

    @BeforeTest
    void openBrowser() {
        // Browser - Chrome
        driver = new ChromeDriver();
    }

    @AfterTest
    void close() {
        // Close Browser
        driver.close();
    }

    @BeforeClass
    public void navigate() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    @DataProvider
    private Object[][] db() {
        return new Object[][]{
                {"icon-practise", "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM projec"},
                {"icon-custom", "To be flexible and\ncustomizable"},
                {"icon-multi", "To be multiplatform"},
                {"icon-base", "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"}
        };
    }

    @Test(dataProvider = "db")
    public void testFrameworkWithChrome(String icon, String text) {

        // find all the benefits
        final List<WebElement> benefits = driver.findElements(By.className("benefit"));

        // find a benefit with the specified icon
        Optional<WebElement> benefit = benefits.stream()
                .filter(
                        (b) -> containsIcon(icon, b))
                .findFirst();

        // benefit for this icon must present
        if (!benefit.isPresent()) {
            fail("benefit icon is missing: " + icon);
        }

        // assert text for the this icon
        WebElement elementText = benefit.get().findElement(By.className("benefit-txt"));
        String str = elementText.getText();
        Assert.assertEquals(
                elementText.getText(),
                text
        );
    }

    private boolean containsIcon(String icon, WebElement context) {
        try {
            context.findElement(By.className(icon));
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
