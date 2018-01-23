package workshop.day04;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import workshop.day04.base.BaseSelenideTest;
import workshop.day04.pageObjects.DatesPage;

public class Dates extends BaseSelenideTest {

    private DatesPage datesPage;

    @BeforeClass
    public void setUp() {
        super.setUp();
    }

    @AfterClass
    public void closeDown() {
        super.closeDown();
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
        // left sliders - the most left position, right slider - the most right position
        datesPage.checkSlidersAside();

        // Using drag-and-drop set Range sliders.
        // left sliders - the most left position, right slider - the most left position
        datesPage.checkSlidersLeft();

        // Using drag-and-drop set Range sliders.
        // left sliders - the most right position, right slider - the most right position
        datesPage.checkSlidersRight();

        // Using drag-and-drop set Range sliders.
        datesPage.checkSliders30and70();
    }
}
