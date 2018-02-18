package workshop.day07_jdi.pages;

import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import workshop.day07_jdi.sections.radioButon;

public class MetalsColors extends CommonPage  {

    @Css(".info-panel-section .radio")
    private Elements<radioButon> radios;

    public void selectRadios(String... ids) {
        radios.size();
    }
}
