package workshop.day04_05;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import workshop.day04_05.base.BaseSelenideTest;
import workshop.day04_05.listeners.AllureAttachmentListener;
import workshop.day04_05.pageObjects.DatesPage;

@Title("Page 'dates' test class")
@Description("Test class for slider's DnD")
@Listeners(AllureAttachmentListener.class)
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
