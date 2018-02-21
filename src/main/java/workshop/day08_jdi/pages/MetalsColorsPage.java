package workshop.day08_jdi.pages;

import com.epam.jdi.uitests.core.interfaces.common.ILabel;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IComboBox;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Colors;
import org.openqa.selenium.support.FindBy;
import workshop.jdi_common.enums.ElementsEnum;
import workshop.jdi_common.enums.MetalsEnum;

import java.util.Arrays;

public class MetalsColorsPage extends WebPage {

    //@Name("Metals")
    //private Metalls metals;

    //@FindBy(id = "summary-block")
    //public Summary summary;

    @FindBy(id = "calculate-button")
    public Label calculate;

    @FindBy(id = "calculate-button")
    public Button calculateButton;

    @FindBy(id = "calculate-button")
    public ILabel calculateLabel;

    public IDropDown<Colors> colors = new Dropdown<>(
            By.cssSelector(".colors .filter-option"),
            By.cssSelector(".colors li span")
    );

    @FindBy(css = ".summ-res")
    public IText calculateText;

    @FindBy(css = "#elements-checklist p")
    public ICheckList<ElementsEnum> elements = new CheckList<>();

    @FindBy(css = ".metals li span")
    public IComboBox<MetalsEnum> metals = new ComboBox<>(
            By.cssSelector(".metals .caret"),
            By.cssSelector(".metals li span"),
            By.cssSelector(".metals input")
    );

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
     * Select drop-down item (metal) by its name
     * @param metal by name
     */
    public void selectMetal(MetalsEnum metal) {
        metals.select(metal);
    }
}
