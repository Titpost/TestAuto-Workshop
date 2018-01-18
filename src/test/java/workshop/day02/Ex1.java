package workshop.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.fail;

/**
 * @author Titov on 14.01.2018
 */
public class Ex1 {

    private WebDriver driver;

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
                {"icon-practise", "To include good practices and ideas from successful EPAM projec"},
                {"icon-custom", "To be flexible and customizable"},
                {"icon-multi", "To be multiplatform"},
                {"icon-base", "Already have good base (about 20 internal and some external projects), wish to get more…"}
        };
    }

    @Test(dataProvider = "db")
    public void testFrameworkWithChrome(String icon, String text) {

        // find all the benefits
        List<WebElement> benefits = driver.findElements(By.className("benefit")).stream()
                .filter((b) -> containsIcon(icon, b))
                .collect(Collectors.toList());

        // benefit for this icon must present
        if (null == benefits.get(0)) {
            fail("benefit icon is missing: " + icon);
        }

        // assert text for the this icon
        WebElement elementText = benefits.get(0).findElement(By.className("benefit-txt"));
        Assert.assertEquals(
                elementText.getText().replaceAll("\\r\\n|\\r|\\n", " "),
                text
        );
    }

    /**
     * Predicate to check is element presents in another element.
     *
     * @param icon    - name of element class to be contained
     * @param context - parent element
     * @return - true if contained
     */
    private boolean containsIcon(String icon, WebElement context) {
        try {
            context.findElement(By.className(icon));
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
