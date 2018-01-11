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
     * Asserts if element text equals to value from map by its attribute.
     * @param by - attribute to find by
     * @param finder - corresponding "By" method
     */
    void assertElementText(SearchContext context, String by, Function<String, By> finder) {
        final WebElement element = context.findElement(finder.apply(by));
        Assert.assertEquals(texts.get(by), element.getText());
    }
}
