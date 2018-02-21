package workshop.day08_jdi.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IComboBox;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import workshop.day08_jdi.sections.Summary;
import workshop.day08_jdi.sections.Vegetables;
import workshop.jdi_common.enums.ColorsEnum;
import workshop.jdi_common.enums.DigitsEnum;
import workshop.jdi_common.enums.ElementsEnum;
import workshop.jdi_common.enums.MetalsEnum;
import workshop.jdi_common.enums.VegetablesEnum;

import java.util.Arrays;

import static com.epam.web.matcher.junit.Assert.assertEquals;
import static enums.differentElementsPage.CheckboxLabelsEnum.CHECKBOXES_FIRE;
import static enums.differentElementsPage.CheckboxLabelsEnum.CHECKBOXES_WATER;
import static workshop.day08_jdi.JdiSite.results;
import static workshop.jdi_common.enums.ColorsEnum.Red;
import static workshop.jdi_common.enums.MetalsEnum.Selen;
import static workshop.jdi_common.enums.VegetablesEnum.Cucumber;
import static workshop.jdi_common.enums.VegetablesEnum.Tomato;

public class MetalsColorsPage extends WebPage {

    @Css("#summary-block")
    private Summary summary;

    @Css(".form-group.salad")
    private Vegetables vegetables;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option"))
    private IDropDown<ColorsEnum> colors;

    @FindBy(css = "#elements-checklist p")
    private ICheckList<ElementsEnum> elements;


    @FindBy(css = ".metals li span")
    private IComboBox<MetalsEnum> metals = new ComboBox<>(
            By.cssSelector(".metals .caret"),
            By.cssSelector(".metals li span"),
            By.cssSelector(".metals input")
    );

    @Css("#submit-button")
    private IButton submit;


    /**
     * Click on every radio-button with label from "digits"
     * @param digits - array of labels
     */
    public void selectSummary(DigitsEnum... digits) {
        Arrays.stream(digits)
                .forEach(digit ->
                    summary.select(String.valueOf(digit.ordinal())));
    }

    /**
     * Click on every checkbox with label from "ids"
     * @param ids - array of labels
     */
    public void selectElements(ElementsEnum... ids) {
        Arrays.stream(ids)
                .forEach(e -> elements.select(e));
    }

    /**
     * Select drop-down item (color) by its name
     * @param color by name
     */
    public void selectColor(ColorsEnum color) {
        colors.select(color);
    }

    /**
     * Select drop-down item (metal) by its name
     * @param metal by name
     */
    public void selectMetal(MetalsEnum metal) {
        metals.select(metal);
    }

    /**
     * Clear and select drop-down items
     * (vegetables) by its name
     * @param toSelect by names
     */
    public void selectNewVegetables(VegetablesEnum... toSelect) {
        vegetables.selectNew(toSelect);
    }

    /**
     * Submit
     */
    public void submit() {
        submit.click();
        checkResults();
    }

    /**
     * Check results section
     */
    // TODO take a look on Entity Driving testing, expected/actual object required...
    public void checkResults() {
        Arrays.stream(results.getFirstText().split("\n"))
                .map(l -> l.split(": "))
                .forEach(entry -> {
                    switch (entry[0]) {
                        case "Summary" :
                            assertEquals(entry[1], "11");
                            break;

                        case "Elements" :
                            assertEquals(entry[1], String.join(", ",
                                    CHECKBOXES_WATER.label, CHECKBOXES_FIRE.label));
                            break;

                        case "Color" :
                            assertEquals(entry[1], Red.name());
                            break;

                        case "Metal" :
                            assertEquals(entry[1], Selen.name());
                            break;

                        case "Vegetables" :
                            assertEquals(entry[1], String.join(", ",
                                    Cucumber.name(), Tomato.name()));
                    }
                });
    }
}
