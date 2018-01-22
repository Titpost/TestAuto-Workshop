package workshop.day04.pageObjects;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static org.openqa.selenium.Keys.ARROW_LEFT;
import static org.openqa.selenium.Keys.ARROW_RIGHT;

public class DatesPage {

    private final SelenideElement sliders = $(".uui-slider");
    private final SelenideElement leftSlider = sliders.$(".ui-slider-handle", 0);
    private final SelenideElement rightSlider = sliders.$(".ui-slider-handle", 1);

    /**
     * Factory method
     *
     * @return new page object instance
     */
    public static DatesPage getInstance() {
        return page(DatesPage.class);
    }

    /**
     * Put sliders maximally aside
     */
    public void checkSlidersAside() {
        slideLeft(leftSlider, " 0%");
        slideRight(rightSlider, "100%");
    }

    /**
     * Put sliders maximally to the left
     */
    public void checkSlidersLeft() {
        slideLeft(leftSlider, " 0%");
        slideLeft(rightSlider, " 0%");
    }

    /**
     * Put the right slider to 70% and the left one to 30%
     */
    public void checkSliders30and70() {
        slideRight(rightSlider, "70%");
        slideRight(leftSlider, "30%");
    }

    /**
     * Slide a slider to the left
     *
     * @param slider   - element to slide
     * @param position - string like " 0%"
     */
    private void slideLeft(SelenideElement slider, String position) {
        slide(slider, ARROW_LEFT, position);
    }

    /**
     * Slide a slider to the right
     *
     * @param slider   - element to slide
     * @param position - string like "100%"
     */
    private void slideRight(SelenideElement slider, String position) {
        slide(slider, ARROW_RIGHT, position);
    }

    /**
     * Slide a slider to the specified position
     *
     * @param slider   - element to slide
     * @param key      - enum Keys like ARROW_LEFT or ARROW_RIGHT
     * @param position - string like " n%"
     */
    private void slide(SelenideElement slider, Keys key, String position) {
        do {
            slider.sendKeys(key);
        }
        while (!slider.getAttribute("style").contains(position));
    }
}