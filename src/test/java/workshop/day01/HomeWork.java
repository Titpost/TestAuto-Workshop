package workshop.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import workshop.SeleniumBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//6. Create a new test in a new Java class, specify test name in accordance with checking functionality
public class HomeWork extends SeleniumBase {

    private HashMap<String, String> texts = new HashMap<>();

    protected Map<String, String> texts() {
        return texts;
    }

    @BeforeTest
    void setTexts() {
        texts.put("Login", "epam");
        texts.put("Password", "1234");
        texts.put("span", "PITER CHAILOVSKII");
        texts.put("main-title", "EPAM FRAMEWORK WISHES…");

        texts.put("main-txt", "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR " +
                "INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION " +
                "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT " +
                "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        texts.put("benefit-txt0", "To include good practices and ideas from successful EPAM projec");

        texts.put("benefit-txt1", "To be flexible and customizable");

        texts.put("benefit-txt2", "To be multiplatform");

        texts.put("benefit-txt3", "Already have good base (about 20 internal and " +
                "some external projects), wish to get more…");
    }


    @BeforeClass
    void openBrowser() {
        //1. Browser - Chrome
        driver = new ChromeDriver();
        //2. Window - maximized
        driver.manage().window().maximize();
    }


    //3. All code should be formatted by functional blocks separated by functionality and meaning
    @BeforeMethod
    public void navigate() {
        //7. Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }

    @Test
    public void testFrameworkWithChrome() {

        final String pageTitle = "Index Page";

        //8. Assert Browser title
        assertTitleEquals(pageTitle);

        //9. Perform login
        clickOnElementWithAttribute("uui-profile-menu", By::className);
        fillElement("Login");
        fillElement("Password");
        clickOnElementWithAttribute("btn-login", By::className);

        //10. Assert User name in the left-top side of screen that user is logged in
        assertElementTextEquals("span",
                By::tagName,
                driver.findElement(By.className("profile-photo")));

        //11. Assert Browser title
        assertTitleEquals(pageTitle);

        //12. Assert that there are 4 images on the Home Page and they are displayed
        final int benefitsCount = 4;
        final List<WebElement> benefitImages = driver.findElements(By.className("benefit-icon"));
        assertEquals(benefitImages.size(), benefitsCount);
        for (WebElement img : benefitImages) {
            assertTrue(img.isDisplayed());
        }

        //13. Assert that there are 4 texts on the Home Page and check them by getting texts
        final List<WebElement> benefitTexts = driver.findElements(By.className("benefit-txt"));
        assertEquals(benefitTexts.size(), benefitsCount);
        for (byte i = 0; i < benefitsCount; i++) {
            assertTrue(benefitTexts.get(i).isDisplayed());
            assertEquals(
                    benefitTexts.get(i).getText().replaceAll("\\r\\n|\\r|\\n", " "),
                    texts.get("benefit-txt" + i)
            );
        }

        //14. Assert that there are the main header and the text below it on the Home Page
        assertElementTextEquals("main-title", By::className);
        assertElementTextEquals("main-txt", By::className);
    }

    @AfterClass
    void close() {
        //15. Close Browser
        driver.close();
    }
}

