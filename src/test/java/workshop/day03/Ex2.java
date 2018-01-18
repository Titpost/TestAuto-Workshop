package workshop.day03;

import enums.IndexPageTextsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


//6. Create a new test in a new Java class, specify test name in accordance with checking functionality
public class Ex2 {

    private LoginPage loginPage;

    @BeforeClass
    void openBrowser() {
        //1. Browser - Chrome
        WebDriver driver = new ChromeDriver();
        //2. Window - maximized
        driver.manage().window().maximize();

        loginPage = LoginPage.getInstance(driver);
    }

    //3. All code should be formatted by functional blocks separated by functionality and meaning
    @BeforeMethod
    public void navigate() {
        //7. Open test site by URL
        loginPage.openPage("https://jdi-framework.github.io/tests");
    }

    @Test
    public void loginPage() {

        final String pageTitle = "Index Page";

        //8. Assert Browser title
        loginPage.checkTitleEquals(pageTitle);

        //9. Perform login
        loginPage.login("epam", "1234");

        //10. Assert User name in the left-top side of screen that user is logged in
        loginPage.checkLoggedAs("PITER CHAILOVSKII");

        //11. Assert Browser title
        loginPage.checkTitleEquals(pageTitle);

        //12. Assert that there are 4 images on the Home Page and they are displayed
        loginPage.checkImagesAreDisplayed();

        //13. Assert that there are 4 texts on the Home Page and check them by getting texts
        loginPage.checkTextsUnderImages(IndexPageTextsEnum.values());

        //14. Assert that there are the main header and the text below it on the Home Page
        loginPage.checkMainTitle("EPAM FRAMEWORK WISHES…");
        loginPage.checkMainText("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR " +
                "INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION " +
                "ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT " +
                "IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    }

    @AfterClass
    void close() {
        //15. Close Browser
        loginPage.close();
    }
}

