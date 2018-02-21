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
import workshop.jdi_common.enums.*;

import java.util.Arrays;

public class MetalsColorsPage extends WebPage {

   /* @FindBy(css = ".summ-res")
    public IText calculateText;

    @FindBy(id = "calculate-button")
    public Label calculate;

    @FindBy(id = "calculate-button")
    public Button calculateButton;

    @FindBy(id = "calculate-button")
    public ILabel calculateLabel;*/

    @FindBy(id = "summary-block")
    public Summary summary;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option"))
    private IDropDown<ColorsEnum> colors;

    @FindBy(css = "#elements-checklist p")
    public ICheckList<ElementsEnum> elements;

    @FindBy(css = ".salad li label")
    public ICheckList<ElementsEnum> salads;
    @JDropdown(
            jroot = @JFindBy(css = ".salad"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".caret"))
    private IDropDown <VegetablesEnum> vegetables;

    @FindBy(css = ".metals li span")
    public IComboBox<MetalsEnum> metals = new ComboBox<>(
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
        elements.clear();
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
    public void selectVegetables(VegetablesEnum... toSelect) {
        // TODO encapsulate this behavior in UI Element class...
        vegetables.expand();
        salads.clear();
        //.forEach(c -> c.findElement(By.xpath("..")).click());

        Arrays.stream(toSelect)
                .forEach(v -> vegetables.select(v));
        // !TODO
    }

    /**
     * Submit
     */
    public void submit() {
        submit.click();
        //checkResults();
    }
}
