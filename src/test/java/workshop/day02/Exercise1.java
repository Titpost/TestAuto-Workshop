package workshop.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import workshop.SeleniumTest;

import java.util.List;
import java.util.Optional;

import static org.testng.AssertJUnit.fail;

/**
 * @author Titov on 14.01.2018
 */
public class Exercise1 extends SeleniumTest {

    @BeforeClass
    void openBrowser() {
        // Browser - Chrome
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void navigate() {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    @AfterClass
    void close() {
        // Close Browser
        driver.close();
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
                        (b) -> b.findElement(By.className(icon)) != null)
                .findFirst();

        // benefit for this icon must present
        if (!benefit.isPresent()) {
            fail("benefit icon is missing: " + icon);
        }

        // assert text for the this icon
        WebElement elementText = benefit.get().findElement(By.className(text));
        Assert.assertEquals(
                elementText.getText(),
                text
        );
    }
}
