package enums;

/**
 * @author Tit on 20.01.2018
 */
public enum SubMenuServices {
    SERVICE_SUPPORT("Support"),
    SERVICE_DATES("Dates"),
    SERVICE_COMPLEXTABLE("Complex Table"),
    SERVICE_SIMPLETABLE("Simple Table"),
    SERVICE_TABLEWITHWAGES("Table with pages"),
    SERVICE_DIFFERENTELEMENTS("Different elements");

    public String text;

    SubMenuServices(String text) {
        this.text = text;
    }
}
