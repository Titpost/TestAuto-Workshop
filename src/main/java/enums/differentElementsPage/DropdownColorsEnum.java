package enums.differentElementsPage;


public enum DropdownColorsEnum {

    DROPDOWN_ITEM_RED("Red"),
    DROPDOWN_ITEM_GREEN("Green"),
    DROPDOWN_ITEM_BLUE("Blue"),
    DROPDOWN_ITEM_YELLOW("Yellow");

    public String color;

    DropdownColorsEnum(String color) {
        this.color = color;
    }
}
