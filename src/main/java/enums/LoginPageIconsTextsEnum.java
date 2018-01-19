package enums;

public enum LoginPageIconsTextsEnum {

    ICON_PRACTICE("icon-practise", "To include good practices and ideas from successful EPAM projec"),
    ICON_CUSTOM("icon-custom", "To be flexible and customizable"),
    ICON_MULTI("icon-multi", "To be multiplatform"),
    ICON_BASE("icon-base", "Already have good base (about 20 internal and " +
            "some external projects), wish to get more…");

    public String icon;
    public String text;

    LoginPageIconsTextsEnum(String icon, String text) {
        this.icon = icon;
        this.text = text;
    }
}
