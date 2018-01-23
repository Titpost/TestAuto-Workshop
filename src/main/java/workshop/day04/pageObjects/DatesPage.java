package workshop.day04.pageObjects;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertEquals;

/**
 * Page Object for "Dates" page.
 */
public class DatesPage {

    @FindBy(css = ".uui-slider")
    private SelenideElement sliderTrack;

    @FindBy(css = ".ui-slider-handle:nth-of-type(1)")
    private SelenideElement leftSlider;

    @FindBy(css = ".ui-slider-handle:nth-of-type(2)")
    private SelenideElement rightSlider;

    /**
     * Factory method
     *
     * @return new page object instance
     */
    public static DatesPage getInstance() {
        return page(DatesPage.class);
    }

    /**
     * Put sliderTrack maximally aside
     */
    public void checkSlidersAside() {
        setSliderPosition(leftSlider, 0);
        setSliderPosition(rightSlider, 100);
    }

    /**
     * Put sliderTrack maximally to the left
     */
    public void checkSlidersLeft() {
        setSliderPosition(leftSlider, 0);
        setSliderPosition(rightSlider, 0);
    }

    /**
     * Put sliderTrack maximally to the right
     */
    public void checkSlidersRight() {
        setSliderPosition(rightSlider, 100);
        setSliderPosition(leftSlider, 100);
    }

    /**
     * Put the right slider to 70% and the left one to 30%
     */
    public void checkSliders30and70() {
        setSliderPosition(leftSlider, 30);
        setSliderPosition(rightSlider, 70);
    }


    private float getSliderStep() {
        return ((float) sliderTrack.getSize().width) / 100;
    }

    private int getCurrentPosition(SelenideElement slider) {
        return Integer.parseInt(slider.$("span").getText());
    }

    private void setSliderPosition(SelenideElement slider, int desired) {

        int current = getCurrentPosition(slider);

        if (desired != current) {
            final float step = getSliderStep();
            final float xOffset = (desired - current) * step;

            final Actions actions = new Actions(WebDriverRunner.getWebDriver());
            actions.dragAndDropBy(slider, Math.round(xOffset), 0).perform();

            if (getCurrentPosition(slider) != desired) {
                final int stepWithDelta = Math.round(step) + 1;
                actions.dragAndDropBy(slider, xOffset > 0 ? stepWithDelta : -stepWithDelta, 0)
                        .perform();
            }
        }

        assertEquals(getCurrentPosition(slider), desired);
    }
}