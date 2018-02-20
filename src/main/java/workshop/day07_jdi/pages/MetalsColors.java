package workshop.day07_jdi.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.complex.Elements;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import workshop.day07_jdi.enums.ColorsEnum;
import workshop.day07_jdi.enums.MetalsEnum;
import workshop.day07_jdi.enums.VegetablesEnum;
import workshop.day07_jdi.sections.ElementsCheckbox;
import workshop.day07_jdi.sections.SummaryRadioButton;

import java.util.Arrays;
import java.util.List;

import static com.epam.web.matcher.junit.Assert.assertContains;
import static enums.differentElementsPage.CheckboxLabelsEnum.CHECKBOXES_FIRE;
import static enums.differentElementsPage.CheckboxLabelsEnum.CHECKBOXES_WATER;
import static workshop.day07_jdi.JdiSite.results;
import static workshop.day07_jdi.enums.ColorsEnum.Red;
import static workshop.day07_jdi.enums.MetalsEnum.Selen;
import static workshop.day07_jdi.enums.VegetablesEnum.Cucumber;
import static workshop.day07_jdi.enums.VegetablesEnum.Tomato;

// TODO do you have a chance to format the code ?
// TODO this code does not match with convention...
public class MetalsColors extends CommonPage  {

    // TODO take a look on
    // TODO RadioButtons.class
    // TODO CheckList.class

    // TODO anyway, you create two exactly the same classes - SummaryRadioButton, ElementsCheckbox
    @Css(".info-panel-section .radio")
    private Elements<SummaryRadioButton> radios;

    @Css(".info-panel-section .checkbox")
    private Elements<ElementsCheckbox> checkboxes;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option"))
    private IDropDown<ColorsEnum> colors;

    @JDropdown(
            jroot = @JFindBy(css = ".metals"),
            jlist = @JFindBy(tagName = "li"),
            value = @FindBy(css = ".caret"))
    private IDropDown<MetalsEnum> metals;

    @JDropdown(
            jroot = @JFindBy(css = ".salad"),
            jlist = @JFindBy(tagName = "li"),
            value = @FindBy(css = ".caret"))
    private IDropDown <VegetablesEnum> vegetables;

    @Css(".salad a *:checked")
    private List<WebElement> checkedVegetables;

    @Css("#submit-button")
    private IButton submit;


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
    public void selectVegetables(VegetablesEnum... toSelect) {
        // TODO encapsulate this behavior in UI Element class...
        vegetables.expand();
        checkedVegetables.forEach(c -> c.findElement(By.xpath("..")).click());

        Arrays.stream(toSelect)
                .forEach(v -> vegetables.select(v));
        // !TODO
    }

    /**
     * Submit
     */
    public void submit() {
        submit.click();
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
                            assertContains(entry[1], "11");
                            break;

                        case "Elements" :
                            assertContains(entry[1], String.join(", ",
                                    CHECKBOXES_WATER.label, CHECKBOXES_FIRE.label));
                            break;

                        case "Color" :
                            assertContains(entry[1], Red.name());
                            break;

                        case "Metal" :
                            assertContains(entry[1], Selen.name());
                            break;

                        case "Vegetables" :
                            assertContains(entry[1], String.join(", ",
                                    Cucumber.name(), Tomato.name()));
                    }
                });
    }
}
