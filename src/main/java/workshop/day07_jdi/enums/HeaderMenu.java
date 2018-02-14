package workshop.day07_jdi.enums;

public enum HeaderMenu {
    PRODUCT_DEVELOPMENT("Product Development"),
    ENGINEERING_EXCELLENCE("Engineering Excellence"),
    CORE_TECHNOLOGIES("Core Technologies"),
    ASSURANCE("Assurance");

    public String value;
    HeaderMenu(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
