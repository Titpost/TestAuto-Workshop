package workshop;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;
import java.util.function.Function;

import static org.testng.Assert.assertEquals;

/**
 * Common utility base class for Selenium tests.
 */
public abstract class SeleniumBase {

    protected WebDriver driver;

    protected abstract Map<String, String> texts();

    /**
     * Fills the element with value from map by its id.
     *
     * @param key - id of Element
     */
    protected void fillElement(String key) {
        final WebElement element = driver.findElement(By.id(key));
        element.sendKeys(texts().get(key));
    }

    /**
     * Asserts if element's (within context) text equals to the value from map (by element's attribute value).
     *
     * @param value   - name of attribute to look for
     * @param finder  - corresponding "By" method
     * @param context to look in
     */
    protected void assertElementTextEquals(String value, Function<String, By> finder, SearchContext context) {
        final WebElement element = context.findElement(finder.apply(value));
        assertEquals(texts().get(value), element.getText());
    }

    /**
     * Asserts if element's (within driver-context) text equals to the value from map (by element's attribute value).11
     *
     * @param value  of attribute to look for
     * @param finder - corresponding "By"-method
     */
    protected void assertElementTextEquals(String value, Function<String, By> finder) {
        final WebElement element = driver.findElement(finder.apply(value));
        assertEquals(texts().get(value), element.getText());
    }

    /**
     * Clicks on element.
     *
     * @param value  of attribute to look for
     * @param finder - corresponding "By"-method
     */
    protected void clickOnElementWithAttribute(String value, Function<String, By> finder) {
        final WebElement element = driver.findElement(finder.apply(value));
        element.click();
    }

    /**
     * Asserts if page title equals to the passed value.
     *
     * @param value of title to compare to
     */
    protected void assertTitleEquals(String value) {
        assertEquals(driver.getTitle(), value);
    }

}
