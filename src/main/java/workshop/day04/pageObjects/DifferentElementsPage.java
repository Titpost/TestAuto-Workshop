package workshop.day04.pageObjects;


import com.codeborne.selenide.SelenideElement;
import enums.differentElementsPage.CheckboxLabelsEnum;
import enums.differentElementsPage.RadioLabelsEnum;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static enums.differentElementsPage.CheckboxLabelsEnum.CHECKBOXES_WATER;
import static enums.differentElementsPage.CheckboxLabelsEnum.CHECKBOXES_WIND;
import static org.testng.Assert.assertEquals;


public class DifferentElementsPage {

    private final SelenideElement mainContent = $(".main-content-hg");
    private final SelenideElement checkboxRow = mainContent.$(".checkbox-row", 0);

    /**
     * Checks presence of the form elements.
     */
    public void checkElements() {

        // CheckBoxes with labels
        assertEquals(4, checkboxRow.$$("input[type='checkbox']").size());
        checkboxRow.$$(".label-checkbox").shouldHave(exactTexts(Arrays.stream(CheckboxLabelsEnum.values())
                .map(c -> c.label)
                .collect(Collectors.toList())));

        // RadioButtons with labels
        final SelenideElement radioRow = mainContent.$(".checkbox-row", 1);
        assertEquals(4, radioRow.$$("input[type='radio']").size());
        radioRow.$$(".label-radio").shouldHave(exactTexts(Arrays.stream(RadioLabelsEnum.values())
                .map(c -> c.label)
                .collect(Collectors.toList())));

        // DropDown
        mainContent.$(".uui-form-element").should(exist);

        // Buttons
        mainContent.$("button.uui-button").should(exist);
        mainContent.$("input.uui-button").should(exist);

        // Left and Right sections
        $(".sidebar-menu").should(exist);
        $(".mCSB_container").should(exist);
    }

    /**
     * Click 2 checkboxes and assert they got checked
     */
    public void checkCheckboxSelection() {
        checkboxRow.$$(".label-checkbox").stream()
                .filter(l -> l.getText().contains(CHECKBOXES_WATER.label) ||
                             l.getText().contains(CHECKBOXES_WIND.label))
                .forEach(l -> l.$("input").click());

        assertEquals(2, checkboxRow.$$("input:checked").size());
    }
}
