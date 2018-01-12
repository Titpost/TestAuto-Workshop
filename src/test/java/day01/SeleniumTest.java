package day01;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.HashMap;
import java.util.function.Function;

/**
 * Common utility base class for Selenium tests.
 */
class SeleniumTest {

    WebDriver driver;

    HashMap<String, String> texts = new HashMap<>();

    /**
     * Fills the element with value from map by its id.
     * @param key - id of Element
     */
    void fillElement(String key) {
        final WebElement element = driver.findElement(By.id(key));
        element.sendKeys(texts.get(key));
    }

    /**
     * Asserts if element's (within context) text equals to the value from map (by element's attribute value).
     * @param value - name of attribute to look for
     * @param finder - corresponding "By" method
     * @param context to look in
     */
    void assertElementTextEquals(String value, Function<String, By> finder, SearchContext context) {
        final WebElement element = context.findElement(finder.apply(value));
        Assert.assertEquals(texts.get(value), element.getText());
    }

    /**
     * Asserts if element's (within driver-context) text equals to the value from map (by element's attribute value).
     * @param value of attribute to look for
     * @param finder - corresponding "By"-method
     */
    void assertElementTextEquals(String value, Function<String, By> finder) {
        final WebElement element = driver.findElement(finder.apply(value));
        Assert.assertEquals(texts.get(value), element.getText());
    }

    /**
     * Clicks on element.
     * @param value of attribute to look for
     * @param finder - corresponding "By"-method
     */
    void clickOnElementWithAttribute(String value, Function<String, By> finder) {
        final WebElement element = driver.findElement(finder.apply(value));
        element.click();
    }

    /**
     * Asserts if page title equals to the passed value.
     * @param value of title to compare to
     */
    void assertTitleEquals(String value) {
        Assert.assertEquals(driver.getTitle(), value);
    }

}
