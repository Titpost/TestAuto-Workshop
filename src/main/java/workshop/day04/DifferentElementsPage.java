package workshop.day04;


import com.codeborne.selenide.SelenideElement;
import enums.differentElementsPage.CheckboxLabelsEnum;
import enums.differentElementsPage.RadioLabelsEnum;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class DifferentElementsPage {

    public void checkElements() {

        // CheckBoxes with labels
        final SelenideElement checkboxRow = $(".checkbox-row", 0);
        assertEquals(4, checkboxRow.$$("input[type='checkbox']").size());
        checkboxRow.$$(".label-checkbox").shouldHave(texts(Arrays.stream(CheckboxLabelsEnum.values())
                .map(c -> c.label)
                .collect(Collectors.toList())));

        // RadioButtons with labels
        final SelenideElement radioRow = $(".checkbox-row", 1);
        assertEquals(4, radioRow.$$("input[type='radio']").size());
        radioRow.$$(".label-radio").shouldHave(texts(Arrays.stream(RadioLabelsEnum.values())
                .map(c -> c.label)
                .collect(Collectors.toList())));
    }
}
