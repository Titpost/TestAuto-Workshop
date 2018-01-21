package enums.differentElementsPage;


public enum CheckboxLabelsEnum {

    CHECKBOXES_WATER("Water"),
    CHECKBOXES_EARTH("Earth"),
    CHECKBOXES_WIND("Wind"),
    CHECKBOXES_FIRE("Fire");

    public String label;

    CheckboxLabelsEnum(String label) {
        this.label = label;
    }
}
