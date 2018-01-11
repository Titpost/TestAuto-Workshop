package day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

//6. Create a new test in a new Java class, specify test name in accordance with checking functionality
public class HomeWork extends SeleniumTest {

    @BeforeTest
    void setTexts () {
        texts.put("Login", "epam");
        texts.put("Password", "1234");
        texts.put("span", "PITER CHAILOVSKII");
        texts.put("main-title", "EPAM FRAMEWORK WISHES…");

        texts.put("main-txt", "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR " +
                "INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION " +
                "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT " +
                "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        texts.put("benefit-txt0", "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM projec");

        texts.put("benefit-txt1", "To be flexible and\n" +
                "customizable");

        texts.put("benefit-txt2", "To be multiplatform");

        texts.put("benefit-txt3", "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
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

        //8. Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");

        //9. Perform login
        final WebElement elementToggle = driver.findElement(By.className("uui-profile-menu"));
        elementToggle.click();
        fillElement("Login");
        fillElement("Password");
        final WebElement elementSubmit = driver.findElement(By.className("btn-login"));
        elementSubmit.click();

        //10. Assert User name in the left-top side of screen that user is logged in
        final WebElement elementPhoto = driver.findElement(By.className("profile-photo"));
        assertElementText(elementPhoto,"span", By::tagName);

        //11. Assert Browser title
        Assert.assertEquals(driver.getTitle(), "Index Page");

        //12. Assert that there are 4 images on the Home Page and they are displayed
        int benefitsCount = 4;
        final List<WebElement> benefitImages = driver.findElements(By.className("benefit-icon"));
        Assert.assertEquals(benefitImages.size(), benefitsCount);
        for (WebElement img : benefitImages) {
            Assert.assertTrue(img.isDisplayed());
        }

        //13. Assert that there are 4 texts on the Home Page and check them by getting texts
        final List<WebElement> benefitTexts = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(benefitTexts.size(), benefitsCount);
        for (byte i = 0; i < benefitsCount; i++) {
            Assert.assertTrue( benefitTexts.get(i).isDisplayed());
            Assert.assertEquals(
                    benefitTexts.get(i).getText(),
                    texts.get("benefit-txt" + i)
            );
        }

        //14. Assert that there are the main header and the text below it on the Home Page
        assertElementText(driver,"main-title", By::className);
        assertElementText(driver,"main-txt", By::className);
    }

    @AfterClass
    void close() {
        //15. Close Browser
        driver.close();
    }
}

