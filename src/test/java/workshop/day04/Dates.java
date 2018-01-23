package workshop.day04;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import workshop.day04.pageObjects.DatesPage;
import workshop.day04.pageObjects.LoginPage;

import static com.codeborne.selenide.Selenide.close;

public class Dates {

    private LoginPage loginPage;
    private DatesPage datesPage;

    /**
     * Gets Object-Page instance.
     */
    @BeforeClass
    public void setUp() {
        // Open test site by URL
        loginPage = LoginPage.getInstance("https://jdi-framework.github.io/tests");

        // Perform login
        loginPage.login("epam", "1234");

        // Assert User name in the left-top side of screen that user is loggined
        loginPage.checkProfileName("Piter Chailovskii");
    }

    @AfterClass
    public void closeDown() {
        close();
    }

    /**
     * Dates page test
     */
    @Test
    public void datesPage() {

        // Open Service -> Dates
        loginPage.gotoDatesPage();
        datesPage = DatesPage.getInstance();

        // Using drag-and-drop set Range sliders.
        // left sliders - the most left position, right slider - the most rigth position
        datesPage.checkSlidersAside();

        // Using drag-and-drop set Range sliders.
        // left sliders - the most left position, right slider - the most left position.
        datesPage.checkSlidersLeft();

        // Using drag-and-drop set Range sliders.
        // left sliders - the most rigth position, right slider - the most rigth position.

        // Using drag-and-drop set Range sliders.
        datesPage.checkSliders30and70();
    }
}
