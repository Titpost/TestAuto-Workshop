package workshop.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import workshop.SeleniumBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

//6. Create a new test in a new Java class, specify test name in accordance with checking functionality
public class Ex2ClassForSmokeAndRegression extends SeleniumBase {


    private HashMap<String, String> texts = new HashMap<>();

    protected Map<String, String> texts() {
        return texts;
    }

    @BeforeTest
    void setTexts() {
        texts.put("main-title", "EPAM FRAMEWORK WISHES…");
        texts.put("main-txt", "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR " +
                "INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION " +
                "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT " +
                "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    }


    @BeforeTest(groups = {"Smoke", "Regression"})
    void openBrowser() {
        //1. Browser - Chrome
        driver = new ChromeDriver();
    }

    @AfterTest(groups = {"Smoke", "Regression"})
    void close() {
        //15. Close Browser
        driver.close();
    }

    //3. All code should be formatted by functional blocks separated by functionality and meaning
    @BeforeClass(groups = {"Smoke", "Regression"})
    public void navigate() {
        //7. Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");
    }


    @Test(groups = {"Smoke", "Regression"})
    public void test1() {

        final String pageTitle = "Index Page";

        //8. Assert Browser title
        assertTitleEquals(pageTitle);
    }

    @Test(groups = {"Smoke", "Regression"})
    public void test2() {

        //12. Assert that there are 4 images on the Home Page...
        int benefitsCount = 4;
        final List<WebElement> benefitImages = driver.findElements(By.className("benefit-icon"));
        assertEquals(benefitImages.size(), benefitsCount);
    }

    @Test(groups = {"Smoke", "Regression"})
    public void test3() {
        // ...and they are displayed
        final List<WebElement> benefitImages = driver.findElements(By.className("benefit-icon"));
        for (WebElement img : benefitImages) {
            assertTrue(img.isDisplayed());
        }
    }
}

