package workshop.day04.pageObjects;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class DatesPage {

    public void checkSlidersWork() {
        final SelenideElement sliders = $(".uui-slider");
        SelenideElement leftSlider = sliders.$(".ui-slider-handle", 0);
        do {
            leftSlider.sendKeys(Keys.ARROW_LEFT);
        }
        while (!leftSlider.getAttribute("style").contains(" 0%"));

        SelenideElement rightSlider = sliders.$(".ui-slider-handle", 1);
        do {
            rightSlider.sendKeys(Keys.ARROW_RIGHT);
        }
        while (!rightSlider.getAttribute("style").contains("100%"));
    }
}