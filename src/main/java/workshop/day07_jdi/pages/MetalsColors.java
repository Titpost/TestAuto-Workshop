package workshop.day07_jdi.pages;

import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import workshop.day07_jdi.enums.ColorsEnum;
import workshop.day07_jdi.enums.MetalsEnum;
import workshop.day07_jdi.enums.VegetablesEnum;
import workshop.day07_jdi.sections.ElementsCheckbox;
import workshop.day07_jdi.sections.SummaryRadioButton;

import java.util.Arrays;

public class MetalsColors extends CommonPage  {

    @Css(".info-panel-section .radio")
    private Elements<SummaryRadioButton> radios;

    @Css(".info-panel-section .checkbox")
    private Elements<ElementsCheckbox> checkboxes;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option")
    )
    private IDropDown<ColorsEnum> colors;

    @JDropdown(
            jroot = @JFindBy(css = ".metals"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".caret")
    )
    private IDropDown<MetalsEnum> metals;

    @JDropdown(
            jroot = @JFindBy(css = "#salad-dropdown"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".caret")
    )
    private IDropDown<VegetablesEnum> vegetables;


    /**
     * Click on every radio-button with label from "ids"
     * @param ids - array of labels
     */
    public void selectRadios(String... ids) {
        radios.stream()
                .filter(r -> Arrays.asList(ids).contains(r.label.getText()))
                .forEach(Element::clickCenter);
    }

    /**
     * Click on every checkbox with label from "ids"
     * @param ids - array of labels
     */
    public void selectCheckboxes(String... ids) {
        checkboxes.stream()
                .filter(r -> Arrays.asList(ids).contains(r.label.getText()))
                .forEach(Element::clickCenter);
    }

    /**
     * Selects drop-down item (color) by its name
     * @param color by name
     */
    public void selectColor(ColorsEnum color) {
        colors.select(color);
    }

    /**
     * Selects drop-down item (metal) by its name
     * @param metal by name
     */
    public void selectMetal(MetalsEnum metal) {
        metals.select(metal);
    }

    /**
     * Selects drop-down items (vegetables) by its name
     * @param vegetables by names
     */
    public void selectVegetables(VegetablesEnum... vegetables) {
        Arrays.stream(vegetables)
                .forEach(v -> this.vegetables.select(v));
    }
}
