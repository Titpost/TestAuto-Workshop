package enums;

public enum LoginPageIconsTextsEnum {

    TEXT_1("icon-practise", "To include good practices and ideas from successful EPAM projec"),
    TEXT_2("icon-custom", "To be flexible and customizable"),
    TEXT_3("icon-multi", "To be multiplatform"),
    TEXT_4("icon-base", "Already have good base (about 20 internal and " +
            "some external projects), wish to get more…");

    public String icon;
    public String text;

    LoginPageIconsTextsEnum(String icon, String text) {
        this.icon = icon;
        this.text = text;
    }
}
