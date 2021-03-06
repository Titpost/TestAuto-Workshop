package workshop.day04_05.pageObjects;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertEquals;

/**
 * Page Object for "Dates" page.
 */
public class DatesPage {

    @FindBy(css = ".ui-slider-handle:nth-of-type(1)")
    private SelenideElement leftSlider;

    @FindBy(css = ".ui-slider-handle:nth-of-type(2)")
    private SelenideElement rightSlider;

    private Slider left;
    private Slider right;
    private void init() {
        left =  new Slider(leftSlider);
        right = new Slider(rightSlider);
    }

    /**
     * Factory method
     *
     * @return new page object instance
     */
    @Step
    public static DatesPage getInstance() {
        DatesPage datesPage = page(DatesPage.class);
        datesPage.init();
        return datesPage;
    }

    /**
     * Put sliderTrack maximally aside
     */
    @Step
    public void checkSlidersAside() {
        left.setSliderPosition(0);
        right.setSliderPosition(100);
    }

    /**
     * Put sliderTrack maximally to the left
     */
    @Step
    public void checkSlidersLeft() {
        left.setSliderPosition(0);
        right.setSliderPosition(0);
    }

    /**
     * Put sliderTrack maximally to the right
     */
    @Step
    public void checkSlidersRight() {
        right.setSliderPosition(100);
        left.setSliderPosition(100);
    }

    /**
     * Put the right slider to 70% and the left one to 30%
     */
    @Step
    public void checkSliders30and70() {
        left.setSliderPosition(30);
        right.setSliderPosition(70);
    }

    /**
     * Helper class for sliders maintaining.
     */
    private static class Slider {
        private SelenideElement slider;

        Slider (SelenideElement slider) {
            this.slider = slider;
        }

        private float getSliderStep() {
            return ((float) $(".uui-slider").getSize().width) / 100;
        }

        private int getCurrentPosition(SelenideElement slider) {
            return Integer.parseInt(slider.$("span").getText());
        }

        private void setSliderPosition(int desired) {

            final int current = getCurrentPosition(slider);

            if (desired != current) {
                final float step = getSliderStep();
                final float xOffset = (desired - current) * step;

                final Actions actions = new Actions(WebDriverRunner.getWebDriver());
                actions.dragAndDropBy(slider, Math.round(xOffset), 0)
                        .perform();

                if (getCurrentPosition(slider) != desired) {
                    final int delta = 1;
                    final int stepWithDelta = Math.round(step) + delta;
                    actions.dragAndDropBy(slider, xOffset > 0 ? stepWithDelta : -stepWithDelta, 0)
                            .perform();
                }
            }
            // Assertion for sliders values must be implemented by 1 unified method
            assertEquals(desired, getCurrentPosition(slider));
        }
    }
}