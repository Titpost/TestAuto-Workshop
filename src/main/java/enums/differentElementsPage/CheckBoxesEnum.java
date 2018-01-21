package enums.differentElementsPage;


public enum CheckBoxesEnum {

    CHECKBOXES_WATER("Water"),
    CHECKBOXES_EARTH("Earth"),
    CHECKBOXES_WIND("Wind"),
    CHECKBOXES_FIRE("Fire");

    public String element;

    CheckBoxesEnum(String element) {
        this.element = element;
    }
}
