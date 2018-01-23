package workshop.day04.pageObjects;


import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

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
        setSliderPosition(rightSlider, 70);
        setSliderPosition(leftSlider, 30);
    }

    /**
     * Get slider pace in pixels
     */
    private float getSliderStep() {
        float step = sliderTrack.getSize().width / 100;
        return step;
    }

    private int getCurrentPosition(SelenideElement slider) {

        int pos = Integer.parseInt(slider.$("span").getText());

        return pos;
    }

    private void setSliderPosition(SelenideElement slider, Integer position) {
        Float xOffset = (position - getCurrentPosition(slider)) * getSliderStep();
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.dragAndDropBy(slider, xOffset.intValue(), 0).perform();
    }
}