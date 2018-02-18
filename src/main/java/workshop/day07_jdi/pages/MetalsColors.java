package workshop.day07_jdi.pages;

import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import workshop.day07_jdi.sections.radioButton;

import java.util.Arrays;

public class MetalsColors extends CommonPage  {

    @Css(".info-panel-section .radio")
    private Elements<radioButton> radios;

    /**
     * Click on every radio-button with label from "ids"
     * @param ids - array of labels
     */
    public void selectRadios(String... ids) {
        radios.stream()
                .filter(r -> Arrays.asList(ids).contains(r.label.getText()))
                .forEach(Element::clickCenter);
    }
}
