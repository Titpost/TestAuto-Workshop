package enums.loginPage;


public enum SubMenuServicesEnum {
    SERVICE_SUPPORT("Support"),
    SERVICE_DATES("Dates"),
    SERVICE_COMPLEXTABLE("Complex Table"),
    SERVICE_SIMPLETABLE("Simple Table"),
    SERVICE_TABLEWITHWAGES("Table with pages"),
    SERVICE_DIFFERENTELEMENTS("Different elements");

    public String text;

    SubMenuServicesEnum(String text) {
        this.text = text;
    }
}
