package workshop.day04.pageObjects;

/**
 * Base class for Page Objects classes.
 */
public class BasePage {

    protected Header header;

    /**
     * Clicks on menu dropdown-toggle to expand
     */
    void expandServicesMenu() {
        header.elementDropdown.$(".dropdown-toggle").click();
    }
}
