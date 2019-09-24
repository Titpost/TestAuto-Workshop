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
import workshop.day08_jdi.dataprovider.Pojo;
import workshop.day08_jdi.sections.Summary;
import workshop.day08_jdi.sections.Vegetables;
import workshop.jdi_common.enums.ColorsEnum;
import workshop.jdi_common.enums.ElementsEnum;
import workshop.jdi_common.enums.MetalsEnum;

import java.util.Arrays;
import java.util.List;

import static com.epam.web.matcher.junit.Assert.assertEquals;
import static java.util.stream.Collectors.joining;
import static workshop.day08_jdi.JdiSite.results;
import static workshop.jdi_common.utils.Strings.isEmpty;

public class MetalsColorsPage extends WebPage {

    private final static int result_key = 0;
    private final static int result_value = 1;

    @Css("#summary-block")
    private Summary summary;

    @Css(".form-group.salad")
    private Vegetables vegetables;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option"))
    private IDropDown<ColorsEnum> colors;

    @Css("#elements-checklist p")
    private ICheckList<ElementsEnum> elements;


    @Css(".metals li span")
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
    public void selectSummary(List<Integer> digits) {
        digits.forEach(digit -> summary.select(String.valueOf(digit)));
    }

    /**
     * Click on every checkbox with label from "ids"
     * @param ids - array of labels
     */
    public void selectElements(List<String> ids) {
        ids.forEach(e -> elements.select(e));
    }

    /**
     * Select drop-down item (color) by its name
     * @param color by name
     */
    public void selectColor(String color) {
        if (isEmpty(color)) {
            return;
        }
        colors.select(color);
    }

    /**
     * Select drop-down item (metal) by its name
     * @param metal by name
     */
    public void selectMetal(String metal) {
        if (isEmpty(metal)) {
            return;
        }
        metals.select(metal);
    }

    /**
     * Clear and select drop-down items
     * (vegetables) by its name
     * @param toSelect by names
     */
    public void selectNewVegetables(List<String> toSelect) {
        vegetables.selectNew(toSelect);
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
    public void checkResults(Pojo pogo) {
        Arrays.stream(results.getFirstText().split("\n"))
                .map(l -> l.split(": "))
                .forEach(entry -> {
                    switch (entry[result_key]) {
                        case "Summary" :
                            // there were no summary-check supplied within JSON file
                            //assertEquals(entry[1], "11");
                            break;
                        case "Elements" :
                            assertEquals(
                                    entry[result_value],
                                    pogo.elements.stream().collect(joining(", "))
                            );
                            break;
                        case "Color" :
                            if (!isEmpty(pogo.color)) {
                                assertEquals(entry[result_value], pogo.color);
                            }
                            break;
                        case "Metal" :
                            if (!isEmpty(pogo.metals)) {
                                assertEquals(entry[result_value], pogo.metals);
                            }
                            break;
                        case "Vegetables" :
                            assertEquals(
                                    entry[result_value],
                                    pogo.vegetables.stream().collect(joining(", "))
                            );
                    }
                });
    }
}
