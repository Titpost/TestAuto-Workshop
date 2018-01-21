package workshop.day04;


import com.codeborne.selenide.SelenideElement;
import enums.differentElementsPage.CheckBoxesEnum;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class DifferentElementsPage {

    public void checkElements() {

        // CheckBoxes with labels
        final SelenideElement checkboxRow = $(".checkbox-row");
        assertEquals(4, checkboxRow.$$("input[type='checkbox']").size());
        checkboxRow.$$(".label-checkbox").shouldHave(texts(Arrays.stream(CheckBoxesEnum.values())
                .map(e -> e.element)
                .collect(Collectors.toList())));
    }
}
