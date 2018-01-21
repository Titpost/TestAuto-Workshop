package workshop.day04;


import com.codeborne.selenide.SelenideElement;
import enums.differentElementsPage.CheckboxLabelsEnum;
import enums.differentElementsPage.RadioLabelsEnum;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class DifferentElementsPage {

    public void checkElements() {

        final SelenideElement mainContent = $(".main-content-hg");

        // CheckBoxes with labels
        final SelenideElement checkboxRow = mainContent.$(".checkbox-row", 0);
        assertEquals(4, checkboxRow.$$("input[type='checkbox']").size());
        checkboxRow.$$(".label-checkbox").shouldHave(texts(Arrays.stream(CheckboxLabelsEnum.values())
                .map(c -> c.label)
                .collect(Collectors.toList())));

        // RadioButtons with labels
        final SelenideElement radioRow = mainContent.$(".checkbox-row", 1);
        assertEquals(4, radioRow.$$("input[type='radio']").size());
        radioRow.$$(".label-radio").shouldHave(texts(Arrays.stream(RadioLabelsEnum.values())
                .map(c -> c.label)
                .collect(Collectors.toList())));

        // DropDown
        mainContent.$(".uui-form-element").should(exist);

        // Buttons
        mainContent.$("button.uui-button").should(exist);
        mainContent.$("input.uui-button").should(exist);
    }
}
