package workshop.day08_jdi.sections;

import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import workshop.jdi_common.enums.VegetablesEnum;

import java.util.List;


public class Vegetables extends Section {

    @FindBy(css = ".salad li label")
    private ICheckList<VegetablesEnum> salads;
    @JDropdown(
            jroot = @JFindBy(css = ".salad"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".caret"))
    private IDropDown<VegetablesEnum> vegetables;
    @Css(".salad a *:checked")
    private List<WebElement> checkedVegetables;

    private void expand() {
        vegetables.expand();
    }

    private void clear() {
        checkedVegetables.forEach(c -> c.findElement(By.xpath("..")).click());
    }

    public void select(List<String> toSelect) {
        toSelect.forEach(v -> salads.select(v));
    }

    public void selectNew(List<String> toSelect) {
        expand();
        clear();
        select(toSelect);
    }
}
